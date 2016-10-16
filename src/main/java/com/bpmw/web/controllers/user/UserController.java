package com.bpmw.web.controllers.user;

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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        taskModel.returnUserTasks(request.getUserPrincipal().getName());
        userModel.getUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/personal_area.jsp").forward(request, response);
    }
}