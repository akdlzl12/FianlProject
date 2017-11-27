<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
</head>
<body>
	<c:set var="nav_active" value="common" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="register" />
			<%@ include file="/WEB-INF/views/homeSideBar.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container">
				<h1
					style="text-align: center; margin-top: 80px; margin-bottom: 30px;">금일
					영화관객 수 순위</h1>
				<table class="table table-striped table-inverse"
					style="margin-bottom: 100px;">
					<thead>
						<tr>
							<th>Rank</th>
							<th>Movie Name</th>
						</tr>
					</thead>
					<tbody id="mainTbody">
						
					</tbody>
				</table>

				<h1 style="text-align: center; margin-bottom: 30px;">영화 통계 차트</h1>

				<table class="table" style="margin-bottom: 100px;">
					<tbody>
						<tr>
							<td><div id="chartContainer1"
									style="height: 220px; width: 80%;"></div></td>
							<td><div id="chartContainer2"
									style="height: 220px; width: 80%;"></div></td>
							<td><div id="chartContainer3"
									style="height: 220px; width: 80%;"></div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>	
</body>
<script>
window.onload = function () {
	
	$.ajax({
		type: "GET",
		url: "getMovieRankName.esc",
		dataType: "json",
		success:function(result) {
				console.log(result);
			html = "";
			$.each(result, function(index, item) {
				html += "<tr>";
				html += "<th scope='row'>"+item.movieRank+"</th>";
				html += "<td>"+item.name+"</td>";
				html += "</tr>";
			})
			$("#mainTbody").html(html);
		}
	})

var chart1 = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	title:{
		text: "Crude Oil Reserves vs Production, 2016"
	},	
	axisY: {
		title: "Billions of Barrels",
		titleFontColor: "#4F81BC",
		lineColor: "#4F81BC",
		labelFontColor: "#4F81BC",
		tickColor: "#4F81BC"
	},
	axisY2: {
		title: "Millions of Barrels/day",
		titleFontColor: "#C0504E",
		lineColor: "#C0504E",
		labelFontColor: "#C0504E",
		tickColor: "#C0504E"
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "column",
		name: "Proven Oil Reserves (bn)",
		legendText: "Top1",
		showInLegend: true, 
		dataPoints:[
			{ label: "11 Month", y: 266.21 },
			{ label: "10 Month", y: 302.25 },
			{ label: "9 Month", y: 157.20 }
		]
	},
	{
		type: "column",	
		name: "Oil Production (million/day)",
		legendText: "Top2",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
        
	},
    {
		type: "column",	
		name: "333",
		legendText: "Top3",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
    }
    ]
});
chart1.render();

function toggleDataSeries(e) {
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else {
		e.dataSeries.visible = true;
	}
	chart1.render();
}
    
//-----------------------------------------------------------------------------------------------------
    
var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	title:{
		text: "Crude Oil Reserves vs Production, 2016"
	},	
	axisY: {
		title: "Billions of Barrels",
		titleFontColor: "#4F81BC",
		lineColor: "#4F81BC",
		labelFontColor: "#4F81BC",
		tickColor: "#4F81BC"
	},
	axisY2: {
		title: "Millions of Barrels/day",
		titleFontColor: "#C0504E",
		lineColor: "#C0504E",
		labelFontColor: "#C0504E",
		tickColor: "#C0504E"
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "column",
		name: "Proven Oil Reserves (bn)",
		legendText: "Top1",
		showInLegend: true, 
		dataPoints:[
			{ label: "11 Month", y: 266.21 },
			{ label: "10 Month", y: 302.25 },
			{ label: "9 Month", y: 157.20 }
		]
	},
	{
		type: "column",	
		name: "Oil Production (million/day)",
		legendText: "Top2",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
        
	},
    {
		type: "column",	
		name: "333",
		legendText: "Top3",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
    }
    ]
});
chart2.render();

function toggleDataSeries(e) {
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else {
		e.dataSeries.visible = true;
	}
	chart2.render();
}

//------------------------------------------------------------------------------------------------------

var chart3 = new CanvasJS.Chart("chartContainer3", {
	animationEnabled: true,
	title:{
		text: "Crude Oil Reserves vs Production, 2016"
	},	
	axisY: {
		title: "Billions of Barrels",
		titleFontColor: "#4F81BC",
		lineColor: "#4F81BC",
		labelFontColor: "#4F81BC",
		tickColor: "#4F81BC"
	},
	axisY2: {
		title: "Millions of Barrels/day",
		titleFontColor: "#C0504E",
		lineColor: "#C0504E",
		labelFontColor: "#C0504E",
		tickColor: "#C0504E"
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "column",
		name: "Proven Oil Reserves (bn)",
		legendText: "Top1",
		showInLegend: true, 
		dataPoints:[
			{ label: "11 Month", y: 266.21 },
			{ label: "10 Month", y: 302.25 },
			{ label: "9 Month", y: 157.20 }
		]
	},
	{
		type: "column",	
		name: "Oil Production (million/day)",
		legendText: "Top2",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
        
	},
    {
		type: "column",	
		name: "333",
		legendText: "Top3",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints:[
			{ label: "11 Month", y: 10.46 },
			{ label: "10 Month", y: 2.27 },
			{ label: "9 Month", y: 3.99 }
		]
    }
    ]
});
chart3.render();

function toggleDataSeries(e) {
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else {
		e.dataSeries.visible = true;
	}
	chart3.render();
}    
    
}
</script>
</html>