package com.bpmw.web.controllers.group;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.web.model.group.TaskGroupModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * The class is used to work with the task teams.
 * @author ppetr
 * @version 1.0
 */
@ManagedBean
@RequestScoped
public class GroupController {

    @Inject
    private TaskGroupModel taskGroupModel;

    /**
     * Task List Group.
     */
    private List<TaskGroup> listTaskGroup;

    /**
     * Task list initialization.
     */
    @PostConstruct
    public void init() {
        listTaskGroup = taskGroupModel.returnAllGroups();
    }

    public List<TaskGroup> getListTaskGroup() {
        return listTaskGroup;
    }

    public void setListTaskGroup(List<TaskGroup> listTaskGroup) {
        this.listTaskGroup = listTaskGroup;
    }
}
