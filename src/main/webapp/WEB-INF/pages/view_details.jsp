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
<jsp:include page="templates/preloader.jsp"/>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar-nav.jsp"/>
    <div class="content">
        <h3>Search</h3>
        <hr>
        <form action="viewController" method="post">
            <table class="data-table">
                <tr>
                    <td style="width: 150px">Name view:</td>
                    <td><input class="input_text" value="${viewModel.selectedView.name}" name="name"/><br><br></td>
                </tr>
                </tr>
                    <td>Status task:</td>
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
                    <td>Date</td>
                    <td style="width: 350px">
                        <input name="dateStart" class="input_text" style="width: 45%" type="date" value="${viewModel.selectedView.userRequest.dateStart}"/> -
                        <input name="dateEnd"  class="input_text" style="width: 45%" type="date" value="${viewModel.selectedView.userRequest.dateEnd}"/>
                    </td>
                </tr>
            </table>
            <br>
            <div class="side-button">
                <button type="submit" class="button" >Save</button>
                <button type="button" class="button" name="back" onclick="history.back()">Back</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>