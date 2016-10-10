package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.Task;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Named
@RequestScoped
public class TaskService {


    private EntityManager em = Persistence.createEntityManagerFactory("persistence").createEntityManager();


    public List<Task> returnAllTasks(){
        List<Task> resultList = em.createNamedQuery("Task.findAll", Task.class)
            .getResultList();
        return resultList; 
    }

    public List<Task> returnUserTasks(TaskGroup taskGroup){
        String query = "select t from Task t WHERE t.taskGroup.id = " + taskGroup.getId();
        List<Task> resultList = em.createQuery(query, Task.class)
                .getResultList();
        return resultList;
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

    public void updTask(Task task){
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
    }

}

