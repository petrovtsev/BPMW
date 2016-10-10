<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page import="com.bpmw.persistence.Task" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>
<head>
    <title>View Task</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>



<body>
<div class="header">
    <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="${pageContext.request.contextPath}/taskList" method="post">
        <a href="userController?name=${req.userPrincipal.name}" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <button type="button" class="button" style="margin-left: 42%; width: 15%; height: 17px" name="back" onclick="history.back()">back</button>
        <a href="loginController?action=logout" style="height: 20px; margin-left: 10%; width: 7%" class="button">Exit</a>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.userTasks}">
                <a style="color: grey" href="taskList?task_id=${task.id}">${task.name}<br></a>
            </c:forEach>
        </ul>
        <hr>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new task" class="button"/>
    </div>
    <div class="content">
        <h3 style="margin-left: 10%">Task ID</h3>
        <hr>

        <form>
            <table class="data-table">
                <tr>
                    <td style="width: 150px">Name</td>
                    <td><input value="${taskModel.selectedTask.name}"/></td>
                </tr>
                    <td>Text</td>
                    <td><input value="${taskModel.selectedTask.textTask}"/></td>
                </tr>
                <tr>
                    <td>Date in</td>
                    <td><input value="${taskModel.selectedTask.dateIn}"/></td>
                </tr>
                <tr>
                    <td>Date complete</td>
                    <td><input value="${taskModel.selectedTask.dateComplet}"/></td>
                </tr>
                <tr>
                    <td>User complete</td>
                    <td><input value="${taskModel.selectedTask.userComplet.login}"/></td>
                </tr>
            </table>
        </form>
    </div>

    <div class="footer">
        <button type="button" class="button" style="margin-left: 42%; width: 15%; height: 17px" name="back" onclick="history.back()">back</button>
        <a class="button
" href="taskController?idTask=${taskModel.selectedTask.id}" style="margin-top: 10px; margin-left: 5px; width: 15%">Remove Task</a>

    </div>
</div>
</body>
</html>