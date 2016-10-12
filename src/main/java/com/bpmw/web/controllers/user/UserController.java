package com.bpmw.web.controllers.user;

import com.bpmw.web.model.TaskModel;
import com.bpmw.web.model.UserModel;

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
    private TaskModel taskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userModel.getUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/personalArea.jsp").forward(request, response);
    }
}