<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<head>
    <link href="${uri}/resources/css/preloader_style.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="${uri}/resources/js/preloader_js.js"></script>
</head>

<div class="js">
    <body>
    <div id="preloader"></div>

    </body>
</div>
