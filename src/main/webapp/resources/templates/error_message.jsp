<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<c:if test="${loginModel.errorStatus}">
    <div class="errorMessage">
        <div class="login">
            <h3>Error</h3>
            <hr>
            <li>${loginModel.errorMessage}<br></li>
        </div>
    </div>
</c:if>
