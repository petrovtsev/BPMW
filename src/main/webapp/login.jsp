<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>

<head>
    <title>Login</title>
    <link href="${uri}/resources/css/login.css" rel="stylesheet" type="text/css" />
    <link href="${uri}/resources/css/components.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="resources/templates/preloader.jsp"/>
<jsp:include page="resources/templates/header.jsp"/>
<jsp:include page="/resources/templates/message.jsp"/>

    <div class="pages">

        <div class="authorization">

            <div class="authorization_data">

                <form action="loginController" method="post">

                    <h3>Login</h3>

                    <hr>

                    Input for username:<br>
                    <input class="input_text_auth" name="login" type="text"><br>

                    <br>Input for password:<br>
                    <input class="input_text_auth" name="password" type="password"><br>

                    <div class="side-button">
                        <input class="button" type="submit" value="Authorization"><br>
                        <a href="register.jsp" class="button-fix" >Register</a>
                        <a href="add_task.jsp" class="button-fix" >Add task</a>
                    </div>

                </form>

            </div>

        </div>

    </div>

<c:if test="${loginModel.errorStatus}">

    <div class="errorMessage">

        <div class="login">
            <h3>Error</h3>
            <hr>
            <li>${loginModel.errorMessage}<br></li>
        </div>

    </div>

</c:if>

</body>
</html>