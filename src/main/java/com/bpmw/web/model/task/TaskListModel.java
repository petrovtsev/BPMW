package com.bpmw.web.model.task;

import com.bpmw.persistence.*;
import com.bpmw.services.TaskService;
import com.bpmw.web.model.view.ViewDetailsModel;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
@RequestScoped
public class TaskListModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserModel userModel;

    @Inject
    private TaskGroupModel groupModel;

    @Inject
    private ViewDetailsModel viewModel;

    private Task selectedTask;
    private List<Task> userTasks;
    private TaskGroup taskGroup;

    public List<Task> returnAllTasks(){
        return taskService.returnAllTasks();
    }

    public void returnUserTasks(String login){
        taskGroup = userModel.getUser(login).getTaskGroup();
        userTasks = taskService.returnUserTasks(taskGroup);
    }

    public Task getTask(Integer id){
        return taskService.getTask(id);
    }

    public void delTask(Integer id){
        taskService.delTask(id);
    }

    public void returTasksQuery(String login, Integer viewId){
        View view = viewModel.getView(viewId);
        taskGroup = userModel.getUser(login).getTaskGroup();
        userTasks = taskService.returTasksQuery(taskGroup, view);
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<Task> userTasks) {
        this.userTasks = userTasks;
    }

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }
}