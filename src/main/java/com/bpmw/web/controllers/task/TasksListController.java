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
 * The class is used to display all the group tasks.
 */
public class TasksListController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(TasksListController.class);

    @Inject
    private TaskListModel taskListModel;

    @Inject
    private ListViewsModel listViewModel;

    /**
     * The method determines the active user and obtains a list of the tasks of his group.
     * Then sends the page 'task list'.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            taskListModel.returnUserTasks(request.getUserPrincipal().getName());
            listViewModel.returnViewsActiveUser(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request,response);
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }
}