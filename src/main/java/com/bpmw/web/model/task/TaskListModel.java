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

/**
 * The class is used to work with a task list.
 */
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

    /**
     * The selected task
     */
    private Task selectedTask;

    /**
     * User tasks.
     */
    private List<Task> userTasks;

    /**
     * Group of the user
     */
    private TaskGroup taskGroup;

    /**
     * Method returns a list of all tasks of the base.
     * @return - list all tasks of the base.
     */
    public List<Task> returnAllTasks(){
        return taskService.returnAllTasks();
    }

    /**
     * Method returns a list of all tasks of the selected user.
     * @param login - user login.
     */
    public void returnUserTasks(String login){
        taskGroup = userModel.getUser(login).getTaskGroup();
        userTasks = taskService.returnUserTasks(taskGroup);
    }

    /**
     * The method receives a list of the tasks requested by the user.
     * As the parameters takes:
     * @param login - user login.
     * @param viewId - id view.
     */
    public void returTasksQuery(String login, Integer viewId){
        View view = viewModel.getView(viewId);
        taskGroup = userModel.getUser(login).getTaskGroup();
        userTasks = taskService.returTasksQuery(taskGroup, view);
    }

    public Task getTask(Integer id){
        return taskService.getTask(id);
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