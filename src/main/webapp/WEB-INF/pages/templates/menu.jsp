<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="userController">Account</a></li>
            <li><a href="tasksList">Task List</a></li>
            <li><a href="statisticTask?day=15">Statistic</a></li>
            <li style="float:right"><a href="loginController?action=logout">Exit</a></li>
        </ul>
    </div>
</div>