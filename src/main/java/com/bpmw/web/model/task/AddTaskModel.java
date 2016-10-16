package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.TaskService;
import com.bpmw.web.model.group.TaskGroupModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.text.ParseException;
import java.util.*;

@Named
@Stateless
public class AddTaskModel {

    @EJB
    private TaskService taskService;

    @EJB
    private TaskGroupModel groupModel;

    private String message = "Describe the problem";

    public void addTask(String name, String textTask, Integer groupId) throws ParseException {
        TaskGroup taskGroup = groupModel.getTaskGroup(groupId);
        Date date = new Date();
        Task newTask = new Task(name, textTask, taskGroup, date);
        taskService.addTask(newTask);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}