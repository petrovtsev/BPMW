package com.bpmw.web.controllers.task;

import com.bpmw.persistence.StatusTask;
import com.bpmw.web.model.task.StatusTaskModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@RequestScoped
public class StatusTaskController {

    @Inject
    private StatusTaskModel statusTaskModel;

    private List<StatusTask> statusTasksList;

    @PostConstruct
    public void init(){
        statusTasksList = statusTaskModel.returnAllStatusTask();
    }

    public List<StatusTask> getStatusTasksList() {
        return statusTasksList;
    }

    public void setStatusTasksList(List<StatusTask> statusTasksList) {
        this.statusTasksList = statusTasksList;
    }
}
