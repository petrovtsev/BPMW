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
    private Integer selectedTaskID = 1;

    @Inject
    private TaskService taskService;

    private Task selectedTask;

    public List<Task> returnAllTasks(){
        return taskService.returnAllTasks();
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

    public Integer getSelectedTaskID() {
        return selectedTaskID;
    }

    public void setSelectedTaskID(Integer selectedTaskID) {
        this.selectedTaskID = selectedTaskID;
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
}
