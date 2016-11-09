package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

/**
 * Class to work with a database model.
 * @author ppetr
 * @version 1.0
 */
@Stateless
public class TaskGroupService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the groups of tasks from the database.
     * @return - Task list group.
     */
    public List<TaskGroup> returnAllGroups(){
        List<TaskGroup> resultList = em.createNamedQuery("Group.findAll", TaskGroup.class).getResultList();
        return resultList;
    }

    /**
     * The method is used to add a new task group. It takes as parameter group,
     * and makes an entry in the database
     * @param taskGroup - object (Task Group).
     */
    public void addGroup (TaskGroup taskGroup){
        em.persist(taskGroup);
    }

    /**
     * The method is used to delete a group of tasks.
     * Takes as group id of the task parameters, searches for the desired group, and deletes.
     * @param id - id group tasks.
     */
    public void delGroup(Integer id){
        TaskGroup taskGroup = em.find(TaskGroup.class, id);
        em.remove(taskGroup);
    }

    /**
     * The method used to obtain group tasks by id.
     * It takes as parameter the identifier group task looking for the group and returns object.
     * @param id - id group tasks.
     * @return - object (Task Group).
     */
    public TaskGroup getGroup(Integer id){
        return em.find(TaskGroup.class, id);
    }

    /**
     * The method is used to update the existing group tasks.
     * The parameter takes TaskGroup object and updates the corresponding record in the database.
     * @param taskGroup - object (Task Group).
     */
    public void updGriup (TaskGroup taskGroup){
        em.merge(taskGroup);
    }
}