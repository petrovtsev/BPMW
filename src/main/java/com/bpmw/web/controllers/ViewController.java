package com.bpmw.web.controllers;

import com.bpmw.web.model.TaskModel;
import com.bpmw.web.model.UserModel;
import com.bpmw.web.model.ViewModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ViewModel viewModel;

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
            String name = request.getParameter("name");
            String statusComplete = request.getParameter("statusComplete");
            String dateStart = request.getParameter("dateStart");
            String dateEnd = request.getParameter("dateEnd");
            String login = request.getUserPrincipal().getName();
            viewModel.addView(login, name, dateStart, dateEnd, statusComplete);
            userModel.returnViewsActiveUser(login);
            taskModel.returnUserTasks(login);
            request.getRequestDispatcher("inbox.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("error.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("error.jsp");
    }
}