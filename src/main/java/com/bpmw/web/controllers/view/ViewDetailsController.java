package com.bpmw.web.controllers.view;

import com.bpmw.persistence.User;
import com.bpmw.persistence.View;
import com.bpmw.services.InitializationObjectService;
import com.bpmw.services.MessageService;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ListViewsModel;
import com.bpmw.web.model.view.ViewDetailsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * The class is used to work with the selected user to view.
 */
public class ViewDetailsController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(ViewDetailsController.class);

    @Inject
    private TaskListModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ViewDetailsModel viewDetailsModel;

    @Inject
    private ListViewsModel listViewsModel;

    @Inject
    private MessageService messageService;

    @Inject
    private InitializationObjectService initializationObjectService;

    /**
     * The method takes a parameter task_id,
     * if the parameter is equal to the value of 'new' open view detail page to create a new view.
     * In the case of a specified viewing rooms, receives the necessary data and opens the page view.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String viewId = request.getParameter("view_id");
        if (viewId.hashCode() == "new".hashCode()){
            viewDetailsModel.init();
            request.getRequestDispatcher("WEB-INF/pages/view_details.jsp").forward(request, response);
        }else{
            Integer id = Integer.valueOf(viewId);
            viewDetailsModel.getView(id);
            taskModel.returnUserTasks(request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/pages/view_details.jsp").forward(request, response);
        }
    }

    /**
     *
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
            userModel.getUser(login);
            viewDetailsModel.init();

            View view = new View();
            Map<String, String[]> parameters = request.getParameterMap();
            view = (View) initializationObjectService.createObject(parameters, view);

            viewDetailsModel.setSelectedView(view);

            if(viewDetailsModel.validate()){
                messageService.addMessage("Error. Try again.");
                request.getRequestDispatcher("WEB-INF/pages/view_details.jsp").forward(request, response);
            }else {
                if (viewDetailsModel.getSelectedView().getId() == null) {
                    viewDetailsModel.addView();
                    messageService.addMessage("View saved successfully.");
                } else {
                    viewDetailsModel.updView();
                    messageService.addMessage("View updated successfully");
                }
                listViewsModel.returnViewsActiveUser(login);
                taskModel.returnUserTasks(login);
                request.getRequestDispatcher("WEB-INF/pages/inbox.jsp").forward(request, response);
            }
        } catch (ServletException ex) {
            logger.error("Servlet error", ex);
        } catch (IOException ex) {
            logger.error("Input text error", ex);
        } catch (ParseException e) {
            logger.error("Parse error", e);
        } catch (NoSuchFieldException e) {
            logger.error("No such field", e);
        } catch (IllegalAccessException e) {
            logger.error("Illegal access", e);
        }
    }
}