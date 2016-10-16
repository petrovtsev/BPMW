package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.AddTaskModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ViewModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class AddTaskController extends HttpServlet{

    @EJB
    private AddTaskModel addTaskModel;

    @EJB
    private UserModel userModel;

    @EJB
    private ViewModel viewModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String text = request.getParameter("text");
            Integer groupId = Integer.valueOf(request.getParameter("groupId"));
            addTaskModel.addTask(name, text, groupId);
            addTaskModel.setMessage("Task successfully added");
            request.getRequestDispatcher("add_task.jsp").forward(request, response);
        } catch (ServletException ex){
            request.getRequestDispatcher("add_task.jsp");
            addTaskModel.setMessage("Error. Try again.");
        } catch (ParseException e) {
            e.printStackTrace();
            request.getRequestDispatcher("add_task.jsp");
            addTaskModel.setMessage("Error. Try again.");
        }
    }
}