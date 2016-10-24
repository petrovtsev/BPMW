package com.bpmw.web.controllers.task;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.services.InitializationObjectService;
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
import java.text.ParseException;
import java.util.Map;

/**
 * The servlet is used to add new tasks
 */
public class AddTaskController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Inject
    private AddTaskModel addTaskModel;

    @Inject
    private TaskGroupModel groupModel;

    @Inject
    private InitializationObjectService initializationObjectService;

    @Inject
    MessageService messageService;

    /**
     * Method receives the necessary data, verifies the data.
     * If the data is entered correctly creates a new task, otherwise displays
     * a message to the user with information about the existing error.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addTaskModel.init();

            Task task = new Task();
            Map<String, String[]> parameters = request.getParameterMap();
            task = (Task) initializationObjectService.createObject(parameters, task);

            addTaskModel.setTask(task);

            if (addTaskModel.validate()){
                messageService.addMessage("Error. Try again.");
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
        } catch (IllegalAccessException e) {
            logger.error("Access error", e);
        } catch (ParseException e) {
            logger.error("Parse error", e);
        } catch (NoSuchFieldException e) {
            logger.error("No such field", e);
        }
    }
}