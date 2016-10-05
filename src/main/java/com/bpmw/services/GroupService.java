package com.bpmw.services;

import com.bpmw.persistence.Group;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Named
@ApplicationScoped
public class GroupService{

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;


    public List<Group> returnAllGroups(){
        List<Group> resultList = em.createNamedQuery("Group.findAll", Group.class).getResultList();
        return resultList;
    }

    public void addGroup (Group group){
        em.persist(group);
    }

    public void delGroup(Integer id){
        Group group = em.find(Group.class, id);
        em.remove(group);
    }

    public Group getGroup(Integer id){
        return em.find(Group.class, id);
    }

    public void updGriup (Group group){
        em.merge(group);
    }
}

