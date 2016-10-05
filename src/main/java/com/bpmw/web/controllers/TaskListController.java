package com.bpmw.web.controllers;

import com.bpmw.persistence.Task;
import com.bpmw.web.model.TaskModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/taskList")
public class TaskListController extends HttpServlet{

    private List<Task> selectedTaskList;

    @Inject
    private TaskModel taskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    private List<Task> list;

    public TaskListController(){
    }

    public List<Task> getList(){
        return list;
    }

    public void setList(List<Task> list){
        this.list = list;
    }

    public List<Task> getSelectedTaskList() {
        return selectedTaskList;
    }

    public void setSelectedTaskList(List<Task> selectedTaskList) {
        this.selectedTaskList = selectedTaskList;
    }
}