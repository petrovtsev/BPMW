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

@WebServlet("/")
public class TaskController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setAttribute("task", taskModel.returnAllTasks());
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private List<Task> list;

    public TaskController(){
    }

    public List<Task> getList(){
        return list;
    }

    public void setList(List<Task> list){
        this.list = list;
    }
}