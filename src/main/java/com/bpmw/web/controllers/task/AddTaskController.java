package com.bpmw.web.controllers.task;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.services.MessageService;
import com.bpmw.web.controllers.user.LoginController;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.task.AddTaskModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTaskController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Inject
    private AddTaskModel addTaskModel;

    @Inject
    private TaskGroupModel groupModel;

    @Inject
    MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addTaskModel.init();

            addTaskModel.getTask().setName(request.getParameter("name"));
            addTaskModel.getTask().setTextTask(request.getParameter("text"));
            Integer groupId = Integer.valueOf(request.getParameter("groupId"));
            TaskGroup taskGroup = groupModel.getTaskGroup(groupId);
            addTaskModel.getTask().setTaskGroup(taskGroup);

            if (addTaskModel.validate()){
                RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/add_task.jsp");
                Dispatcher.forward(request, response);
            } else {
                addTaskModel.addTask();
                messageService.addMessage("The task of adding successfully.");
                RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/add_task.jsp");
                Dispatcher.forward(request, response);
            }
            request.getRequestDispatcher("add_task.jsp").forward(request, response);
        } catch (ServletException ex){
            logger.error("Servlet error", ex);
        } catch (IOException ex){
            logger.error("Input text error", ex);
        }
    }
}