package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.view.ListViewsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class is used to display a list of tasks configured for the user's request.
 */
public class TaskListRequestContriller extends HttpServlet {

    private static  final Logger logger = LoggerFactory.getLogger(TaskListRequestContriller.class);

    @Inject
    private TaskListModel taskListModel;

    @Inject
    private ListViewsModel listViewModel;

    /**
     * The method is used to display the task list on request.
     * Takes the view parameter ID, sends the required data to the model, and sends the page 'task list'.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String login = request.getUserPrincipal().getName();
            Integer viewId = Integer.valueOf(request.getParameter("view_id"));
            taskListModel.returTasksQuery(login, viewId);
            listViewModel.returnViewsActiveUser(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }
}