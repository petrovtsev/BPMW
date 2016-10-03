package com.bpmw.web.model;

import com.bpmw.persistence.Task;
import com.bpmw.services.TaskService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class TaskModel {
    private List<Task> taskList;

    private Task newTask;

    private String selectedTaskList = "#{taskModel.returnAllTasks()}";

    @Inject
    private TaskService taskService;

    @Inject
    private UserModel userModel;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService authorService){
        this.taskService = authorService;
        }

    public List<Task> returnAllTasks(){
        return getTaskService().returnAllTasks();
    }

    public void addTask(){
        taskService.addTask(newTask);
    }

    public void delTask(Integer id){
        taskService.delTask(id);
    }

    public void updTask(Task task){
        taskService.updTask(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getSelectedTaskList() {
        return selectedTaskList;
    }

    public void setSelectedTaskList(String selectedTaskList) {
        this.selectedTaskList = selectedTaskList;
    }

    public Task getNewTask() {
        return newTask;
    }

    public void setNewTask(Task newTask) {
        this.newTask = newTask;
    }
}
