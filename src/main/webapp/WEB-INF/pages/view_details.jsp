<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<html>

<head>
    <title>View details</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
    <link href="${uri}/resources/css/components.css" rel="stylesheet" type="text/css" />
</head>

<body>

<jsp:include page="templates/preloader.jsp"/>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>

<div class="pages">

    <jsp:include page="templates/sidebar-nav.jsp"/>
    <jsp:include page="templates/message.jsp"/>

    <div class="content">
        <h3>Views</h3>
        <hr>

        <form action="viewDetails" method="post">

            <table class="data-table-account">

                <tr class="col-right">
                    <td>Name view: </td>
                    <td><input class="input_text" value="${viewDetailsModel.selectedView.name}" name="name"/><br><br></td>
                </tr>

                </tr>
                    <td class="col-right">Status task: </td>
                    <td>
                        <label class="radio">
                            <input type="radio" name="statusComplete" value="all" /> all<br>
                        </label>
                        <label class="radio">
                            <input type="radio" name="statusComplete" value="completed" /> completed<br>
                        </label>
                        <label class="radio">
                            <input type="radio" name="statusComplete" value="notCompleted" /> not completed<br>
                        </label>
                    </td>

                </tr>

                <tr>
                    <td class="col-right">Date: </td>
                    <td>
                        <input name="dateStart" class="input_text" type="date" value="${viewDetailsModel.selectedView.strDateStart()}"/>
                        <input name="dateEnd"  class="input_text" type="date" value="${viewDetailsModel.selectedView.strDateStart()}"/>
                    </td>
                </tr>

                <input hidden name="user" id="user" value="${req.userPrincipal.name}">

            </table>

            <div class="side-button">

                <jsp:include page="templates/error_message.jsp"/>

                <button type="button" class="little_button" name="back" onclick="history.back()">Back</button>

                <c:if test="${viewDetailsModel.selectedView.id != null}">
                    <a href="listViews?action=del&idView=${viewDetailsModel.selectedView.id}" class="button-fix">Delete</a>
                </c:if>

                <c:if test="${viewDetailsModel.selectedView.id == null}">
                    <button type="reset" class="little_button" >Reset</button>
                </c:if>

                <button type="submit" class="little_button" >Save</button>

            </div>

        </form>

    </div>

</div>

</body>

</html>