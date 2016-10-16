package com.bpmw.web.controllers.view;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ViewModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class ViewController extends HttpServlet{

    @Inject
    private TaskListModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ViewModel viewModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Integer id = Integer.valueOf(request.getParameter("view_id"));
        viewModel.getView(id);
        taskModel.returnUserTasks(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/view_details.jsp").forward(request,response);
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
            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("error_login.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("error_login.jsp");
    }
}