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
    <jsp:include page="templates/preloader.jsp"/>
    <jsp:include page="templates/header.jsp"/>
    <jsp:include page="templates/menu.jsp"/>
    <div class="pages">
        <div class="sidebar">
            <h3>Views</h3>
            <hr>
            <div>
            <ul>
                <c:forEach var="view" items="#{userModel.viewsActiveUser}">
                    <li><a href="taskListRequest?view_id=${view.id}" class="list_ref">${view.name}</a><br><br></li>
                </c:forEach>
            </ul>
            </div>
            <hr>
            <div class="side-button">
                <a href="viewController" class="button-fix">Add new query</a>
            </div>
        </div>
        <div class="content">
            <h3>Tasks group №-${taskListModel.taskGroup.id} (${taskListModel.taskGroup.name})</h3>
            <hr>
            <table class="table">
                <tr>
                    <td class="col-center" width="40">id</td>
                    <td width="150">Name</td>
                    <td width="300">Text</td>
                    <td width="100">Group</td>
                    <td width="100">Date in</td>
                    <td width="100">Date complete</td>
                </tr>
                <c:forEach var="task" items="#{taskListModel.userTasks}">
                    <tr>
                        <td class="col-center">${task.id}</td>
                        <td><a class="list_ref" href="taskDetails?task_id=${task.id}">${task.name}</a></td>
                        <c:if test="${task.textTask.length() > 50}"><td>${task.textTask.substring(0, 50)}....</td></c:if>
                        <c:if test="${task.textTask.length() < 51}"><td>${task.textTask}</td></c:if>
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