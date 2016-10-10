package com.bpmw.web.controllers;

import com.bpmw.persistence.Task;
import com.bpmw.web.model.TaskModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TaskListController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Integer taskId = 0;
        try {
            taskId = Integer.valueOf(request.getParameter("task_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        taskModel.setSelectedTask(getTask(taskId));
        taskModel.returnUserTasks(request.getUserPrincipal().getName());
        request.getRequestDispatcher("task_details.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public List<Task> returnAllTasks(){
        return taskModel.returnAllTasks();
    }

    public Task getTask(Integer id){
        return taskModel.getTask(id);
    }
}