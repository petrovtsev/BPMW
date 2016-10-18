package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.view.ListViewsModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskListRequestContriller extends HttpServlet {

    @Inject
    private TaskListModel taskListModel;

    @Inject
    private ListViewsModel listViewModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getUserPrincipal().getName();
        Integer viewId = 0;
        try {
            viewId = Integer.valueOf(request.getParameter("view_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        taskListModel.returTasksQuery(login, viewId);
        listViewModel.returnViewsActiveUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
    }
}