<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<style>
		th {
			background: #fff !important;
		}
	</style>
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
					style="text-align: center; margin-top: 80px; margin-bottom: 30px;">한달
					영화관객 수 순위<small id="startDate"></small><small>~</small><small id="endDate"></small></h1>
				<table class="table table-striped table-inverse" style="margin-bottom: 100px;">
					<colgroup>
						<col width="10%" />
						<col width="20%" />
						<col width="20%" />
						<col width="20%" />
						<col width="*%" />
					</colgroup>
					<thead>
						<tr>
							<th>순위</th>
							<th>영화 이름</th>
							<th>제작 국가</th>
							<th>영화 관람객 수</th>
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
$(function() {
	$ulFocus = null;
	$ulSides = $('.ul-side');
	$('.h3-sub-title').click(function() {
		$this = $(this);
		if($ulFocus != null && $this == $ulFocus) {
			$this.next().hide();
			$ulFocus = null;
		} else {
			var uls = $ulSides;
			$.each(uls, function(index, $eachul) {
				$($eachul).hide();
			});
			$this.next().show();
			$ulFocus = $this;
		}
			
		
	});
});

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
				html += "<td>"+item.location+"</td>";
				html += "<td>"+item.no+"</td>";
				html += "</tr>";
				$("#startDate").text("(" + item.startDate + ")");
				$("#endDate").text("(" + item.endDate + ")");
			})
			$("#mainTbody").html(html);
		}
	})
	
var chart1 = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	title: {
		text: "Movie Audience Statistics"
	},
	axisX: {
		title: "Month",
		interval: 1,
		intervalType: "month"
	},
	axisY: {
		title: "관람객 수"
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [
	{
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",
		name: "Top1",
		legendText: "Top1",
		showInLegend: true, 
		dataPoints:[
			{ label: "8 Month", x:11, y: 266.21},
			{ label: "9 Month", x:10, y: 302.25},
			{ label: "10 Month", x:9, y: 157.20}
		]
	},
	{
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",	
		name: "Top2",
		legendText: "Top2",
		showInLegend: true,
		dataPoints:[
			// x: x값이 많은 쪽이 오른쪽부터 정렬
			// y: y값이 많은 쪽이 위쪽부터 정렬
			// label: 라벨을 붙이면 해당하는 x축의 이름으로 삽입됨
			{ label: "8 Month", x:11, y: 10.46},
			{ label: "9 Month", x:10, y: 2.27},
			{ label: "10 Month", x:9, y: 3.99}
		]
        
	},
    {
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",	
		name: "Top3",
		legendText: "Top3",
		showInLegend: true,
		dataPoints:[
			{ label: "8 Month", x:11, y: 10.46},
			{ label: "9 Month", x:10, y: 2.27},
			{ label: "10 Month", x:9, y: 3.99}
		]
    },
    ]
});
chart1.render();

$.ajax({
	type: "GET",
	url: "getMovieAudienceStatisticsSelect.esc",
	dataType: "json",
	success: function(result) {
		console.log(result);
		$testArr = result;
		var data = [];
		
		html = "";
		$.each(result, function(index, item) {
			attendanceName = item.name;
			attendanceRank= item.movieRank;
			attendanceMonth = item.month;
			attendanceNo = item.no;
			
			// 데이터를 업데이트 시킬 때 사용
			// .을 이용해서 해당하는 객체에 접근하여 원하는 값으로 변경하는 코드
			// 1등의 값은 0, 3, 6이므로 %로 나누면 나머지값이 0이되고 0번째 중에 1번째, 2번째, 3번째에 값을
			// 넣을려면 그 값을 3으로 (/)나누어 그값의 나머지 값은 버리고 정수만 가져와 계산하여 해당하는 번지수에 값을 저장
			chart1.options.data[index % 3].dataPoints[Math.floor(index / 3)].y = item.no;
			chart1.options.data[index % 3].dataPoints[Math.floor(index / 3)].indexLabel = item.name.substr(0,3);
			
			console.log(index, Math.floor(index / 3), index % 3, item.name, item.no);
		});
		
		chart1.render();
	}
});


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

