<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>
<head>
    <title>Task details</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
    <link href="${uri}/resources/css/components.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar.jsp"/>
    <div class="content">
        <h3>Task №-${taskDetailsModel.selectedTask.id} (${taskDetailsModel.selectedTask.name})</h3>
        <hr>

        <form action="taskDetails" method="post">
            <table class="data-table">
                <tr>
                    <td class="col1">Text:</td>
                    <td class="col2">${taskDetailsModel.selectedTask.textTask}</td>
                </tr>
                <tr>
                    <td class="col1">Email:</td>
                    <td class="col2">${taskDetailsModel.selectedTask.email}</td>
                </tr>

                <tr>
                    <td class="col1">Date in:</td>
                    <td class="col2">${taskDetailsModel.selectedTask.dateIn}</td>
                </tr>

                <c:if test="${taskDetailsModel.selectedTask.userComplet.login != null}">
                    <tr>
                        <td class="col1">Date complete:</td>
                        <td class="col2">${taskDetailsModel.selectedTask.dateComplet}</td>
                    </tr>
                    <tr>
                        <td class="col1">User complete:</td>
                        <td class="col2">${taskDetailsModel.selectedTask.userComplet.login}</td>
                    </tr>
                    <tr>
                        <td class="col1">Comment:</td>
                        <td class="col2">${taskDetailsModel.selectedTask.comment}</td>
                    </tr>
                </c:if>

                <c:if test="${taskDetailsModel.selectedTask.userComplet.login == null}">
                    <tr>
                        <td class="col1">Comment</td>
                        <td class="col2"><input type="text" name="comment" class="input_text"></td>
                    </tr>
                </c:if>

            </table>
            <br>
            <input type="hidden" name="taskId" value="${taskDetailsModel.selectedTask.id}">
            <div class="side-button">
                <button type="button" class="little_button" name="back" onclick="history.back()">Back</button>
                <c:if test="${taskDetailsModel.selectedTask.userComplet.login == null}">
                    <button type="submit" class="little_button">Close Task</button>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>
</html>