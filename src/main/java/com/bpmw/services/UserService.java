package com.bpmw.services;

import com.bpmw.persistence.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class to work with a database model.
 * @author ppetr
 * @version 1.0
 */
@Stateless
public class UserService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the users of a database.
     * @return - Users list.
     */
    public List<User> returnAllUsers(){
        List<User> resultList = em.createNamedQuery("User.findAll", User.class)
                .getResultList();
        return resultList;
    }

    /**
     * The method is used to add a new user. It takes as parameter user,
     * and makes an entry in the database
     * @param user - object (User).
     */
    public void addUser(User user){
        em.persist(user);
    }

    /**
     * The method is used to delete a user.
     * Accepts a user login, searches for the desired record in the database and deletes.
     * @param login - user login.
     */
    public void delUser(String login){
        User user = em.find(User.class, login);
        em.remove(user);
    }

    /**
     * The method used to obtain a user at login
     * It takes as a parameter the user login is looking for the desired
     * entry in the database and returns the object type User.
     * @param login - user login.
     * @return - object (User).
     */
    public User getUser(String login){
        return em.find(User.class, login);
    }

    /**
     * The method is used to update the existing user.
     * The parameter takes user object and updates the corresponding record in the database.
     * @param user - object (User).
     */
    public void updUser(User user){
        em.merge(user);
    }
}