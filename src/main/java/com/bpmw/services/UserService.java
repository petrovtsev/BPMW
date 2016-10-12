package com.bpmw.services;

import com.bpmw.persistence.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */
@Named
@ApplicationScoped
public class UserService {

    private EntityManager em = Persistence.createEntityManagerFactory("persistence").createEntityManager();

    public List<User> returnAllUsers(){
        List<User> resultList = em.createNamedQuery("User.findAll", User.class)
                .getResultList();
        return resultList;
    }

    public void addUser(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void delUser(String login){
        User user = em.find(User.class, login);
        em.remove(user);
    }

    public User getUser(String userId){
        return em.find(User.class, userId);
    }

    public void updUser(User user){
        em.merge(user);
    }
}
