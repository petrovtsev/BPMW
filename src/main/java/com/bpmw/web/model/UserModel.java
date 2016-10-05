package com.bpmw.web.model;

import com.bpmw.persistence.User;
import com.bpmw.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserModel{

    @Inject
    private UserService userService;

    public List<User> returnAllUser(){
        return userService.returnAllUser();
    }

    public User returnGetUser(String login){
        return userService.getUser(login);
    }

    public void addUser(User user){
        userService.addUser(user);
    }

    public void delUser(String login){
        userService.delUser(login);
    }

    public void updUser(User user){
        userService.updUser(user);
    }
}
