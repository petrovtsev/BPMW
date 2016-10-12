package com.bpmw.web.model;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.persistence.View;
import com.bpmw.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.security.acl.Group;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class UserModel{

    private User activeUser;
    private List<View> viewsActiveUser;

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private ViewModel viewModel;

    @Inject
    private UserService userService;

    public List<User> returnAllUsers(){
        return userService.returnAllUsers();
    }

    public String checkingLogin(String login){
        String message = " ";
        for (User user : returnAllUsers()){
            if (user.getLogin().hashCode() == login.hashCode()) {
                message = "false";
            }
        }
        return message;
    }


    public User getUser(String login){
        activeUser = userService.getUser(login);
        return activeUser;
    }

    public void returnViewsActiveUser(String login){
        viewsActiveUser = viewModel.returnViewUser(getUser(login));
    }

    public void addUser(String login, String password, String firstName, String lastName,
                        String dateBirthString, String city, String taskGroupId, String phone, String mail)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateBirth = dateFormat.parse(dateBirthString);
        TaskGroup taskGroup = taskGroupModel.getTaskGroup(Integer.valueOf(taskGroupId));
        User user = new User(login, password, firstName, lastName, dateBirth, city, taskGroup, phone, mail);
        userService.addUser(user);
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
