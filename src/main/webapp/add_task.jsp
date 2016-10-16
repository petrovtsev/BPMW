<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Add task</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="resources/templates/preloader.jsp"/>
<jsp:include page="/resources/templates/header.jsp"/>
<div class="pages">
    <div class="authorization" style="margin-top: 10%; height: 250px">
        <div class="login">
            <form action="addTask" method="post">
                <h3>${addTaskModel.message}</h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Name</td>
                        <td><input class="input_text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Text</td>
                        <td><input class="input_text" name="text"/></td>
                    </tr>
                    <td>Group id</td>
                    <td>
                        <select class="select-box" name="groupId" id="taskGroupId">
                            <c:forEach var="group" items="#{taskGroupModel.returnAllGroups()}">
                                <option placeholder="Selected task group" value="${group.id}">${group.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    </tr>
                </table>
                <br>
                <input class="button" style="width: 128px; height: 26px" type="submit" value="Next">
                <input class="button" style="width: 128px; height: 26px" type="reset" value="Reset"><br>
                <a href="login.jsp" class="button" style="width: 230px; margin-top: 5px; height: 12px">Login</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>