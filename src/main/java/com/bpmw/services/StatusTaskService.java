package com.bpmw.services;

import com.bpmw.persistence.StatusTask;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The class is used to work with the status of tasks.
 * @author ppetr
 * @version 1.0
 */
@Stateless
public class StatusTaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the possible statuses of tasks.
     * @return - StatusTask list.
     */
    public List<StatusTask> returnAllStatusTask(){
        List<StatusTask> resultList = em.createNamedQuery("StatusTask.findAll", StatusTask.class).getResultList();
        return resultList;
    }

    /**
     * The method returns the task status using id.
     * @param id - id status.
     * @return - object StatusTask.
     */
    public StatusTask getStatusTask(Integer id){
        return em.find(StatusTask.class, id);
    }

}