// 시네마에서 가장 많이 상영해 주는 영화 순위
var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	title:{
		text: "Most Featured Films"
	},	
	axisX: {
		title: "Month",
		interval: 1,
		intervalType: "month"
	},
	axisY: {
		title: "상영스크린 수"
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [
	{
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",
		name: "Top1",
		legendText: "Top1",
		showInLegend: true, 
		dataPoints:[
			{ label: "8 Month", x: 11, y: 266.21 },
			{ label: "9 Month", x: 10, y: 302.25 },
			{ label: "10 Month", x: 9, y: 157.20 }
		]
	},
	{	
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",	
		name: "Top2",
		legendText: "Top2",
		showInLegend: true,
		dataPoints:[
			{ label: "8 Month", x: 11, y: 10.46 },
			{ label: "9 Month", x: 10, y: 2.27 },
			{ label: "10 Month", x: 9, y: 3.99 }
		]
        
	},
    {
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",	
		name: "Top3",
		legendText: "Top3",
		showInLegend: true,
		dataPoints:[
			{ label: "8 Month", x: 11, y: 10.46 },
			{ label: "9 Month", x: 10, y: 2.27 },
			{ label: "10 Month", x: 9, y: 3.99 }
		]
    }
    ]
});
chart2.render();

$.ajax({
	type: "GET",
	url: "getMostFeaturedFilms.esc",
	dataType: "json",
	success: function(result) {
		console.log(result);
		$.each(result, function(index, item) {
			attendanceName = item.name;
			attendanceRank= item.movieRank;
			attendanceMonth = item.month;
			attendanceNo = item.no;
			
			// 데이터를 업데이트 시킬 때 사용
			// .을 이용해서 해당하는 객체에 접근하여 원하는 값으로 변경하는 코드
			// 1등의 값은 0, 3, 6이므로 %로 나누면 나머지값이 0이되고 0번째 중에 1번째, 2번째, 3번째에 값을
			// 넣을려면 그 값을 3으로 (/)나누어 그값의 나머지 값은 버리고 정수만 가져와 계산하여 해당하는 번지수에 값을 저장
			chart2.options.data[index % 3].dataPoints[Math.floor(index / 3)].y = item.no;
			chart2.options.data[index % 3].dataPoints[Math.floor(index / 3)].indexLabel = item.name.substr(0,3);
			
			console.log(index, Math.floor(index / 3), index % 3, item.name, item.no);
		});
		
		chart2.render();
	}
});


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
		text: "Online/Offline Payment Metrics"
	},	
	axisX: {
		title: "Month",
		interval: 1,
		intervalType: "month"
	},
	axisY: {
		title: "On/Off라인 구매 수"
	},
	legend: {
		cursor:"pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",
		name: "Top1",
		legendText: "OFFLINE",
		showInLegend: true, 
		dataPoints:[
			{ label: "8 Month", x: 11, y: 10.46 },
			{ label: "9 Month", x: 10, y: 2.27 },
			{ label: "10 Month", x: 9, y: 3.99 }
		]
	},
	{
		indexLabelFontSize: 7,
		indexLabelFontWeight: "bolder",
		type: "column",
		name: "Top2",
		legendText: "ONLINE",
		showInLegend: true,
		dataPoints:[
			{ label: "8 Month", x: 11, y: 10.46 },
			{ label: "9 Month", x: 10, y: 2.27 },
			{ label: "10 Month", x: 9, y: 3.99 }
		]
        
	}
    ]
});
chart3.render();

var value = 2;

$.ajax({
	type: "GET",
	url: "getOnlineOfflinePaymentMetrics.esc",
	dataType: "json",
	success: function(result) {
		console.log("chart3");
		console.log(result);
		
		$.each(result, function(index, item) {
			
			console.log(index , value)
			// ON, OFF
			attendanceName = item.purchaseType;
			// ON, OFF의 갯수
			attendanceRank= item.counts;
			// 월
			attendanceMonth = item.months;
			
			// 데이터를 업데이트 시킬 때 사용
			// .을 이용해서 해당하는 객체에 접근하여 원하는 값으로 변경하는 코드
			// 1등의 값은 0, 3, 6이므로 %로 나누면 나머지값이 0이되고 0번째 중에 1번째, 2번째, 3번째에 값을
			// 넣을려면 그 값을 3으로 (/)나누어 그값의 나머지 값은 버리고 정수만 가져와 계산하여 해당하는 번지수에 값을 저장
			chart3.options.data[index % 2].dataPoints[index + value].y = item.counts;
			chart3.options.data[index % 2].dataPoints[index + value].indexLabel = item.purchaseType.substr(0,3);
			console.log("chart3 Value")
			
			if(index % 2 == 0) {
				value = value - 1;
				console.log(value)
			}else if(index % 2 == 1) {
				value = value - 2;
				console.log(value)
			}
			
		});
		
		chart3.render();
	}
});

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