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
    <form action="taskList" method="post">
        <a href="userController?name=${req.userPrincipal.name}" class="list_ref" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <input class="input_text" placeholder="input name task" style="margin-top: 10px; margin-left: 17%; width: 17%"  value="">
        <a style="height: 12px; width: 7%" class="button">Search</a>
        <a href="loginController?action=logout" style="margin-left: 8.3%; width: 7%; height: 12px" class="button">Exit</a>
    </form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.userTasks}">
                <a class="list_ref" style="color: black" href="taskList?task_id=${task.id}">${task.name}<br></a>
            </c:forEach>
        </ul>
    </div>
    <div class="content">
        <h3 style="margin-left: 10%">Task ID</h3>
        <hr>

        <form>
            <table class="data-table">
                <tr>
                    <td style="width: 150px">Name</td>
                    <td>${taskModel.selectedTask.name}</td>
                </tr>
                    <td>Text</td>
                    <td>${taskModel.selectedTask.textTask}</td>
                </tr>
                <tr>
                    <td>Date in</td>
                    <td>${taskModel.selectedTask.dateIn}</td>
                </tr>
                <tr>
                    <td>Date complete</td>
                    <td>${taskModel.selectedTask.dateComplet}</td>
                </tr>
                <tr>
                    <td>User complete</td>
                    <td>${taskModel.selectedTask.userComplet.login}</td>
                </tr>
                <tr>
                    <td>Comment</td>
                    <td><input type="text" class="input_text"></td>
                </tr>
            </table>
            <br>
            <div style="text-align: center; margin: 10px">
                <button type="button" class="button" style="width: 15%; height: 26px; margin-top: 5px" name="back" onclick="history.back()">Back</button>
                <a class="button" href="taskController?idTask=${taskModel.selectedTask.id}" style="height: 12px ;margin-top: 6px; width: 15%">Close Task</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>