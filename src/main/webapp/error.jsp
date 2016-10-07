<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Error</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="header">
        <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
    </div>

    <div class="pages">
        <div class="authorization" style="margin-top: 10%; height: 220px">
            <div class="login">
                <h3>Error</h3>
                <hr>
                <output>ERROR</output><br><br>
                <output>Try again</output><br><br>
                <a href="login.jsp" class="button" style="width: 170px">Back</a>

                <a href="register.jsp" class="button" style="width: 170px; margin-top: 3px">Register</a><br>
            </div>
        </div>
    </div>
</body>
</html>