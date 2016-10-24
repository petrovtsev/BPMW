package com.bpmw.web.controllers.user;

import com.bpmw.persistence.User;
import com.bpmw.services.InitializationObjectService;
import com.bpmw.services.MessageService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.user.RegisterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

/**
 * The class is for new user registration.
 */
public class RegisterController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Inject
    private RegisterModel registerModel;

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private MessageService messageService;

    @Inject
    private InitializationObjectService initializationObjectService;

    /**
     * The method checks the entered user login in order to avoid duplication of IDs.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if (request.getParameter("login") != null) {
            String login = request.getParameter("login");
            String message = registerModel.checkingLogin(login);
            response.getWriter().write(message);
        }
    }

    /**
     * The method takes a collection of parameters required to create a new user.
     * It sends the data from initializationObjectService which gets initialized object,
     * check the parameters of the user object on the respective requirements by validating service.
     * In the absence of errors it creates a new user and sends to the login page.
     * Otherwise, it displays a message with a list of errors.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            registerModel.init();

            User user = new User();
            Map<String, String[]> parameters = request.getParameterMap();
            user = (User) initializationObjectService.createObject(parameters, user);

            registerModel.setUser(user);

            if (registerModel.validate()) {
                messageService.addMessage("Error. Try again.");
                RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                Dispatcher.forward(request, response);
            } else {
                registerModel.addUser();
                messageService.addMessage("Registration completed.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        } catch (ParseException e) {
            logger.error("Parse error", e);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (NoSuchFieldException e) {
            logger.error("No such field", e);
        } catch (IllegalAccessException e) {
            logger.error("Illegal access", e);
        }
    }
}