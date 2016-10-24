package com.bpmw.web.model.group;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.TaskGroupService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * The class is used to work with the task teams.
 */
@Named
@RequestScoped
public class TaskGroupModel {

    @Inject
    private TaskGroupService taskGroupService;

    /**
     * The method returns the desired group on the task ID.
     * As the parameters takes:
     * @param id - id group.
     * @return - object type TaskGroup.
     */
    public TaskGroup getTaskGroup(Integer id){
        return taskGroupService.getGroup(id);
    }

    /**
     * The method returns a list of all groups.
     * @return list object group.
     */
    public List<TaskGroup> returnAllGroups(){
        return taskGroupService.returnAllGroups();
    }
}