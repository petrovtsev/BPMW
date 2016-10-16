package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.persistence.UserRequest;
import com.bpmw.services.TaskService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ViewModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@Stateless
public class TaskDetailsModel {

    @EJB
    private TaskService taskService;

    @EJB
    private UserModel userModel;

    private Task selectedTask;

    public Task getTask(Integer id){
        return taskService.getTask(id);
    }

    public void closeTask(Integer idTask, String login, String comment){
        Date date = new Date();
        selectedTask = getTask(Integer.valueOf(idTask));
        selectedTask.setDateComplet(date);
        selectedTask.setComment(comment);
        User user = userModel.getUser(login);
        selectedTask.setUserComplet(user);
        taskService.updTask(selectedTask);
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
}