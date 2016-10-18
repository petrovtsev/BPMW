package com.bpmw.web.controllers.user;

import com.bpmw.persistence.User;
import com.bpmw.services.MessageService;
import com.bpmw.services.PasswordService;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {


    @Inject
    private UserModel userModel;

    @Inject
    private TaskListModel taskModel;

    @Inject
    private PasswordService passwordService;

    @Inject
    private MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        taskModel.returnUserTasks(request.getUserPrincipal().getName());
        userModel.getUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/personal_area.jsp").forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getUserPrincipal().getName();
        String password = passwordService.passwordHash(request.getParameter("password"));
        User user = userModel.getUser(login);
        if (user.getPassword().hashCode() == password.hashCode()){
            userModel.delUser(login);
            request.logout();
            messageService.addMessage("Your account has been deleted");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/pages/personal_area.jsp").forward(request, response);
        }
    }
}