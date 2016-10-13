<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Register</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="resources/js/register_js.js"></script>
</head>

<body>

<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="pages">
    <div class="authorization" style="margin-top: 6%; height: 450px">
        <div class="login">
            <h3>Register</h3>
            <hr>
            <form action="registerController" method="post">
                <div style="text-align: left">
                    <label>Login:</label>
                    <input name="login" style="width: 170px;" class="input_text" type="text" size="50" id="login"> <span></span><br>

                    <label>Mail:</label>
                    <input name="email" style="width: 170px;" class="input_text" type="text" size="50" id="email"> <span></span><br>

                    <label>Password:</label>
                    <input name="password" style="width: 170px;" class="input_text" type="password" size="50" id="password"> <span></span><br>

                    <label>Confirm password:</label>
                    <input name="password2" style="width: 170px;" class="input_text" type="password" size="50" id="password2"> <span></span><br>

                    <label>First name:</label>
                    <input style="width: 170px;" class="input_text" name="firstName"/><br>

                    <label>Last name:</label>
                    <input style="width: 170px;" class="input_text" name="lastName"/><br>

                    <label>City:</label>
                    <input style="width: 170px;" class="input_text" name="city"/><br>

                    <label>Group:</label>
                    <select style="width: 170px;" class="select-box" name="taskGroupId" id="taskGroupId">
                        <c:forEach var="group" items="#{taskGroupModel.returnAllGroups()}">
                            <option placeholder="Selected task group" value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select><br>

                    <label>Phone number:</label>
                    <input style="width: 170px;" class="input_text" id="phone" name="phone"/>
                    <br><br>
                </div>
                <button class="button" style="width: 128px; height: 26px" name="reset" type="reset">Reset</button>
                <input class="button" style="width: 128px; height: 26px" id="submit" name="submit" type="submit" value="Next" disabled><br>
                <a href="login.jsp" class="button" style="width: 230px; margin-top: 5px; height: 12px">Login</a>
                <div id="messageDiv" style="display:none;"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
