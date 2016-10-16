package com.bpmw.web.controllers.user;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ViewModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet{

    @EJB
    private TaskListModel taskModel;

    @EJB
    private UserModel userModel;

    @EJB
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
            request.logout();
            request.login(request.getParameter("username"), request.getParameter("password"));
            userModel.returnViewsActiveUser(request.getParameter("username"));
            taskModel.returnUserTasks(request.getUserPrincipal().getName());

            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("error_login.jsp");
        }
        request.getRequestDispatcher("error_login.jsp");
    }
}