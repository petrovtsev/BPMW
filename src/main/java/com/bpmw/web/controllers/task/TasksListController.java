package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.view.ListViewsModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TasksListController extends HttpServlet{

    @Inject
    private TaskListModel taskListModel;

    @Inject
    private ListViewsModel listViewModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        taskListModel.returnUserTasks(request.getUserPrincipal().getName());
        listViewModel.returnViewsActiveUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request,response);
    }
}