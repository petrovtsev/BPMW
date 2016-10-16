package com.bpmw.web.controllers.task;

import com.bpmw.web.model.task.StaticticTaskModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ppetr on 15.10.2016.
 */

public class StaticticTaskController extends HttpServlet{

    @EJB
    private StaticticTaskModel staticticTaskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        staticticTaskModel.getDataGraph(request.getUserPrincipal().getName());
        request.getRequestDispatcher("WEB-INF/pages/statistic.jsp").forward(request, response);
    }
}
