package com.bpmw.services;

import com.bpmw.persistence.User;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * The class is used to store information about the active user
 * @author ppetr
 * @version 1.0
 */
@SessionScoped
public class SessionUserService implements Serializable{

    /**
     * Active User
     */
    private User user;

    /**
     * Getters and setters
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}