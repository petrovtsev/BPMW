<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>
<head>
    <script src="${uri}/resources/js/message.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<c:if test="${messageService.messageStatus}">
    <div class="message_box">
        <c:forEach var="message" items="#{messageService.messages}">
            <div class="mes">${message}</div><br>
        </c:forEach>
    </div>
</c:if>
