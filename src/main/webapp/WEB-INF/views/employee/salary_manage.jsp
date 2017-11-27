<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
	<script src="/resources/js/employee.js"></script>
	<style>
		.modal-lg {
	    max-width: 80% !important;
		width: 80% !important
		}
		.modal-content {
			padding: 16px;
		}
		.info {
			background: #fff !important;
		}
	</style>
</head>
<body>
	<c:set var="nav_active" value="employee" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<%@ include file="/WEB-INF/views/employee/common_view.jsp" %>
	<div class="row">
		<div class="col-md-2">
			<c:set var="side_active" value="salary" />
			<%@ include file="/WEB-INF/views/employee/side_employee.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
				<h2 class="page-header">급여관리</h2>
				<c:set var="pageforward" value="/employee/salary_manage.esc" />
				<%@ include file="/WEB-INF/views/employee/search_employee.jsp" %>
			</div>
		</div>
	</div>
	<div id="modal-employee" class="modal fade" tabindex="-1" role="dialog" style="padding: 12px;">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">직원 상세정보</h4>
				</div>
		      	<div class="modal-body" style="padding: 12px !important; margin: 12px !important;">
					<div class="box">
						<h4 class="page-header">급여관리</h4>
						<div class="row">
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-4"><input name="year" type="number" class="form-control info" /></div>
									<div class="col-md-1"><p style="font-size: 1.3em;">년</p></div>
									<div class="col-md-4"><input name="month" type="number" class="form-control info" /></div>
									<div class="col-md-1"><p style="font-size: 1.3em;">월</p></div>
									<div class="col-md-1"><button id="btn-search" class="btn btn-default"><i class="fa fa-check fa-fw"></i>검색</button></div>
								</div>
							</div>
							<div class="col-md-1 col-md-offset-6">
								<a id="btn-excel" class="btn btn-success"><i class="fa fa-table fa-fw"></i> 엑셀</a>
							</div>
						</div>
						<table class="table top-margin">
							<colgroup>
								<col width="10%" />
								<col width="23.3%" />
								<col width="10%" />
								<col width="23.3%" />
								<col width="10%" />
								<col width="23.3%" />
							</colgroup>
							<tr>
								<th>사원번호</th>
								<td class='info' id="td-id"></td>
								<th>이름</th>
								<td class='info' id="td-name"></td>
								<th>사원타입</th>
								<td class='info' id="td-job-type"></td>
							</tr>
							<tr>
								<th>계좌번호</th>
								<td class='info' colspan="3" id="td-account-no"></td>
								<th>시급</th>
								<td class='info' id="td-hourly-pay"></td>
							</tr>
						</table>
					</div>
				
					<div class="box top-margin" style="padding: 4px 8px;">
						<div class="row">
							<div class="col-md-6">
								<h4 class="page-header">근태 조회</h4>
								<table class="table">
									<colgroup>
										<col width="40%" />
										<col width="15%" />
										<col width="15%" />
										<col width="15%" />
										<col width="15%" />
									</colgroup>
									<thead>
										<tr>
											<th>최종 근무시간</th>
											<th>지각</th>
											<th>조퇴</th>
											<th>결근</th>
											<th>무단결근</th>
										</tr>
									</thead>
									<tbody class='info' id="tbody-management">
									
									</tbody>
									
								</table>
								<div class="text-right">
									<a id="btn-manage-salary" class="btn btn-default"><i class="fa fa-star fa-fw"></i> 근태 반영</a>
								</div>
								
							</div>
							<div class="col-md-6">
								
								<h4 class="page-header">정산차이</h4>
								<table class="table">
									<colgroup>
										<col width="40%" />
										<col width="40%" />
									</colgroup>
									<thead>
										<tr>
											<th>금액</th>
											<th>날짜</th>
										</tr>
									</thead>
									<tbody class='info' id="tbody-mismatch">
									
									</tbody>
									
								</table>
								<div class="text-right">
									<a id="btn-mismatch" class="btn btn-default"><i class="fa fa-check fa-fw"></i> 반영</a>
								</div>
								
							</div>
						</div>
					</div>
					<div class="box top-margin">
						<div class="row" style="padding: 4px 16px;">
							<h4 class="page-header">급여내역</h4>
							<table class="table">
								<colgroup>
									<col width="20%" />
									<col width="40%" />
									<col width="40%" />
								</colgroup>
								<tr>
									<th>보험료 (4대보험)</th>
									<td>10% 공제</td>
									<td id="td-insurance"></td>
								</tr>
								<tr id="tr-salary">
									<th>총액</th>
									<td></td>
									<td class='info' id="td-salary"></td>
								</tr>
								<tr>
									<th>실수령액</th>
									<td></td>
									<td class='info' id="td-real-salary"></td>
								</tr>
							</table>
						</div>
					</div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
		      	</div>
	    	</div>
	  	</div>
	</div>
