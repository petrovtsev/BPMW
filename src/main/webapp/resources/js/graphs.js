google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Year', '${req.userPrincipal.name}'],
    <c:forEach var="data" items="#{taskModel.dataGraph}">
      [new Date(${data.key}),  ${data.value}],
    </c:forEach>
  ]);

  var options = {
    vAxis: {minValue: 0}
  };

  var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
  chart.draw(data, options);
}
