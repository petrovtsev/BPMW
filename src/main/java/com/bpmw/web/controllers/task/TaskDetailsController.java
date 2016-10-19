package com.bpmw.web.controllers.task;

import com.bpmw.persistence.User;
import com.bpmw.services.MessageService;
import com.bpmw.web.controllers.user.LoginController;
import com.bpmw.web.model.task.TaskDetailsModel;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ListViewsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskDetailsController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(TaskDetailsController.class);

    @Inject
    private TaskListModel taskModel;

    @Inject
    private TaskDetailsModel taskDetailsModel;

    @Inject
    private ListViewsModel listViewModel;

    @Inject
    private UserModel userModel;

    @Inject
    private MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer taskId;
            taskId = Integer.valueOf(request.getParameter("task_id"));
            if (taskId != 0) {
                taskDetailsModel.setSelectedTask(taskModel.getTask(taskId));
                taskModel.returnUserTasks(request.getUserPrincipal().getName());
                request.getRequestDispatcher("WEB-INF/pages/task_details.jsp").forward(request, response);
            }
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer taskId = Integer.valueOf(request.getParameter("taskId"));
            String login = request.getUserPrincipal().getName();
            User user = userModel.getUser(login);
            taskDetailsModel.getTask(taskId);

            taskDetailsModel.getSelectedTask().setComment(request.getParameter("comment"));
            taskDetailsModel.getSelectedTask().setUserComplet(user);

            taskDetailsModel.closeTask();

            listViewModel.returnViewsActiveUser(login);
            taskModel.returnUserTasks(login);
            messageService.addMessage("Task №" + taskId + " is closed.");
            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }
}