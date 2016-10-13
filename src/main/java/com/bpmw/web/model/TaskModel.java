package com.bpmw.web.model;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.persistence.UserRequest;
import com.bpmw.services.TaskService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class TaskModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserModel userModel;

    @Inject
    private TaskGroupModel groupModel;

    @Inject
    private ViewModel viewModel;

    private Task selectedTask;
    private List<Task> userTasks;
    private TaskGroup taskGroup;
    private String message;

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

    public void addTask(String name, String textTask, String groupId) throws ParseException {
        TaskGroup taskGroup = groupModel.getTaskGroup(Integer.valueOf(groupId));
        Date date = new Date();
        Task newTask = new Task(name, textTask, taskGroup, date);
        taskService.addTask(newTask);
    }

    public void delTask(Integer id){
        taskService.delTask(id);
    }

    public void updTask(Integer idTask, String login){
        Date date = new Date();
        selectedTask = getTask(Integer.valueOf(idTask));
        selectedTask.setDateComplet(date);
        User user = userModel.getUser(login);
        selectedTask.setUserComplet(user);
        taskService.updTask(selectedTask);
    }

    public void returTasksQuery(String login, Integer viewId){
        User user = userModel.getUser(login);
        UserRequest userRequest = viewModel.getView(viewId).getUserRequest();
        userTasks = taskService.returTasksQuery(user, userRequest);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}