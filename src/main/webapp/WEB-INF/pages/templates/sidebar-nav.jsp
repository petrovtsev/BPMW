<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>
<!DOCTYPE HTML>

<div class="sidebar-nav">
    <h3>Navigation</h3>
    <hr>
    <ul>
        <li>
            <a href="userController">
                <img src="${uri}/resources/icons/ic_account_box_black.png" class="small_icon">
                <label>Personal area</label>
            </a>
        </li>
        <li>
            <a href="tasksList">
                <img src="${uri}/resources/icons/ic_view_list_black.png" class="small_icon">
                <label>Tasks list</label>
            </a>
        </li>
        <li>
            <a href="statisticTask?day=15">
                <img src="${uri}/resources/icons/ic_show_chart_black.png" class="small_icon">
                <label>Statistic</label>
            </a>
        </li>
        <li>
            <a href="listViews?action=allViews">
                <img src="${uri}/resources/icons/ic_search_black.png" class="small_icon">
                <label>Views</label>
            </a>
        </li>
    </ul>
</div>