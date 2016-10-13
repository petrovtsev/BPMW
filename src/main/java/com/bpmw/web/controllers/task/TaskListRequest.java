package com.bpmw.web.controllers.task;

import com.bpmw.persistence.Task;
import com.bpmw.web.model.TaskModel;
import com.bpmw.web.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskListRequest extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Inject
    private UserModel userModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Integer viewId = 0;
        try {
            viewId = Integer.valueOf(request.getParameter("view_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        taskModel.returTasksQuery(request.getUserPrincipal().getName(), viewId);
        userModel.returnViewsActiveUser(request.getParameter("username"));
        request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public Task getTask(Integer id){
        return taskModel.getTask(id);
    }
}