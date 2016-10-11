package com.bpmw.web.controllers;

import com.bpmw.web.model.TaskModel;
import com.bpmw.web.model.UserModel;
import com.bpmw.web.model.ViewModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet{

    @Inject
    private TaskModel taskModel;

    @Inject
    private UserModel userModel;

    @Inject
    private ViewModel viewModel;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String text = request.getParameter("text");
        response.getWriter().write("Задача " + name + " добавленна!");
        response.flushBuffer();
    }
}