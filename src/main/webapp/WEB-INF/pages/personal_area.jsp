<%@ page import="com.bpmw.web.controllers.task.TaskListController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Personal area</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar.jsp"/>
    <div class="content">
        <form>
            <h3 style="margin-left: 10%">My Account</h3>
            <hr>
            <table class="data-table">
                <tr>
                    <td width="150">Login</td>
                    <td><input class="input_text" value="${userModel.activeUser.login}"/></td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td><input class="input_text" value="${userModel.activeUser.firstName}"/></td>
                </tr>
                    <td>Last name</td>
                    <td><input class="input_text" value="${userModel.activeUser.lastName}"/></td>
                </tr>
                <tr>
                <td>Date birth</td>
                    <td><input class="input_text" value="${userModel.activeUser.dateBirth}"/></td>
                </tr>
                <tr>
                <td>City</td>
                    <td><input class="input_text" value="${userModel.activeUser.city}"/></td>
                </tr>
                <tr>
                    <td>Group</td>
                    <td><input class="input_text" value="${userModel.activeUser.taskGroup.name}"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input class="input_text" value="${userModel.activeUser.phone}"/></td>
                </tr>
                <tr>
                    <td>Mail</td>
                    <td><input class="input_text" value="${userModel.activeUser.mail}"/></td>
                </tr>
            </table>
        </form>
        <br><br>
        <div style=" margin-bottom: 10px; text-align: center">
            <button type="button" class="button" style="width: 15%; height: 26px" name="back" onclick="history.back()">Back</button>
            <button class="button" type="submit" style="width: 15%; height: 26px">Save</button>
        </div>
    </div>
</div>
</body>
</html>