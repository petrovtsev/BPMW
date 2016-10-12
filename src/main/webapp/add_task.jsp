<%@ page import="com.bpmw.web.controllers.task.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Add task</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="pages">
    <div class="authorization" style="margin-top: 10%; height: 250px">
        <div class="login">
            <form action="taskController" method="post">
                <h3>${taskModel.message}</h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Name</td>
                        <td><input class="input_text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Text</td>
                        <td><input class="input_text" name="text"/></td>
                    </tr>
                    <td>Group id</td>
                    <td><input class="input_text" name="groupId"/></td>
                    </tr>
                </table>
                <br>
                <input class="button" style="width: 128px; height: 26px" type="submit" value="Next">
                <input class="button" style="width: 128px; height: 26px" type="reset" value="Reset"><br>
                <a href="login.jsp" class="button" style="width: 230px; margin-top: 5px; height: 12px">Login</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>