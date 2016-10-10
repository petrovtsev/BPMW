<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Login</title>
    <link href="${uri}/resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="header">
        <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
    </div>

    <div class="pages">
        <div class="authorization" style="margin-top: 10%; height: 240px">
            <div class="login">
                <form action="loginController" method="post">
                    <h3>Login</h3>
                    <hr>
                    Input for username:<br>
                    <input style="width: 170px; height: 17px" name="username" type="text"><br>
                    Input for password:<br>
                    <input style="width: 170px; height: 17px" name="password" type="password"><br><br/>
                    <input class="button" style="width: 200px; height: 25px" type="submit" value="Authorization"><br>
                    <a href="register.jsp" class="button" style="width: 100px; margin-top: 9px; height: 17px">Register</a>
                    <a href="addTask.jsp" class="button" style="width: 100px; margin-top: 9px ; height: 17px">Add task</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>