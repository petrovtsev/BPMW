<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Tasks list</title>
</head>
<body>


<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>text</th>
    </tr>

    <c:forEach var="task" items="${task}">
        <tr>
            <td>${task.id}</td>
            <td>${task.name}</td>
            <td>${task.text}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>