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


@WebServlet("/login")
public class UserController extends HttpServlet{

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
        if (request.isUserInRole("admin")){
            response.sendRedirect("inbox");
        }

        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}