<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Tasks list</title>
    <link href="resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="${pageContext.request.contextPath}/taskList" method="post">
        <output style="margin-top: 10px; margin-left: 15%; width: 15%">User name: Admin</output>
        <input style="margin-top: 10px; margin-left: 20%; width: 15%"  value="">
        <input href="#" style="height: 20px; width: 7%" type="submit" name="Search" value="Search" class="button" />
        <input href="login.jsp" style="height: 20px; margin-left: 10%; width: 7%" type="submit" name="exit" value="Exit" class="button" />
    </form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Views</h3>
        <hr>
        <ul>
            <li>view1</li>
            <li>view2</li>
            <li>view3</li>
            <li>view4</li>
        </ul>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new query" class="button"/>
        <hr>
    </div>
    <div class="content">
        <table border="1" class="table">
            <tr>
                <td width="100">id</td>
                <td width="100">Name</td>
                <td width="300">Text</td>
                <td width="100">Group</td>
                <td width="100">User</td>
                <td width="100">Phone</td>
                <td width="100">Edit</td>
            </tr>
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.name}</td>
                    <td>${task.text}</td>
                    <td>${task.group.name}</td>
                    <td>-</td>
                    <td>-</td>
                    <td><a href="viewTask.jsp" style="width: 70px">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>