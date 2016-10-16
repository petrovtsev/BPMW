package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskListRequestContriller extends HttpServlet {

    @EJB
    private TaskListModel taskModel;

    @EJB
    private UserModel userModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer viewId = 0;
        try {
            viewId = Integer.valueOf(request.getParameter("view_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        taskModel.returTasksQuery(request.getUserPrincipal().getName(), viewId);
        userModel.returnViewsActiveUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
    }
}