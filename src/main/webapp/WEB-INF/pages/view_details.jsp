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
    <form action="taskList" method="post">
        <a href="userController?name=${req.userPrincipal.name}" class="list_ref" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: ${req.userPrincipal.name}</a>
        <input class="input_text" placeholder="input name task" style="margin-top: 10px; margin-left: 17%; width: 17%"  value="">
        <a style="height: 12px; width: 7%" class="button">Search</a>
        <a href="loginController?action=logout" style="margin-left: 8.3%; width: 7%; height: 12px" class="button">Exit</a>
    </form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <a class="list_ref" href="taskList?task_id=${task.id}">${task.name}</a><br>
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
                    <td><input class="input_text" name="name"/><br><br></td>
                </tr>
                </tr>
                    <td>Show</td>
                    <td><input type="radio" name="statusComplete" class="radio" value="all"> all<br>
                        <input type="radio" name="statusComplete" class="radio" value="completed"> completed<br>
                        <input type="radio" name="statusComplete" class="radio" value="notCompleted"> not completed</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td>
                        <input name="dateStart" class="input_text" style="width: 40%" type="date" value="2015-01-01"/> -
                        <input name="dateEnd"  class="input_text" style="width: 40%" type="date" value="2016-10-10"/>
                    </td>
                </tr>
            </table>
            <br>
            <button type="submit" class="button" style="width: 15%; height: 26px; margin-top: 5px; margin-left: 34%">Save</button>
            <button type="button" class="button" style="width: 15%; height: 26px; margin-top: 5px; margin-left: 2%" name="back" onclick="history.back()">Back</button>
        </form>
    </div>

</div>
</body>
</html>