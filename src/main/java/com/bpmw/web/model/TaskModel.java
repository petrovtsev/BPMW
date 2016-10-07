package com.bpmw.web.model;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.TaskService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.security.acl.Group;
import java.util.List;

@Named
@RequestScoped
public class TaskModel {
    private List<Task> taskList;

    @Inject
    private UserModel userModel;

    @Inject
    private TaskService taskService;

    private Task selectedTask;
    private List<Task> userTasks;
    private String nameUserGroup;

    public List<Task> returnAllTasks(){
        return taskService.returnAllTasks();
    }

    public void returnUserTasks(String userId){
        TaskGroup userGroup = userModel.returnGetUser(userId).getTaskGroup();
        nameUserGroup = userGroup.getName();
        userTasks = taskService.returnUserTasks(userGroup);
    }

    public Task getTask(Integer id){
        return taskService.getTask(id);
    }

    public void addTask(Task task){
        taskService.addTask(task);
    }

    public void delTask(Integer id){
        taskService.delTask(id);
    }

    public void updTask(){
        taskService.updTask(selectedTask);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
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

    public String getNameUserGroup() {
        return nameUserGroup;
    }

    public void setNameUserGroup(String nameUserGroup) {
        this.nameUserGroup = nameUserGroup;
    }
}
