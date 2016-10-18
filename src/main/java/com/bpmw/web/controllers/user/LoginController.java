package com.bpmw.web.controllers.user;

import com.bpmw.services.MessageService;
import com.bpmw.services.PasswordService;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.LoginModel;
import com.bpmw.web.model.view.ListViewsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Inject
    private TaskListModel taskModel;

    @Inject
    private PasswordService passwordService;

    @Inject
    private LoginModel loginModel;

    @Inject
    private ListViewsModel listViewsModel;

    @Inject
    private MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.logout();
        messageService.addMessage("Session successfully closed");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.logout();

            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String hashPassword = passwordService.passwordHash(password);

            if (loginModel.validateLogin(login, hashPassword)){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else {
                request.login(login, password);
                listViewsModel.returnViewsActiveUser(login);
                taskModel.returnUserTasks(login);
                messageService.addMessage("Welcome " + login + "!");
                request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
            }
        } catch (ServletException ex){
            logger.error("Servlet error", ex);
        }
    }
}