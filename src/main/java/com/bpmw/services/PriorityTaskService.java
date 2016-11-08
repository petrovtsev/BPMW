package com.bpmw.services;

import com.bpmw.persistence.PriorityTask;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The class is for priority tasks.
 * @author ppetr
 * @version 1.0
 */
@Stateless
public class PriorityTaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the possible priorities of tasks.
     * @return - PriorityTask list.
     */
    public List<PriorityTask> returnAllPriorityTask(){
        List<PriorityTask> resultList = em.createNamedQuery("PriorityTask.findAll", PriorityTask.class).getResultList();
        return resultList;
    }

    /**
     * The method returns the priority of the task using id.
     * @param id - id priority.
     * @return - object PriorityTask.
     */
    public PriorityTask getPriorityTask(Integer id){
        return em.find(PriorityTask.class, id);
    }

}