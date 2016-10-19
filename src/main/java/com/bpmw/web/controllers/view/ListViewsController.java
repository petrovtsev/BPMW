package com.bpmw.web.controllers.view;

import com.bpmw.services.MessageService;
import com.bpmw.web.controllers.user.UserController;
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

public class ListViewsController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(ListViewsController.class);

    @Inject
    private TaskListModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ListViewsModel listViewsModel;

    @Inject
    private MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        if (request.getParameter("action").hashCode() == "del".hashCode()) {
            Integer idView = Integer.valueOf(request.getParameter("idView"));
            messageService.addMessage("View №" + idView + " deleted");
            listViewsModel.delView(idView);
            listViewsModel.returnViewsActiveUser(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/list_views.jsp").forward(request, response);
        } else {
            listViewsModel.returnViewsActiveUser(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/list_views.jsp").forward(request, response);
        }
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }
}