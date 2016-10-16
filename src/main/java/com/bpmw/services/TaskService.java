package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;
import com.bpmw.persistence.UserRequest;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.transaction.cdi.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Named
@Stateless
public class TaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    public List<Task> returnAllTasks(){
        List<Task> resultList = em.createNamedQuery("Task.findAll", Task.class)
            .getResultList();
        return resultList; 
    }

    public List<Task> returnUserTasks(TaskGroup taskGroup){
        Query query = em.createNamedQuery("Task.findTaskUser", Task.class);
        query.setParameter("idGroup", taskGroup.getId());
        List<Task> resultList = query.getResultList();
        return resultList;
    }

    public List<Task> returTasksQuery(TaskGroup taskGroup, UserRequest userRequest){
        Query query = em.createNamedQuery("Task.findTaskUserQuery", Task.class);
        query.setParameter("idGroup", taskGroup.getId());
        query.setParameter("dateStart", userRequest.getDateStart());
        List<Task> resultList = query.getResultList();
        return resultList;
    }

    public void addTask(Task task){
        em.persist(task);
    }

    public void delTask(Integer id){
        Task task = em.find(Task.class, id);
        em.remove(task);
    }

    public Map graphs(String login, Map graph){
        Query query = em.createNamedQuery("Task.findStatisticData", Task.class);
        query.setParameter("login", login);
        List<Object[]> result = query.getResultList();
        for (Iterator i = result.iterator(); i.hasNext();){
            Object[] values = (Object[])i.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,M,d");
            graph.put(dateFormat.format(values[0]),values[1]);
        }
        return graph;
    }

    public Task getTask(Integer id){
        return em.find(Task.class, id);
    }

    public void updTask(Task task){
        em.merge(task);
    }
}