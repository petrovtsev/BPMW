<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Personal area</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="taskList" method="post">
        <a href="#" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <button type="button" class="button" style="margin-left: 42%; width: 15%; height: 17px" name="back" onclick="history.back()">back</button>
        <a href="loginController?action=logout" style="height: 20px; margin-left: 10%; width: 7%" class="button">Exit</a>
    </form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.userTasks}">
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
                    <td><input value="${userModel.activeUser.login}"/></td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td><input value="${userModel.activeUser.firstName}"/></td>
                </tr>
                    <td>Last name</td>
                    <td><input value="${userModel.activeUser.lastName}"/></td>
                </tr>
                <tr>
                <td>Date birth</td>
                    <td><input value="${userModel.activeUser.dateBirth}"/></td>
                </tr>
                <tr>
                <td>City</td>
                    <td><input value="${userModel.activeUser.city}"/></td>
                </tr>
                <tr>
                    <td>Group</td>
                    <td><input value="${userModel.activeUser.taskGroup.name}"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input value="${userModel.activeUser.phone}"/></td>
                </tr>
                <tr>
                    <td>Mail</td>
                    <td><input value="${userModel.activeUser.mail}"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="footer">
        <button type="button" class="button" style="margin-left: 42%; width: 15%; height: 17px" name="back" onclick="history.back()">back</button>
    </div>
</div>
</body>
</html>