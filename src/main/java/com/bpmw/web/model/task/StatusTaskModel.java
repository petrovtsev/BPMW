package com.bpmw.web.model.task;

import com.bpmw.persistence.StatusTask;
import com.bpmw.services.StatusTaskService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class StatusTaskModel {

    @Inject
    private StatusTaskService statusTaskService;

    public StatusTask getStatusTask(Integer id){
        return statusTaskService.getStatusTask(id);
    }

    public List<StatusTask> returnAllStatusTask(){
        return statusTaskService.returnAllStatusTask();
    }
}
