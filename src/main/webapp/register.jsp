<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Register</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="pages">
    <div class="authorization" style="margin-top: 10%; height: 370px">
        <div class="login">
            <form action="userController" method="post">
                <h3>Register</h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Login</td>
                        <td><input name="login"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>First name</td>
                        <td><input name="firstName"/></td>
                    </tr>
                    <td>Last name</td>
                    <td><input name="lastName"/></td>
                    </tr>
                    <tr>
                        <td>Date birth</td>
                        <td><input name="dateBirth"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input name="city"/></td>
                    </tr>
                    <tr>
                        <td>Group</td>
                        <td><input name="taskGroupId"/></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input name="phone"/></td>
                    </tr>
                    <tr>
                        <td>Mail</td>
                        <td><input name="mail"/></td>
                    </tr>
                </table>
                <br>
                <input class="button" style="width: 170px; height: 25px" type="submit" value="Next">
                <input class="button" style="width: 170px; height: 25px" type="reset" value="Reset"><br>
            </form>
        </div>
    </div>
</div>
</body>
</html>