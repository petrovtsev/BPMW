<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Personal area</title>
    <link href="resources/css/inbox.css" rel="stylesheet" type="text/css" />
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
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <a href="#">${task.name}</a><br>
            </c:forEach>
        </ul>
        <hr>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new task" class="button"/>
    </div>
    <div class="content">
        <form>
            <h3 style="margin-left: 10%">My Account</h3>
            <hr>
            <table class="data-table">
                <tr>
                    <td width="150">Login</td>
                    <td><input value="${userModel.returnAllUser().get(0).login}"/></td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td><input value="${userModel.returnAllUser().get(0).firstName}"/></td>
                </tr>
                    <td>Last name</td>
                    <td><input value="${userModel.returnAllUser().get(0).lastName}"/></td>
                </tr>
                <tr>
                <td>Date birth</td>
                    <td><input value="${userModel.returnAllUser().get(0).dateBirth}"/></td>
                </tr>
                <tr>
                <td>City</td>
                    <td><input value="${userModel.returnAllUser().get(0).city}"/></td>
                </tr>
                <tr>
                    <td>Group</td>
                    <td><input value="${userModel.returnAllUser().get(0).group.name}"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input value="${userModel.returnAllUser().get(0).phone}"/></td>
                </tr>
                <tr>
                    <td>Mail</td>
                    <td><input value="${userModel.returnAllUser().get(0).mail}"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="footer">
        <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Save</a>
        <a href="inbox.jsp" class="button">Back</a>
    </div>
</div>
</body>
</html>