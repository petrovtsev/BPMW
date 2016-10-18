package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.services.TaskService;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class TaskDetailsModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserModel userModel;

    private Task selectedTask;

    public Task getTask(Integer id){
        selectedTask = taskService.getTask(id);
        return selectedTask;
    }

    public void closeTask(){
        Date date = new Date();
        selectedTask.setDateComplet(date);
        taskService.updTask(selectedTask);
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
}