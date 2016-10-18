package com.bpmw.web.controllers.view;

import com.bpmw.persistence.User;
import com.bpmw.services.MessageService;
import com.bpmw.web.model.task.TaskListModel;
import com.bpmw.web.model.user.UserModel;
import com.bpmw.web.model.view.ListViewsModel;
import com.bpmw.web.model.view.ViewDetailsModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ViewDetailsController extends HttpServlet{

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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String login = request.getUserPrincipal().getName();
            User user = userModel.getUser(login);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            viewDetailsModel.init();

            viewDetailsModel.getSelectedView().setName(request.getParameter("name"));
            viewDetailsModel.getSelectedView().setDateStart(dateFormat.parse(request.getParameter("dateStart")));
            viewDetailsModel.getSelectedView().setDateEnd(dateFormat.parse(request.getParameter("dateEnd")));
            viewDetailsModel.getSelectedView().setStatusComplete(request.getParameter("statusComplete"));
            viewDetailsModel.getSelectedView().setUser(user);

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
        } catch (ServletException ex){
            request.getRequestDispatcher("error_login.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("error_login.jsp");
    }
}