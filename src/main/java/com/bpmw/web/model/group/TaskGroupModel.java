package com.bpmw.web.model.group;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.TaskGroupService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */

@Named
@Stateless
public class TaskGroupModel {

    @EJB
    private TaskGroupService taskGroupService;

    public TaskGroup getTaskGroup(Integer id){
        return taskGroupService.getGroup(id);
    }

    public List<TaskGroup> returnAllGroups(){
        return taskGroupService.returnAllGroups();
    }
}