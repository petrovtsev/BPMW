package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.services.TaskService;
import com.bpmw.services.ValidateService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
@RequestScoped
public class AddTaskModel {

    @Inject
    private TaskService taskService;

    @Inject
    private ValidateService validateService;

    private Task task;

    private Boolean messageStatus = false;

    public void init(){
        task = new Task();
    }

    public Boolean validate(){
        return validateService.validate(task);
    }


    public void addTask(){
        Date date = new Date();
        task.setDateIn(date);
        taskService.addTask(task);
        messageStatus = true;
        init();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Boolean getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Boolean messageStatus) {
        this.messageStatus = messageStatus;
    }
}