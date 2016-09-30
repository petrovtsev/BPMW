package com.bpmw.web.model;

import com.bpmw.persistence.Group;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;
import com.bpmw.services.TaskService;
import com.bpmw.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */
@Named
@RequestScoped
public class UserModel {
    private List<User> userList;
    private Integer id = 1;

    @Inject
    private UserService userService;

    public Group getUserGroup(){
        return userService.getUserGroup(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
