package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Named
@ApplicationScoped
public class TaskGroupService {

    private EntityManager em = Persistence.createEntityManagerFactory("persistence").createEntityManager();


    public List<TaskGroup> returnAllGroups(){
        List<TaskGroup> resultList = em.createNamedQuery("Group.findAll", TaskGroup.class).getResultList();
        return resultList;
    }

    public void addGroup (TaskGroup taskGroup){
        em.persist(taskGroup);
    }

    public void delGroup(Integer id){
        TaskGroup taskGroup = em.find(TaskGroup.class, id);
        em.remove(taskGroup);
    }

    public TaskGroup getGroup(Integer id){
        return em.find(TaskGroup.class, id);
    }

    public void updGriup (TaskGroup taskGroup){
        em.merge(taskGroup);
    }
}

