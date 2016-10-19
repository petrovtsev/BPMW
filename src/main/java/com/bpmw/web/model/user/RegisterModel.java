package com.bpmw.web.model.user;

import com.bpmw.persistence.User;
import com.bpmw.services.UserService;
import com.bpmw.services.ValidateService;
import com.bpmw.web.model.group.TaskGroupModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

/**
 * @author ppetr
 * @version 1.0
 * This class is used for user registration.
 */

@Named
@RequestScoped
public class RegisterModel {

    @Inject
    private UserService userService;

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private ValidateService validateService;

    User user;

    public void init(){
        user = new User();
    }

    public Boolean validate(){
        return validateService.validate(user);
    }

    public void addUser() {
        userService.addUser(user);
    }

    /**
     * The method receives a user login and returns false if the username is busy.
     *
     * @param login - login to check
     * @return - message (false if the username is not available, an empty string if the login is free)
     */
    public String checkingLogin(String login) {
        String message = " ";
        if (userService.getUser(login) != null) {
            message = "false";
        }
        return message;
    }

    String errorMessage = "true";

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}