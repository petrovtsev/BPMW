<%@ page import="com.bpmw.web.controllers.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Register</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="jquery.js" type="text/javascript"></script>
    <script src="jquery.maskedinput.js" type="text/javascript"></script>
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="pages">
    <div class="authorization" style="margin-top: 7%; height: 420px">
        <div class="login">
            <form action="userController" method="post">
                <h3>Register</h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Login</td>
                        <td><input class="input_text" name="login"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input class="input_text" type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>First name</td>
                        <td><input class="input_text" name="firstName"/></td>
                        <td style="color: gray">Message</td>
                    </tr>
                    <td>Last name</td>
                    <td><input class="input_text" name="lastName"/></td>
                    </tr>
                    <tr>
                        <td>Date birth</td>
                        <td><input class="input_text" id="date" name="dateBirth"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input class="input_text" name="city"/></td>
                    </tr>
                    <tr>
                        <td>Group</td>
                        <td><input class="input_text" name="taskGroupId"/></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input class="input_text" id="phone" pattern="[0-9]{1}([0-9]{3})-[0-9]{3}-[0-9]{2}-[0-9]{2}" name="phone"/></td>
                    </tr>
                    <tr>
                        <td>Mail</td>
                        <td><input class="input_text" name="mail"/></td>
                    </tr>
                </table>
                <br>
                <input class="button" style="width: 128px; height: 26px" type="reset" value="Reset">
                <input class="button" style="width: 128px; height: 26px" type="submit" value="Next"><br>
                <a href="login.jsp" class="button" style="width: 230px; margin-top: 5px; height: 12px">Login</a>
            </form>
        </div>
    </div>
</div>
<script>
    $(function(){
        $("#date").mask("99.99.9999", {placeholder: "дд.мм.гггг" });
        $("#phone").mask("8(999) 999-9999");
    });
</script>
</body>
</html>