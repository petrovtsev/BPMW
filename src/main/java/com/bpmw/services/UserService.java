package com.bpmw.services;

import com.bpmw.persistence.Group;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */
@Named
@ApplicationScoped
public class UserService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;


    public List<User> returnAllUser(){
        List<User> resultList = em.createNamedQuery("User.findAll", User.class)
                .getResultList();
        return resultList;
    }

    public void addUser(User user){
        em.persist(user);
    }

    public void delUser(Integer id){
        User user = em.find(User.class, id);
        em.remove(user);
    }

    public User getUser(Integer id){
        return em.find(User.class, id);
    }


    public void updUser(User user){
        em.merge(user);
    }

}
