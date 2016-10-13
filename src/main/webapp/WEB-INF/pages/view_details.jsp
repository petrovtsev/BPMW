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
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar.jsp"/>
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
                        <input name="dateStart" class="input_text" style="width: 45%" type="date" value="2015-01-01"/> -
                        <input name="dateEnd"  class="input_text" style="width: 45%" type="date" value="2016-10-10"/>
                    </td>
                </tr>
            </table>
            <br>
            <div style="text-align: center; margin: 10px">
                <button type="submit" class="button" style="width: 15%; height: 26px">Save</button>
                <button type="button" class="button" style="width: 15%; height: 26px" name="back" onclick="history.back()">Back</button>
            </div>
        </form>
    </div>

</div>
</body>
</html>