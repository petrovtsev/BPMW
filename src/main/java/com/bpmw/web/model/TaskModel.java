package com.bpmw.web.model;

import com.bpmw.persistence.Task;
import com.bpmw.services.TaskService;
import java.util.List;

public class TaskModel {

    private TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService authorService){
        this.taskService = authorService;
        }

    public List<Task> returnAllTasks(){
        return getTaskService().returnAllTasks();
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
}
