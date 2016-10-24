<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE HTML>

<html>

<head>
    <title>Register</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/components.css" rel="stylesheet" type="text/css" />
    <script src="resources/js/jquery-latest.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script src="resources/js/register_js.js"></script>
    <script src="resources/js/jquery.maskedinput.js"></script>
    <script src="jquery.js" type="text/javascript"></script>
</head>

<body>

<jsp:include page="${uri}/resources/templates/preloader.jsp"/>
<jsp:include page="${uri}/resources/templates/header.jsp"/>
<jsp:include page="${uri}/resources/templates/message.jsp"/>

<div class="pages">

    <div class="register">
            <h3>Register</h3>
            <hr>
        <form action="registerController" method="post">

            <div class="register_data">

                <label>Login:</label>
                <input name="login" class="input_text_reg" type="text" size="50" id="login" value="${registerModel.user.login}"> <span></span><br>

                <label>Mail:</label>
                <input name="email" class="input_text_reg" type="text" size="50" id="email" value="${registerModel.user.email}"> <span></span><br>

                <label>Password:</label>
                <input name="password" class="input_text_reg" type="password" size="50" id="password"> <span></span><br>

                <label>Confirm password:</label>
                <input name="password2" class="input_text_reg" type="password" size="50" id="password2"> <span></span><br>

                <label>First name:</label>
                <input name="firstName" class="input_text_reg" value="${registerModel.user.firstName}"/><br>

                <label>Last name:</label>
                <input name="lastName" class="input_text_reg" value="${registerModel.user.lastName}"/><br>

                <label>Date birth:</label>
                <input name="dateBirth"  class="input_text_reg" type="date" value="${registerModel.user.dateBirth}"/><br>

                <label>City:</label>
                <input name="city" class="input_text_reg" id="city" value="${registerModel.user.city}" /><br>

                <label>Group:</label>
                <select name="taskGroup" class="select-box" id="taskGroup">
                    <c:forEach var="group" items="#{taskGroupModel.returnAllGroups()}">
                        <option placeholder="Selected task group" value="${group.id}">${group.name}</option>
                    </c:forEach>
                </select><br>

                <label>Phone number:</label>
                <input name="phone" class="input_text_reg" id="phone" value="${registerModel.user.phone}" /><br>

            </div>

        <div class="side-button">
            <button class="button_reg" name="reset" type="reset">Reset</button>
            <button class="button_reg" name="submit" id="submit" type="submit" disabled>Next</button><br>
            <a href="login.jsp" class="button-fix_reg">Login</a>
        </div>

        </form>

    </div>

    <c:if test="${validateService.errorStatus}">
        <div class="errorMessage">
            <div class="login">
                <h3>Error</h3>
                <hr>
                <c:forEach var="error" items="#{validateService.errorList}">
                    <li>${error}<br><br></li>
                </c:forEach>
            </div>
        </div>
    </c:if>

</div>

</body>

</html>