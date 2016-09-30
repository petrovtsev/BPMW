package com.bpmw.web.controllers;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.User;
import com.bpmw.services.UserService;
import com.bpmw.web.model.TaskModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */

public class UserController extends HttpServlet {


    @Inject
    private UserService userService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private List<User> list;


}