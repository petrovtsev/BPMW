<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>
<head>
    <title>Tasks list</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="taskList" method="post">
        <a href="userController?name=${req.userPrincipal.name}" class="list_ref" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <input class="input_text" placeholder="input name task" style="margin-top: 10px; margin-left: 17%; width: 17%"  value="">
        <a style="height: 12px; width: 7%" class="button">Search</a>
        <a href="loginController?action=logout" style="margin-left: 8.3%; width: 7%; height: 12px" class="button">Exit</a>
    </form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Views</h3>
        <hr>
        <ul>
            <c:forEach var="view" items="#{userModel.viewsActiveUser}">
                <a href="#" class="list_ref">${view.name}</a><br><br>
            </c:forEach>
        </ul>
        <hr>
        <a href="view_details.jsp" style="height: 12px; width: 100px; margin-left: 20px" class="button">Add new query</a>
    </div>

    <div class="content">
        <h3 style="margin-left: 10%">All tasks group - ${taskModel.nameUserGroup}</h3>
        <hr>

        <table border="1" class="table">
            <tr>
                <td width="100">id</td>
                <td width="100">Name</td>
                <td width="300">Text</td>
                <td width="100">Group</td>
                <td width="100">Date in</td>
                <td width="100">Date complete</td>
                <td width="100"> </td>
            </tr>
            <c:forEach var="task" items="#{taskModel.userTasks}">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.name}</td>
                    <td>${task.textTask}</td>
                    <td>${task.taskGroup.name}</td>
                    <td>${task.dateIn}</td>
                    <td>${task.dateComplet}</td>
                    <td><a class="list_ref" href="taskList?task_id=${task.id}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>