package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;
import com.bpmw.persistence.UserRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.transaction.cdi.Transactional;
import java.util.List;

@Named
@RequestScoped
public class TaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    public List<Task> returnAllTasks(){
        List<Task> resultList = em.createNamedQuery("Task.findAll", Task.class)
            .getResultList();
        return resultList; 
    }

    @Transactional(value = Transactional.TxType.REQUIRED,
            rollbackOn = {},
            dontRollbackOn = {})
    public List<Task> returnUserTasks(TaskGroup taskGroup){
        String query = "select t from Task t WHERE t.taskGroup.id = " + taskGroup.getId();
        List<Task> resultList = em.createQuery(query, Task.class)
                .getResultList();
        return resultList;
    }

    public List<Task> returTasksQuery(User user, UserRequest userRequest){
        String statusComplete = userRequest.getStatusComplete();
        if (statusComplete == "completed") {
            statusComplete = " AND t.t.dateComplet NOT NULL;";
        } else if (statusComplete == "notCompleted") {
            statusComplete = " AND t.t.dateComplet = NULL;";
        } else statusComplete = "";
        Query query = em.createQuery("select t from Task t WHERE t.taskGroup.id = :groupId AND " +
                "(t.dateIn > :dateStart AND t.dateIn < :dateEnd)" + statusComplete);
        query.setParameter("groupId", user.getTaskGroup());
        query.setParameter("dateStart", userRequest.getDateStart());
        query.setParameter("dateEnd", userRequest.getDateEnd());
        query.setParameter("statusComplete", userRequest.getDateEnd());
        return query.getResultList();
    }

    public void addTask(Task task){
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }

    public void delTask(Integer id){
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        em.remove(task);
        em.getTransaction().commit();
    }

    public Task getTask(Integer id){
        return em.find(Task.class, id);
    }

    @Transactional(value = Transactional.TxType.REQUIRED,
            rollbackOn = {},
            dontRollbackOn = {})
    public void updTask(Task task){
        em.merge(task);
    }

}