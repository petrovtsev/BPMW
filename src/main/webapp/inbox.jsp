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
            <input style="margin-top: 10px; margin-left: 40%" width="100" value="">
            <input type="password" width="100">
            <input href="#" style="height: 20px" type="submit" name="login" value="login" class="button" />
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
            <hr>
        </div>
        <div class="content">
            <table border="1" class="table">
                <tr>
                    <td width="100">id</td>
                    <td width="100">Name</td>
                    <td width="300">Text</td>
                    <td width="100">Date</td>
                    <td width="100">User</td>
                    <td width="100">Phone</td>
                    <td width="100">City</td>
                </tr>
                <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                    <tr>
                        <td>${task.id}</td>
                        <td>${task.name}</td>
                        <td>${task.text}</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                </c:forEach>
            </table>

        </div>

        <div class="footer">
            <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Add</a>
            <a href="#" class="button">Remove</a>
            <a href="#" class="button">Update</a>
        </div>
</body>
</html>