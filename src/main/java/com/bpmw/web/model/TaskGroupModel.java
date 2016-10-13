package com.bpmw.web.model;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.TaskGroupService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */

@RequestScoped
@Named
public class TaskGroupModel {

    @Inject
    private TaskGroupService taskGroupService;

    public TaskGroup getTaskGroup(Integer id){
        return taskGroupService.getGroup(id);
    }

    public List<TaskGroup> returnAllGroups(){
        return taskGroupService.returnAllGroups();
    }
}