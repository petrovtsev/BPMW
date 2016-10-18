<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>Statistic</title>
    <link href="${uri}/resources/css/inbox.css" rel="stylesheet" type="text/css" />
    <link href="${uri}/resources/css/components.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="${uri}/resources/js/graphs.js"></script>
    <script>
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Year', '${req.userPrincipal.name}'],
                <c:forEach var="data" items="#{staticticTaskModel.dataGraph}">
                [new Date(${data.key}),  ${data.value}],
                </c:forEach>
            ]);

            var options = {
                vAxis: {minValue: 0}
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/menu.jsp"/>
<div class="pages">
    <jsp:include page="templates/sidebar-nav.jsp"/>
    <div class="content">
        <form>
            <h3>Statistic</h3>
            <hr>
            <table class="data-table">
                <tr>
                    <td width="140">Total task execution:</td>
                    <td>95</td>
                </tr>
                <tr>
                    <td>The average time of the task:</td>
                    <td>74 h</td>
                </tr>
            </table>
            <hr>
            <div class="side-button">
                <a class="list_ref" href="statisticTask?day=7">7 day</a>
                <a class="list_ref" href="statisticTask?day=15">15 day</a>
                <a class="list_ref" href="statisticTask?day=30">1 month</a>
                <a class="list_ref" href="statisticTask?day=365">1 year</a>
            </div>
            <div id="chart_div"></div>
        </form>

        <div style=" margin-bottom: 10px; text-align: center">
        </div>
    </div>
</div>
</body>
</html>