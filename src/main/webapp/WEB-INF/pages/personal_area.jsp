<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Personal area</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar-nav.jsp"/>
    <div class="content-account">
        <form>
            <h3>My Account</h3>
            <hr>
            <table class="data-table-account">
                <tr>
                    <td class="col-right" width="150">Login: </td>
                    <td width="250"><input class="input_text" value="${userModel.activeUser.login}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_account_black.png"></td>
                </tr>
                <tr>
                    <td class="col-right">First name: </td>
                    <td><input class="input_text" value="${userModel.activeUser.firstName}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_mode_edit_black.png"></td>
                </tr>
                    <td class="col-right">Last name: </td>
                    <td><input class="input_text" value="${userModel.activeUser.lastName}"/></td>
                <td><img class="small_icon" src="${uri}/resources/icons/ic_mode_edit_black.png"></td>
                </tr>
                <tr>
                    <td class="col-right">Date birth: </td>
                    <td><input class="input_text" type="date" value="${userModel.activeUser.dateBirth}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_today_black.png"></td>
                </tr>
                <tr>
                    <td class="col-right">City: </td>
                    <td><input class="input_text" value="${userModel.activeUser.city}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_location_city_black.png"></td>
                </tr>
                <tr>
                    <td class="col-right">Group: </td>
                    <td><input class="input_text" value="${userModel.activeUser.taskGroup.name}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_work_black_36d.png"></td>
                </tr>
                <tr>
                    <td class="col-right">Phone: </td>
                    <td><input class="input_text" value="${userModel.activeUser.phone}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_phone_black.png"></td>
                </tr>
                <tr>
                    <td class="col-right">Mail: </td>
                    <td><input class="input_text" value="${userModel.activeUser.mail}"/></td>
                    <td><img class="small_icon" src="${uri}/resources/icons/ic_mail_outline_black.png"></td>
                </tr>
            </table>
        </form>
        <br><br>
        <div class="side-button">
            <button type="button" class="button" name="back" onclick="history.back()">Back</button>
            <button class="button" type="submit">Save</button>
        </div>
    </div>
</div>
</body>
</html>