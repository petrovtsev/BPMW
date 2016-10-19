package com.bpmw.web.model.task;

import com.bpmw.persistence.User;
import com.bpmw.services.TaskService;
import com.bpmw.services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.*;

@Named
@RequestScoped
public class StaticticTaskModel {

    @Inject
    private TaskService taskService;

    @Inject
    private UserService userService;

//    public void ssss(Integer day){
//        List<User> userList = userService.returnAllUsers();
//        String[] usersArr = new String[userList.size()+1];
//        usersArr[0] = "Date";
//        for (int i = 0; i < userList.size(); i++){
//            usersArr[i+0] = userList.get(0).getLogin();
//        }
//        String[][] statisticData = new String[day][userList.size()];
//        for (int i = 0; i < day; i++){
//            fillDataGraph(usersArr[i+1], day);
//        }
//    }

    private Map dataGraph = new LinkedHashMap<String, Integer>();

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