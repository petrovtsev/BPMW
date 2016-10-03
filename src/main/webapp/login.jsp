<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Login</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="header">
        <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
    </div>

    <div class="pages">
        <div class="authorization" style="margin-top: 10%; height: 130px">
            <div class="login">
                <form action="j_security_check" method="post">
                    Input for username:<br>
                    <input style="width: 170px; height: 17px" name="j_username" type="text"><br>
                    Input for password:<br>
                    <input style="width: 170px; height: 17px" name="j_password" type="password"><br><br/>
                    <input class="button" style="width: 170px; height: 25px" type="submit" value="Authorization">
                    <input class="button" style="width: 170px; height: 25px" type="reset" value="Reset"><br>
                </form>
            </div>
        </div>
    </div>
</body>
</html>