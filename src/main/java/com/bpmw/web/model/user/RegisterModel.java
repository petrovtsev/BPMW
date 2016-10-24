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

    /**
     * The new user
     */
    User user;

    /**
     * The method initializes the object.
     */
    public void init(){
        user = new User();
    }

    /**
     * Method to check the data and returns a Boolean value (true, in case of an error)
     * @return - Boolean value.
     */
    public Boolean validate(){
        return validateService.validate(user);
    }

    /**
     * The method create a new user.
     */
    public void addUser() {
        userService.addUser(user);
    }

    /**
     * The method used to check the user's login employment     *
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}