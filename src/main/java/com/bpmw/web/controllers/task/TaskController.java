package com.bpmw.web.controllers.task;

import com.bpmw.web.model.TaskModel;
import com.bpmw.web.model.UserModel;
import com.bpmw.web.model.ViewModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ViewModel viewModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if (request.getParameter("idTask")!= null){
            Integer idTask = Integer.valueOf(request.getParameter("idTask"));
            taskModel.updTask(idTask, request.getUserPrincipal().getName());
            userModel.returnViewsActiveUser(request.getUserPrincipal().getName());
            taskModel.returnUserTasks(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String text = request.getParameter("text");
            String groupId = request.getParameter("groupId");
            taskModel.addTask(name, text, groupId);
            taskModel.setMessage("Task successfully added");
            request.getRequestDispatcher("add_task.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("add_task.jsp");
            taskModel.setMessage("Error. Try again.");
        } catch (ParseException e) {
            e.printStackTrace();
            request.getRequestDispatcher("add_task.jsp");
            taskModel.setMessage("Error. Try again.");
        }
        request.getRequestDispatcher("error.jsp");
    }
}