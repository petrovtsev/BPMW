<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>View Task</title>
    <link href="resources/css/view_task.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="${pageContext.request.contextPath}/taskList" method="post">
        <output style="margin-top: 10px; margin-left: 15%; width: 15%">User name: Admin</output>
        <a href="inbox.jsp" style="height: 15px; width: 7%; margin-left: 25%; margin-top: 10px" class="button">Back to list</a>
        <a href="login.jsp" style="height: 15px; width: 7%; margin-left: 16%; margin-top: 10px" class="button">Exit</a></form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <li>task1</li>
            <li>task2</li>
            <li>task3</li>
            <li>task4</li>
            <li>task5</li>
            <li>task6</li>
            <li>task7</li>
            <li>task8</li>
            <li>task9</li>
        </ul>
        <hr>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new task" class="button"/>
    </div>
    <div class="content">

        <output style="margin-left: 5%; margin-top: 5%">TASK ID ${taskService.getTask(1).id}</output>
        <fieldset style="margin-top: 3%">
            <output style="width: 150px">Name:</output>
            <input style="width: 300px" value="${taskService.getTask(1).name}"><br><br>
            <output style="width: 150px">Text:</output>
            <input style="width: 300px" value="${taskService.getTask(1).text}">
        </fieldset>

    </div>

    <div class="footer">
        <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Save</a>
        <a href="#" class="button">Remove</a>
        <a href="inbox.jsp" class="button">Back</a>
    </div>
</div>
</body>
</html>