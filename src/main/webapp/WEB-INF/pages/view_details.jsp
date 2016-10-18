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
        <h3>Search</h3>
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
                        <input name="dateStart" class="input_text" type="date" value="${viewDetailsModel.selectedView.dateStart}"/>
                        <input name="dateEnd"  class="input_text" type="date" value="${viewDetailsModel.selectedView.dateEnd}"/>
                    </td>
                </tr>
            </table>
            <br>
            <div class="side-button">
                <button type="button" class="button" name="back" onclick="history.back()">Back</button>
                <button type="submit" class="button" >Save</button>
                <c:if test="${viewDetailsModel.selectedView.id != null}">
                    <a href="listViews?action=del&idView=${viewDetailsModel.selectedView.id}" class="button">Delete</a>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>
</html>