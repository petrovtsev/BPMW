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
        <a href="${uri}/pages/personalArea.jsp" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <a href="inbox.jsp" style="height: 15px; width: 7%; margin-left: 25%; margin-top: 10px" class="button">Back to list</a>
        <a href="../login.jsp" style="height: 15px; width: 7%; margin-left: 16%; margin-top: 10px" class="button">Exit</a></form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <a href="#">${task.name}</a><br>
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
                    <td><input value="${taskModel.selectedTask.text}"/></td>
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
        <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Save</a>
        <a href="#" class="button">Remove</a>
        <a href="${uri}/pages/inbox.jsp" class="button">Back</a>
    </div>
</div>
</body>
</html>