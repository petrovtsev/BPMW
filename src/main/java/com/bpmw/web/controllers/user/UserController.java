package com.bpmw.web.controllers.user;

import com.bpmw.persistence.User;
import com.bpmw.services.MessageService;
import com.bpmw.services.PasswordService;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class is used to work with the user account.
 */
public class UserController extends HttpServlet {

    private static  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserModel userModel;

    @Inject
    private TaskListModel taskModel;

    @Inject
    private PasswordService passwordService;

    @Inject
    private MessageService messageService;

    /**
     * The method takes all the data of the active user and sends a personal account page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        taskModel.returnUserTasks(request.getUserPrincipal().getName());
        userModel.getUser(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/personal_area.jsp").forward(request, response);
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }


    /**
     * The method used to remove user.
     * Accepts parameter password, compares it with the password of the active user,
     * if the parameters are the same, delete the active user, and sends the page 'login'.
     * Otherwise, it displays an error message.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String login = request.getUserPrincipal().getName();
        String password = passwordService.passwordHash(request.getParameter("password"));
        User user = userModel.getUser(login);
        if (user.getPassword().hashCode() == password.hashCode()){
            userModel.delUser(login);
            request.logout();
            messageService.addMessage("Your account has been deleted");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            messageService.addMessage("Error. Incorrect password.");
            request.getRequestDispatcher("WEB-INF/pages/personal_area.jsp").forward(request, response);
        }
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        }
    }
}