<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>List views</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
    <link href="${uri}/resources/css/components.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar-nav.jsp"/>
    <jsp:include page="templates/message.jsp"/>
    <div class="content">
        <h3>All views user ${req.userPrincipal.name}</h3>
        <hr>
        <table class="table">
            <tr>
                <td class="col-center" width="40">id</td>
                <td width="150">Name</td>
                <td width="300">Date start</td>
                <td width="100">Date end</td>
                <td width="100">Status complete</td>
            </tr>
            <c:forEach var="view" items="#{listViewsModel.viewsActiveUser}">
                <tr>
                    <td class="col-center">${view.id}</td>
                    <td><a class="list_ref" href="viewDetails?view_id=${view.id}">${view.name}</a></td>
                    <td>${view.dateStart}</td>
                    <td>${view.dateEnd}</td>
                    <td>${view.statusComplete}</td>
                    <td><a href="listViews?action=del&idView=${view.id}"><img class="small_icon" src="${uri}/resources/icons/ic_delete_forever_black_24dp_2x.png"></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>