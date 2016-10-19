<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<c:if test="${validateService.errorStatus}">
    <hr>
    <h3>Error</h3>
    <c:forEach var="error" items="#{validateService.errorList}">
        <br>
        <li style="color: red">${error}<br><br></li>
    </c:forEach>
    <hr>
</c:if>
