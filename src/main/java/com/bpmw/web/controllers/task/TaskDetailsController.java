package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.TaskDetailsModel;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskDetailsController extends HttpServlet{

    @EJB
    private TaskListModel taskModel;

    @EJB
    private TaskDetailsModel taskDetailsModel;

    @EJB
    private UserModel userModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Integer taskId = 0;
        try {
            taskId = Integer.valueOf(request.getParameter("task_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (taskId != 0){
            taskDetailsModel.setSelectedTask(taskModel.getTask(taskId));
            taskModel.returnUserTasks(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/task_details.jsp").forward(request,response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idTask = Integer.valueOf(request.getParameter("taskId"));
        String login = request.getUserPrincipal().getName();
        taskDetailsModel.closeTask(idTask, login, request.getParameter("comment"));
        userModel.returnViewsActiveUser(login);
        taskModel.returnUserTasks(login);
        request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
    }
}