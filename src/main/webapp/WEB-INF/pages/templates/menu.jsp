<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="menu">
    <form action="taskList" method="post">
        <a href="userController?name=${req.userPrincipal.name}" class="list_ref" style="margin-left: 15%;
        display: inline-block; margin-top: 8px; width: 15%">User name: ${req.userPrincipal.name}</a>
        <input class="input_text" placeholder="input name task" style="margin-top: 8px; margin-left: 8.5%; width: 17%"  value="">
        <a style="height: 12px; width: 7%; margin-top: 8px" class="button">Search</a>
        <a href="loginController?action=logout" style="margin-left: 8.3%; width: 7%; height: 12px; margin-top: 8px" class="button">Exit</a>
    </form>
</div>