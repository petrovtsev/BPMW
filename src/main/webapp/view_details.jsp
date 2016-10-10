<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>
<head>
    <title>Search</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>



<body>
<div class="header">
    <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="${pageContext.request.contextPath}/taskList" method="post">
        <a href="personal_area.jsp" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: Admin</a>
        <a href="inbox.jsp" style="height: 15px; width: 7%; margin-left: 25%; margin-top: 10px" class="button">Back to list</a>
        <a href="../login.jsp" style="height: 15px; width: 7%; margin-left: 16%; margin-top: 10px" class="button">Exit</a></form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <a href="#">${task.name}</a><br>
            </c:forEach>
        </ul>
        <hr>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new task" class="button"/>
    </div>
    <div class="content">
        <h3 style="margin-left: 10%">Search</h3>
        <hr>

        <form action="viewController" method="post">
            <table class="data-table">
                <tr>
                    <td style="width: 150px">Name task</td>
                    <td><input name="name"/></td>
                </tr>

                <tr>
                    <td style="width: 150px">Request</td>
                    <td><input name="request"/></td>
                </tr>
                </tr>
                    <td>Show</td>
                    <td><input type="radio" name="browser" value="all"> all<br>
                        <input type="radio" name="browser" value="completed"> completed<br>
                        <input type="radio" name="browser" value="notCompleted"> not completed</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td><input name="dateStart" type="date" value=""/> - <input name="dateEnd" type="date" value=""/></td>
                </tr>
                <tr>
                    <td>Date complete</td>
                    <td><input value=""/></td>
                </tr>
                <tr>
                    <td>User complete</td>
                    <td><input value=""/></td>
                </tr>
            </table>
            <input class="button" style="width: 170px; height: 25px" type="submit" value="Next">
        </form>
    </div>

    <div class="footer">
        <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Save</a>
        <a href="#" class="button">Remove</a>
        <a href="inbox.jsp" class="button">Back</a>
    </div>
</div>
</body>
</html>