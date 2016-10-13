<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="menu">
    <form action="taskList" method="post">
        <ul class="selector">
            <li><a href="loginController?action=logout">Exit</a></li>
            <li><a href="" class="list_ref">User name:</a></li>
            <li><a>Search</a></li>
        </ul>
    </form>
</div>