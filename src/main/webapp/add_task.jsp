<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>

<head>
    <title>Add task</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/components.css" rel="stylesheet" type="text/css" />
</head>

<body>

<jsp:include page="resources/templates/preloader.jsp"/>
<jsp:include page="/resources/templates/header.jsp"/>
<jsp:include page="/resources/templates/message.jsp"/>

<div class="pages">

    <div class="add_task">

        <div class="add_task_data">

            <form action="addTask" method="post">

                <h3>Describe the problem</h3>
                <hr>

                <table class="data-table">

                    <tr>
                        <td width="90">Name: </td>
                        <td><input class="input_text_add" value="${addTaskModel.task.name}" name="name"/></td>
                    </tr>

                    <tr>
                        <td>Text: </td>
                        <td><textarea class="input_text_add" name="textTask">${addTaskModel.task.textTask}</textarea></td>
                    </tr>

                    <tr>
                        <td>Email: </td>
                        <td><input class="input_text_add" value="${addTaskModel.task.email}" name="email"/></td>
                    </tr>

                    <tr>
                        <td>Group id: </td>
                        <td>
                            <select class="select-box_add" name="taskGroup" id="taskGroup">
                                <c:forEach var="group" items="#{taskGroupModel.returnAllGroups()}">
                                    <option placeholder="Selected task group" value="${group.id}">${group.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                </table>

                <div class="side-button">
                    <button class="button_reg" name="reset" type="reset">Reset</button>
                    <button class="button_reg" name="submit" id="submit" type="submit">Next</button><br>
                    <a href="login.jsp" class="button-fix_reg">Login</a>
                </div>

            </form>

        </div>

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