</body>
<script>
$(function() {
	$trSalary = $('#tr-salary');
	$tdRealSalary = $('#td-real-salary');
	
	$('#btn-excel').click(function(e) {
		
		var url = '/employee/salary_excel.esc?id='+getEmpId()+'&when='+eWhen;
		
		window.open(url);
	});
	
	$('#btn-mismatch').click(function() {
		if($('#tr-mismatch').length > 0) return;

		var totalMismatch = 0;
		$tdMismatch = $('.td-mismatch-money');
		
		$.each($tdMismatch, function(index, $td) {
			totalMismatch += parseInt($($td).text());
		});
		
		
		
		var html = "<tr class='info' id='tr-mismatch'>";
		html += "<th>정산차이</th>";
		html += "<td></td>";
		html += "<td>"+totalMismatch+"</td>";
		html += "</tr>";
		
		$trSalary.before(html);
		
		var nowRealSalary = parseInt($tdRealSalary.text());
		$tdRealSalary.text(nowRealSalary + totalMismatch);
	});
	
	$('#btn-manage-salary').click(function() {
		if($('#tr-manage').length > 0) return;
		$tds = $('#tbody-management').find('td');
		var total = 0;
		$.each($tds, function(index, $td) {
			if(index > 0 ) {
				total += parseInt($($td).text());
			}
		});
		var manageSalary = (1000 * total);
		
		
		var html = "<tr class='info' id='tr-manage'>";
		html += "<th>근태관리</th>";
		html += "<td></td>";
		html += "<td>-"+manageSalary+"</td>";
		html += "</tr>";
		$trSalary.before(html);
		
		var nowRealSalary = parseInt($tdRealSalary.text());
		$tdRealSalary.text(nowRealSalary - manageSalary);
	});
	
	$('#btn-search').click(function() {
		$('td.info').text('');
		$('tr.info').remove();
		$('tbody.info').empty();
		
		requestSalary();
	});
});
var getEmpId = (function() {
	var emp;
	return function(empId) {
		if(empId) emp = empId;
		return emp;
	};
})();

var eWhen;

function requestSalary(isFirst) {
	var empId = getEmpId();
	var data = {id: parseInt(empId)};
	
	if(isFirst)  {
		data.when = moment().format('YYYY-MM-DD HH:mm:SS');
		$('input[name=year]').val(moment().format('YYYY'));
		$('input[name=month]').val(moment().format('MM'));
	}
	else {
		
		var year = parseInt($('input[name=year]').val());
		var month = parseInt($('input[name=month]').val());
		
		if(!/[0-9]{4}/.test(year))
			alert('연도를 형식에 맞춰 입력해주세요');
		else if(!/[0-9]{1,2}/.test(month))
			alert('월을 형식에 맞춰 입력해주세요');
 		data.when = year +'-'+ month+'-' + '01'+ ' ' + '00:00:00';
	}
	eWhen = data.when;
	$.ajax({
		url: '/employee/detail.esc',
		type: 'get',
		dataType: 'json',
		data: data,
		success: function(emp) {
			console.log(emp);
			$('td.info').text('');
			$('tbody.info').empty();
			
			$('#td-id').text(emp.id);
			$('#td-name').text(emp.name);
			$('#td-job-type').text(emp.jobType === 'T' ? '티켓팅' : '안내');
			$('#td-account-no').text(emp.accountNo);
			$('#td-hourly-pay').text(emp.hourlyPay);
			
			
			var l = 0, e = 0, a = 0, u = 0;
			$.each(emp.managements, function(index, management) {
				if(management.detail === 'U')
					u++;
				else if(management.detail === 'E')
					e++;
				else if(management.detail === 'L')
					l++;
				else if(management.detail === 'A')
					a++;
			});
			var html = "<tr>";
			html += "<td>"+emp.workingHoursPerMonth+"</td>";
			html += "<td>"+l+"</td>";
			html += "<td>"+e+"</td>";
			html += "<td>"+a+"</td>";
			html += "<td>"+u+"</td>";
			html += "</tr>";
			$('#tbody-management').append(html);
			$tbodyMismatch = $('#tbody-mismatch');
			$.each(emp.mismatches, function(index, mismatch) {
				var html = "<tr>";
				html += "<td class='td-mismatch-money'>-"+mismatch.mismatchMoney+"</td>";
				html += "<td>"+moment(mismatch.workingDate, 'x').format('YYYY-MM-DD')+"</td>";
				html += "</tr>";
				$tbodyMismatch.append(html);
			});
			
			var salary = emp.salary;
			var insurance = salary / 10;
			$('#td-insurance').text('-'+insurance);
			$('#td-salary').text(salary);
			$('#td-real-salary').text(salary - insurance);
			
			$('#modal-employee').modal();
		}
	});
}

function modalSearch(empId) {
	getEmpId(empId);
	requestSalary(true);
}
</script>
</html>