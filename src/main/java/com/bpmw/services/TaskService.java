package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.Task;
import com.bpmw.persistence.View;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class to work with a database model.
 */
@Stateless
public class TaskService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the tasks of a database.
     * @return - Task list.
     */
    public List<Task> returnAllTasks(){
        List<Task> resultList = em.createNamedQuery("Task.findAll", Task.class)
            .getResultList();
        return resultList; 
    }

    /**
     * This method returns a tasks group from the database.
     * It accepts as a parameter TaskGroup object and looks for all the problems of this group.
     * @param taskGroup - object (Task Group).
     * @return - Task list.
     */
    public List<Task> returnUserTasks(TaskGroup taskGroup){
        Query query = em.createNamedQuery("Task.findTaskUser", Task.class);
        query.setParameter("idGroup", taskGroup.getId());
        List<Task> resultList = query.getResultList();
        return resultList;
    }

    /**
     * The method is used to get the list of tasks for a given request.
     * As the parameters takes TaskGroup object and object request.
     * @param taskGroup - object (Task Group).
     * @param view - object (View). The object contains the parameters necessary for the database query.
     * @return - list task.
     */
    public List<Task> returTasksQuery(TaskGroup taskGroup, View view){
        Query query = em.createNamedQuery("Task.findTaskUserQuery", Task.class);
        query.setParameter("idGroup", taskGroup.getId());
        query.setParameter("dateStart", view.getDateStart());
        query.setParameter("dateEnd", view.getDateEnd());
        List<Task> resultList = query.getResultList();
        return resultList;
    }

    /**
     * The method is used to add a new task. It takes as parameter task,
     * and makes an entry in the database
     * @param task - object (Task).
     */
    public void addTask(Task task){
        em.persist(task);
    }

    /**
     * The method is used to delete a task.
     * Accepts a task identifier, searches for the desired record in the database and deletes.
     * @param id - id task.
     */
    public void delTask(Integer id){
        Task task = em.find(Task.class, id);
        em.remove(task);
    }

    /**
     * The method used to construct statistical graphs. Returns the information in the Map object.
     *
     * As the parameters of the following values:
     *
     * @param login - user login to get that information.
     * @param dateStart - date with bark we are interested in the information.
     * @param graph - the parameter is a Map object which harvested the desired date in the form of keys;
     *
     * Method edits and makes a request to the database.
     * Gets a collection of objects that contains information on the date (the key) and the number
     * of completed tasks in this date (value).
     *
     * The method then converts the result into a string and changes the values ​​in the graph parameter.
     *
     * @return - statistical information in the form of the object Map.
     */
    public Map graphs(String login, Date dateStart, Map graph){
        Query query = em.createNamedQuery("Task.findStatisticData", Task.class);
        query.setParameter("login", login);
        query.setParameter("dateComplete", dateStart);
        List<Object[]> result = query.getResultList();
        for (Iterator i = result.iterator(); i.hasNext();){
            Object[] values = (Object[])i.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,M,d");
            graph.put(dateFormat.format(values[0]),values[1]);
        }
        return graph;
    }

    /**
     * The method used to obtain task by id.
     * It takes as parameter the identifier task looking for the task and returns object.
     * @param id - id task.
     * @return - object (Task).
     */
    public Task getTask(Integer id){
        return em.find(Task.class, id);
    }


    /**
     * The method is used to update the existing task.
     * The parameter takes task object and updates the corresponding record in the database.
     * @param task - object (Task).
     */
    public void updTask(Task task){
        em.merge(task);
    }
}