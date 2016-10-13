<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>
<head>
    <title>View Task</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${taskModel.selectedTask.userComplet.login != null}">
    <style>
        .headLabel {
            color: green;
        }
    </style>
</c:if>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar.jsp"/>
    <div class="content">
        <h3 class="headLabel" style="margin-left: 10%">Task №-${taskModel.selectedTask.id} (${taskModel.selectedTask.name})</h3>
        <hr>

        <form action="taskController" method="get">
            <table class="data-table">
                <tr>
                    <td style="width:140px">Text:</td>
                    <td>${taskModel.selectedTask.textTask}</td>
                </tr>
                <tr>
                    <td>Date in:</td>
                    <td>${taskModel.selectedTask.dateIn}</td>
                </tr>
                <c:if test="${taskModel.selectedTask.userComplet.login != null}">
                <tr>
                    <td>Date complete:</td>
                    <td>${taskModel.selectedTask.dateComplet}</td>
                </tr>
                <tr>
                    <td>User complete:</td>
                    <td>${taskModel.selectedTask.userComplet.login}</td>
                </tr>
                </c:if>

                <c:if test="${taskModel.selectedTask.userComplet.login == null}">
                    <tr>
                        <td>Comment</td>
                        <td><input type="text" name="comment" class="input_text"></td>
                    </tr>
                </c:if>

                <c:if test="${taskModel.selectedTask.userComplet.login == null}">
                    <tr>
                        <td>Comment</td>
                        <td><input type="text" name="comment" class="input_text"></td>
                    </tr>
                </c:if>
            </table>
            <br>
            <input type="hidden" name="taskId" value="${taskModel.selectedTask.id}">
            <div style="text-align: center; margin: 10px">
                <button type="button" class="button" style="width: 15%; height: 26px; margin-top: 5px" name="back" onclick="history.back()">Back</button>
                <c:if test="${taskModel.selectedTask.userComplet.login == null}">
                <a class="button" href="taskController?idTask=${taskModel.selectedTask.id}" style="height: 12px ;margin-top: 6px; width: 15%">Close Task</a>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>
</html>