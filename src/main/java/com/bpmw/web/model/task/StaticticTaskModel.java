package com.bpmw.web.model.task;

import com.bpmw.services.TaskService;
import com.bpmw.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The class used to obtain statistics on the implementation of tasks.
 */
@Named
@RequestScoped
public class StaticticTaskModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserService userService;

    /**
     * A collection that contains the values of the user statistics.
     * The key is the date, the value of the number of completed tasks.
     */
    private Map dataGraph = new LinkedHashMap<String, Integer>();

    /**
     * The method of assigning her to fill the collection as a key date on the right kolichstvo days.
     * The values of leaves blank.
     * The parameter accepts:
     * @param day - the number of days required.
     * @return - the collection is filled with keys.
     */
    public Map fillCalendar(Integer day) {
        Map graph = new  LinkedHashMap<Date, Integer>();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -day);
        date = c.getTime();
        for (int i = 0; i < day; i++) {
            c.add(Calendar.DATE, 1);
            date = c.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,M,d");
            String dateString = dateFormat.format(date);
            graph.put(dateString, 0);
        }
        return graph;
    }

    /**
     * Takes method:
     * @param login - user login.
     * @param day - the number of days required.
     *
     * And sends the data to the service received
     * from the completed statistical data collection and assigns it dataGraf.
     */
    public void fillDataGraph (String login, Integer day){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -day);
        date = c.getTime();
        dataGraph = taskService.graphs(login, date, fillCalendar(day));
    }

    public Map getDataGraph() {
        return dataGraph;
    }

    public void setDataGraph(Map dataGraph) {
        this.dataGraph = dataGraph;
    }
}