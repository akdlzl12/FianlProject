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
		    max-width: 60% !important;
			width: 60% !important
		}
		.modal-content {
			padding: 32px;
		}
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/employee/common_view.jsp" %>
	<c:set var="nav_active" value="employee" />
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2">
			<c:set var="side_active" value="search" />
			<%@ include file="/WEB-INF/views/employee/side_employee.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
				<h2 class="page-header">직원조회</h2>
				<c:set var="pageforward" value="/employee/search.esc" />
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
		        	<div class="row">
						<table class="table">
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
								<td class='info' id="td-name" colspan="3"></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td class='info' id="td-birth"></td>
								<th>연락처</th>
								<td class='info' id="td-phone"></td>
								<th>입사일</th>
								<td class='info' id="td-hired-at"></td>
							</tr>
							<tr>
								<th>사원타입</th>
								<td>
									<select name="jobType" class="form-control">
										<option value="T">티켓팅</option>
										<option value="I">안내</option>
									</select>
								</td>
								<th>시급</th>
								<td><input class="info form-control" type="number" name="hourlyPay"></td>
								<th>퇴사일</th>
								<td><input class="info form-control" type="date" name="dismissedAt"></td>
							</tr>
						</table>
						<a id="btn-update" class="btn btn-default"><i class="fa fa-pencil fa-fw"></i> 수정</a>
						
						<div class="row top-margin">
							<div class="col-md-6">
								<h4 class="page-headr">과거이력</h4>
								<table class="table">
									<colgroup>
										<col width="33.3%" />
										<col width="33.3%" />
										<col width="33.3%" />
									</colgroup>
									<thead>
										<tr>
											<th>직원타입</th>
											<th>시작일</th>
											<th>종료일</th>
										</tr>
									</thead>
									<tbody id="tbody-job-history" class='info'>
									
									</tbody>
								</table>
							</div>
							<div class="col-md-6">
								<h4 class="page-headr">징계이력</h4>
								<table class="table">
									<colgroup>
										<col width="30%" />
										<col width="70%" />
									</colgroup>
									<thead></thead>
									<tr id="tr-thief-history">
										<th>징계</th>
										<th>날짜</th>
									</tr>
									<tbody class='info' id='tbody-thief-history'>
										
									</tbody>
								</table>
							</div>
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
	$('#btn-update').click(function() {
		var jobType = $('select[name=jobType]').val(),
		hourlyPay = $('input[name=hourlyPay]').val(),
		dismissedAt = $('input[name=dismissedAt]').val();
		
			
		var data = {
			jobType: jobType,
			hourlyPay: hourlyPay,
			dismissedAt: dismissedAt,
			id: $(this).attr('eid')
		};
		
		$.ajax({
			url: '/employee/update.esc',
			type: 'post',
			dataType: 'json',
			data: data,
			success: function(employee) {
				if(employee.jobType)
					$('select[name=jobType]').val(jobType);
				if(employee.hourlyPay)
					$('input[name=hourlyPay]').val(hourlyPay);
				if(employee.dismissedAt)
					$('input[name=dismissedAt]').val(dismissedAt);
			},
		});
	})
})
function modalSearch(empId) {
	$.ajax({
		type: 'get',
		url: '/employee/detail.esc',
		dataType: 'json',
		data: {id: empId, when: moment().format('YYYY-MM-DD HH:mm:SS')},
		success: function(emp) {
			$('#btn-update').attr('eid', emp.id);
			$('#modal-employee').modal();
			$('#td-id').text(emp.id);
			$('#td-name').text(emp.name);
			
			$('select[name=jobType]').val(emp.jobType);
			$('input[name=hourlyPay]').val(emp.hourlyPay);
			if(emp.dismissedAt) $('input[name=dismissedAt]').val(moment(emp.dismissedAt, 'x').format('YYYY-MM-DD'));
			$('#td-birth').text(moment(emp.birth, 'x').format('YYYY-MM-DD'));
			$('#td-phone').text(emp.phone);
			$('#td-hired-at').text(moment(emp.hiredAt, 'x').format('YYYY-MM-DD'));
			
			var html = '',
			jobHistory = emp.jobHistory,
			thiefRecord = emp.thiefRecord;
			if(jobHistory) {
				$.each(jobHistory, function(index, history) {
					html += "<tr>";
					html += "<td>"+(history.jobType == 'I' ? '안내' : '티켓팅')+"</td>";
					html += "<td>"+moment(history.startedDate, 'x').format('YYYY-MM-DD')+"</td>";
					if(history.endedDate) html += "<td>"+moment(history.endedDate, 'x').format('YYYY-MM-DD')+"</td>";
					html += "</tr>";
				});
				$('#tbody-job-history').append(html);
			}
			
			
			
			html = '';
			
			if(thiefRecord) {
				thiefRecord.forEach(function(index, record) {
					html += "<tr>";
					html += "<td>횡령</td>";
					html += "<td>"+moment(record.timetable.startedAt, 'x').format('YYYY-MM-DD')+"</td>";
					html += "</tr>";
				});
				
			} else {
				html = "<tr><td colspan='2'>징계이력이 없습니다</td></tr>";
			}
			$('#tbody-thief-history').append(html);
			
		}
	});
}
</script>
</html>