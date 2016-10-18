package com.bpmw.web.model.user;

import com.bpmw.persistence.User;
import com.bpmw.services.UserService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.view.ViewDetailsModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserModel{

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private ViewDetailsModel viewModel;

    @Inject
    private UserService userService;

    private User activeUser;

    public List<User> returnAllUsers(){
        return userService.returnAllUsers();
    }


    public User getUser(String login){
        activeUser = userService.getUser(login);
        return activeUser;
    }

    public void delUser(String login){
        userService.delUser(login);
    }

    public void updUser(User user){
        userService.updUser(user);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}