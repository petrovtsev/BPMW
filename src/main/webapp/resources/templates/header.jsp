<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="header">
    <img src="${uri}/resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; width: 300px"/>
    <c:if test="${req.userPrincipal.name != null}">
        <a style="margin-left: 47%; margin-top: 12px" href="userController?name=${req.userPrincipal.name}">
            <img src="${uri}/resources/icons/ic_account_white.png" style="width: 3%; margin-top: 2px">
        </a>
    </c:if>
</div>