<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="sidebar">
    <a href="tasksList" class="list_ref"><h3 class="headLable">Tasks list</h3></a>
    <hr>
    <ul>
        <c:forEach var="task" items="#{taskListModel.userTasks}">
            <li><a href="taskDetails?task_id=${task.id}" class="list_ref">${task.name}</a></li><br>
        </c:forEach>
    </ul>
</div>
