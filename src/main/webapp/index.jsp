
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Tasks list</title>
    <link href="resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="header">
        <h1 style="margin-left: 15px; color: white">BPMW</h1>
    </div>

    <div class="menu">
        <input style="margin-top: 5px; margin-left: 680px" width="100" value="">
        <input type="password" width="100" value="">
        <a href="#" class="button">login</a>
    </div>
    <div class="pages">
        <div class="sidebar">
            <h3 style="margin-left: 40px; font-size: 15px">Views</h3>
            <hr>
            <ul>
                <li>view1</li>
                <li>view2</li>
                <li>view3</li>
                <li>view4</li>
            </ul>
            <hr>
        </div>
        <div class="content">
            <table border="1">
                <tr>
                    <td width="100">id</td>
                    <td width="100">Name</td>
                    <td width="300">Text</td>
                    <td width="100">Date</td>
                    <td width="100">User</td>
                    <td width="100">Phone</td>
                    <td width="100">City</td>
                </tr>
                <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                    <tr>
                        <td>${task.id}</td>
                        <td>${task.name}</td>
                        <td>${task.text}</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="foot"></div>
    </div>

    <div class="footer"></div>
</body>
</html>