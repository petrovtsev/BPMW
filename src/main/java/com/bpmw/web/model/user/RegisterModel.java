package com.bpmw.web.model.user;

import com.bpmw.persistence.User;
import com.bpmw.services.UserService;
import com.bpmw.services.ValidateService;
import com.bpmw.web.model.group.TaskGroupModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * @author ppetr
 * @version 1.0
 * This class is used for user registration.
 */

@Named
@Stateless
public class RegisterModel {

    @EJB
    private UserService userService;

    @EJB
    private TaskGroupModel taskGroupModel;

    @EJB
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

    public String userDataCheck(User user) {
        StringBuffer message = new StringBuffer();
        Boolean check = false;
        if (checkingLogin(user.getLogin()) == "false") {
            check = true;
            message.append("Username is not available.\n");
        }
        if (taskGroupModel.getTaskGroup(user.getTaskGroup().getId()) == null) {
            check = true;
            message.append("Groups do not exist.\n");
        }
        Date date = new Date();
        if (date.before(user.getDateBirth())) {
            check = true;
            message.append("Date of birth is incorrect.\n");
        }
        if (check) {
            errorMessage = message.toString();
            return message.toString();
        } else
            return "true";
    }

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
