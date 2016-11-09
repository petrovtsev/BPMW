package com.bpmw.web.model.task;

import com.bpmw.persistence.PriorityTask;
import com.bpmw.services.PriorityTaskService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PriorityTaskModel {

    @Inject
    PriorityTaskService priorityTaskService;

    public PriorityTask getPriorityTask(Integer id){
        return priorityTaskService.getPriorityTask(id);
    }

    public List<PriorityTask> returnAllPriorityTask(){
        return priorityTaskService.returnAllPriorityTask();
    }
}