package com.bpmw.web.controllers.user;

import com.bpmw.services.MessageService;
import com.bpmw.services.PasswordService;
import com.bpmw.services.ValidateService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.user.RegisterModel;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegisterController extends HttpServlet{

    @Inject
    private RegisterModel registerModel;

    @Inject
    private TaskGroupModel taskGroupModel;

    @Inject
    private ValidateService validateService;

    @Inject
    private PasswordService passwordService;

    @Inject
    private MessageService messageService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if (request.getParameter("login") != null) {
            String login = request.getParameter("login");
            String message = registerModel.checkingLogin(login);
            response.getWriter().write(message);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            registerModel.init();

            registerModel.getUser().setLogin(request.getParameter("login"));
            String hashPassword = passwordService.passwordHash(request.getParameter("password"));
            registerModel.getUser().setPassword(hashPassword);
            registerModel.getUser().setFirstName(request.getParameter("firstName"));
            registerModel.getUser().setLastName(request.getParameter("lastName"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            registerModel.getUser().setDateBirth(dateFormat.parse(request.getParameter("dateBirth")));
            registerModel.getUser().setCity(request.getParameter("city"));
            registerModel.getUser().setPhone(request.getParameter("phone"));
            registerModel.getUser().setTaskGroup(taskGroupModel.getTaskGroup(Integer.valueOf(request.getParameter("taskGroupId"))));
            registerModel.getUser().setMail(request.getParameter("email"));

            if (registerModel.validate()) {
                RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                Dispatcher.forward(request, response);
            } else {
                registerModel.addUser();
                messageService.addMessage("Registration completed.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ServletException ex){

            request.getRequestDispatcher("error_login.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("error_login.jsp");
    }
}