package com.bpmw.web.controllers.task;

import com.bpmw.persistence.PriorityTask;
import com.bpmw.web.model.task.PriorityTaskModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@RequestScoped
public class PriorityTaskController {

    @Inject
    private PriorityTaskModel priorityTaskModel;

    private List<PriorityTask> priorityTasksList;

    @PostConstruct
    public void init(){
        priorityTasksList = priorityTaskModel.returnAllPriorityTask();
    }

    public List<PriorityTask> getPriorityTasksList() {
        return priorityTasksList;
    }

    public void setPriorityTasksList(List<PriorityTask> priorityTasksList) {
        this.priorityTasksList = priorityTasksList;
    }
}
