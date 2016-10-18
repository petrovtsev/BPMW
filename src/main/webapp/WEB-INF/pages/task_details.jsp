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
                    <td class="col-right">Text:</td>
                    <td>${taskDetailsModel.selectedTask.textTask}</td>
                </tr>
                <tr>
                    <td class="col-right">Date in:</td>
                    <td>${taskDetailsModel.selectedTask.dateIn}</td>
                </tr>

                <c:if test="${taskDetailsModel.selectedTask.userComplet.login != null}">
                    <tr>
                        <td class="col-right">Date complete:</td>
                        <td>${taskDetailsModel.selectedTask.dateComplet}</td>
                    </tr>
                    <tr>
                        <td class="col-right">User complete:</td>
                        <td>${taskDetailsModel.selectedTask.userComplet.login}</td>
                    </tr>
                    <tr>
                        <td class="col-right">Comment:</td>
                        <td>${taskDetailsModel.selectedTask.comment}</td>
                    </tr>
                </c:if>

                <c:if test="${taskDetailsModel.selectedTask.userComplet.login == null}">
                    <tr>
                        <td class="col-right">Comment</td>
                        <td><input type="text" name="comment" class="input_text"></td>
                    </tr>
                </c:if>

            </table>
            <br>
            <input type="hidden" name="taskId" value="${taskDetailsModel.selectedTask.id}">
            <div class="side-button">
                <button type="button" class="button" name="back" onclick="history.back()">Back</button>
                <c:if test="${taskDetailsModel.selectedTask.userComplet.login == null}">
                    <button type="submit" class="button">Close Task</button>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>
</html>