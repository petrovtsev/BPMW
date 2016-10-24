<%@ page import="com.bpmw.web.controllers.task.TaskDetailsController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Error</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/components.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="header">
        <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
    </div>

    <div class="pages">
        <div class="authorization">
            <div class="login">
                <h3>Error</h3>
                <hr>
                <output>ERROR</output><br>
                <output>Try again</output><br>
                <c:out value="${messageError}"/><br>
                <a href="login.jsp" class="button">Back</a>
                <a href="register.jsp" class="button">Register</a><br>
            </div>
        </div>
    </div>
</body>
</html>