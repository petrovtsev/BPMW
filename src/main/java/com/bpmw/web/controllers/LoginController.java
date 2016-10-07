package com.bpmw.web.controllers;

import com.bpmw.persistence.Task;
import com.bpmw.web.model.TaskModel;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.logout();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.logout();
            request.login(request.getParameter("username"), request.getParameter("password"));
            taskModel.returnUserTasks(request.getUserPrincipal().getName());

            request.getRequestDispatcher("pages/inbox.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("error.jsp");
        }
        request.getRequestDispatcher("error.jsp");

    }
}