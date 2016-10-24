package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.services.TaskService;
import com.bpmw.services.ValidateService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

/**
 * The class is used to add new tasks.
 */
@Named
@RequestScoped
public class AddTaskModel {

    @Inject
    private TaskService taskService;

    @Inject
    private ValidateService validateService;

    /**
     * The new task
     */
    private Task task;

    /**
     * The method initializes the object.
     */
    public void init(){
        task = new Task();
    }

    /**
     * Method to check the data and returns a Boolean value (true, in case of an error)
     * @return - Boolean value.
     */
    public Boolean validate(){
        return validateService.validate(task);
    }


    /**
     * The method fills the 'date of receipt' and create a new task.
     */
    public void addTask(){
        Date date = new Date();
        task.setDateIn(date);
        taskService.addTask(task);
        init();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}