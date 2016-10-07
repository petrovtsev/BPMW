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
    <div class="authorization" style="margin-top: 10%; height: 320px">
        <div class="login">
            <form action="j_security_check" method="post">
                <h3>Register</h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Login</td>
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
                        <td><input type="date" value="${userModel.returnAllUser().get(0).dateBirth}"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input value="${userModel.returnAllUser().get(0).city}"/></td>
                    </tr>
                    <tr>
                        <td>Group</td>
                        <td><input value="${userModel.returnAllUser().get(0).taskGroup.name}"/></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="number" value="${userModel.returnAllUser().get(0).phone}"/></td>
                    </tr>
                    <tr>
                        <td>Mail</td>
                        <td><input type="email" value="${userModel.returnAllUser().get(0).mail}"/></td>
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