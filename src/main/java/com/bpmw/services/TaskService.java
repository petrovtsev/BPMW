package com.bpmw.services;

import com.bpmw.persistence.Group;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Named
@ApplicationScoped
public class TaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;


    public List<Task> returnAllTasks(){
        List<Task> resultList = em.createNamedQuery("Task.findAll", Task.class)
            .getResultList();
        return resultList;
    }

    public List<Task> returnUserTasks(Group group){
        List<Task> resultList = em.createQuery("select t from Task t where Group = " + group, Task.class)
                .getResultList();
        return resultList;
    }

    public void addTask(Task task){
        em.persist(task);
    }

    public void delTask(Integer id){
        Task task = em.find(Task.class, id);
        em.remove(task);
    }

    public Task getTask(Integer id){
        return em.find(Task.class, id);
    }

    public void updTask(Task task){
        em.merge(task);
    }

}

