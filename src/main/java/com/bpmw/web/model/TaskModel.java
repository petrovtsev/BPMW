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

    @Inject
    private TaskService taskService;

    public List<Task> returnAllTasks(){
        return taskService.returnAllTasks();
    }

    public void addTask(Task task){
        taskService.addTask(task);
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
}
