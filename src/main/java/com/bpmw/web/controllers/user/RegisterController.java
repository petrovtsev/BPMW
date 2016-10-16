package com.bpmw.web.controllers.user;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.services.ValidateService;
import com.bpmw.web.model.group.TaskGroupModel;
import com.bpmw.web.model.user.RegisterModel;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterController extends HttpServlet{

    @Inject
    private RegisterModel registerModel;

    @Inject
    private TaskGroupModel taskGroupModel;

    @EJB
    private ValidateService validateService;

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
     * The method takes String parameters passed from the page converts,
     * creates an object - User and calls the method "RegisterModel"
     * in order to add an object to the database.
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

            registerModel.getUser().setLogin(request.getParameter("login"));
            registerModel.getUser().setPassword(request.getParameter("password"));
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
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ServletException ex){

            request.getRequestDispatcher("error_login.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("error_login.jsp");
    }

    /**
     * The method generates a hash of the password (SHA256)
     * @param pass - password
     * @return - password hash (SHA-256)
     */
    private String passwordHash (String pass) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pass.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}