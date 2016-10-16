package com.bpmw.web.model.user;

import com.bpmw.persistence.User;
import com.bpmw.persistence.View;
import com.bpmw.services.UserService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.view.ViewModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class UserModel{

    private User activeUser;
    private List<View> viewsActiveUser;

    @EJB
    private TaskGroupModel taskGroupModel;

    @EJB
    private ViewModel viewModel;

    @EJB
    private UserService userService;

    public List<User> returnAllUsers(){
        return userService.returnAllUsers();
    }


    public User getUser(String login){
        activeUser = userService.getUser(login);
        return activeUser;
    }

    public void returnViewsActiveUser(String login){
        viewsActiveUser = viewModel.returnViewUser(login);
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

    public List<View> getViewsActiveUser() {
        return viewsActiveUser;
    }

    public void setViewsActiveUser(List<View> viewsActiveUser) {
        this.viewsActiveUser = viewsActiveUser;
    }
}