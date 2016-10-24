package com.bpmw.web.model.user;

import com.bpmw.persistence.User;
import com.bpmw.services.UserService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.view.ViewDetailsModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * The class is used to work with user data
 */
@Named
@RequestScoped
public class UserModel{

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private ViewDetailsModel viewModel;

    @Inject
    private UserService userService;

    /**
     * Active user
     */
    private User activeUser;

    /**
     * The method returns an object of type "user".
     * The parameter takes:
     * @param login - username.
     * @return - object of type "user"
     */
    public User getUser(String login){
        activeUser = userService.getUser(login);
        return activeUser;
    }

    /**
     * The method removes the user. The parameter accepts:
     * @param login - username.
     */
    public void delUser(String login){
        userService.delUser(login);
    }

    /**
     * The method updates the user data.
     * The parameter accepts:
     * @param user - object of type "user".
     */
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