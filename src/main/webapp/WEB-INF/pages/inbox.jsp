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
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 20px">Views</h3>
        <hr>
        <div>
        <ul>
            <c:forEach var="view" items="#{userModel.viewsActiveUser}">
                <li><a href="taskListRequest?view_id=${view.id}" class="list_ref">${view.name}</a><br><br></li>
            </c:forEach>
        </ul>
        </div>
        <hr>
        <a href="viewController" style="height: 12px; width: 100px; margin-left: 25px" class="button">Add new query</a>
    </div>

    <div class="content">
        <h3 style="margin-left: 10%">Tasks group №-${taskModel.taskGroup.id} (${taskModel.taskGroup.name})</h3>
        <hr>
        <table class="table">
            <tr>
                <th width="100">id</th>
                <th width="100">Name</th>
                <th width="300">Text</th>
                <th width="100">Group</th>
                <th width="100">Date in</th>
                <th width="100">Date complete</th>
            </tr>
            <c:forEach var="task" items="#{taskModel.userTasks}">
                <tr>
                    <td>${task.id}</td>
                    <td><a class="list_ref" href="taskList?task_id=${task.id}">${task.name}</a></td>
                    <td>${task.textTask}</td>
                    <td>${task.taskGroup.name}</td>
                    <td>${task.dateIn}</td>
                    <td>${task.dateComplet}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>