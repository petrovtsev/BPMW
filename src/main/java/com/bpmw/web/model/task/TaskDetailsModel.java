package com.bpmw.web.model.task;

import com.bpmw.persistence.Task;
import com.bpmw.services.MailService;
import com.bpmw.services.TaskService;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * The method used for the task.
 */
@Named
@RequestScoped
public class TaskDetailsModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserModel userModel;

    @Inject
    private MailService mailService;

    /**
     * The selected task
     */
    private Task selectedTask;

    /**
     * The method used to obtain the task by ID.
     * @param id - id task.
     * @return - task object.
     */
    public Task getTask(Integer id){
        selectedTask = taskService.getTask(id);
        return selectedTask;
    }

    /**
     * The method serves to close tasks.
     * The method assigns the field 'completion date' current date. And save the changes.
     * In the case of e-mail sent to the specified address a message with information about the task.
     */
    public void closeTask(){
        Date date = new Date();
        selectedTask.setDateComplet(date);
        taskService.updTask(selectedTask);
        if (selectedTask.getEmail() != null) {
            if (selectedTask.getComment() == null){ selectedTask.setComment(" ");}
            String msg = "Task №-" + selectedTask.getId() + ", " + selectedTask.getName()
                    + "\n\nReceipt date: " + selectedTask.getDateIn()
                    + ";\n\nText: \"" + selectedTask.getTextTask()
                    + "\"\n-------------------------------------------------------------" +
                    "--------------------------------------" +
                    "\n\nTask completed successfully." +
                    "\n\nCommentary on the implementation of: "
                    + selectedTask.getComment()
                    + "\n\nThe task performed by "
                    + selectedTask.getUserComplet().getFirstName() + " "
                    + selectedTask.getUserComplet().getLastName();
            mailService.send("Task completed", msg, selectedTask.getEmail());
        }
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
}