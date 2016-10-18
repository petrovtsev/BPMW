package com.bpmw.web.controllers.task;

import com.bpmw.web.controllers.user.LoginController;
import com.bpmw.web.model.task.StaticticTaskModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ppetr on 15.10.2016.
 */

public class StaticticTaskController extends HttpServlet{

    private static  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Inject
    private StaticticTaskModel staticticTaskModel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer day = Integer.valueOf(request.getParameter("day"));
            staticticTaskModel.getDataGraph(request.getUserPrincipal().getName(), day);
            request.getRequestDispatcher("WEB-INF/pages/statistic.jsp").forward(request, response);
        } catch (ServletException ex){
            logger.error("Servlet error", ex);
        } catch (IOException ex){
            logger.error("Input text error", ex);
        }
    }
}
