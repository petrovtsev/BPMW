<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Login</title>
    <link href="${uri}/resources/css/login.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="resources/templates/preloader.jsp"/>
<jsp:include page="resources/templates/header.jsp"/>

    <div class="pages">
        <div class="authorization" style="margin-top: 10%; height: 250px">
            <div class="login">
                <form action="loginController" method="post">
                    <h3>Login</h3>
                    <hr>
                    Input for username:<br>
                    <input class="input_text" style="width: 260px; padding: 6px 14px; text-align:center" name="username" type="text"><br>
                    <br>Input for password:<br>
                    <input class="input_text" style="width: 260px; padding: 6px 14px; text-align:center" name="password" type="password"><br><br/>
                    <input class="button" style="width: 260px; height: 26px" type="submit" value="Authorization"><br>
                    <a href="register.jsp" class="button" style="width: 98px; margin-top: 6px; height: 12px">Register</a>
                    <a href="add_task.jsp" class="button" style="width: 98px; margin-top: 6px ; height: 12px">Add task</a>
                </form>
            </div>
        </div>
    </div>
<script>

</script>
</body>
</html>