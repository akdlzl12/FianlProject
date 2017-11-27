<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
	<script src="/resources/js/employee.js"></script>
	
	<style>
		.form-group {
			margin-top: 24px;
		}
	</style>	
</head>
<body>
	<c:set var="nav_active" value="employee" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<%@ include file="/WEB-INF/views/employee/common_view.jsp" %>
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="register" />
			<%@ include file="/WEB-INF/views/employee/side_employee.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
				<h2 class="page-header">직원등록</h2>
				<form id="form-register" action="/employee/register.esc" class="form-horizontal" method="post">
					<div class="form-group">
					    <label class="col-md-1 control-label">이름</label>
					    <div class="col-md-4">
					    	<input type="text" class="form-control" name="name" value="김춘신" required>
						</div>
						<label class="col-md-1 control-label">시급</label>
					    <div class="col-md-4">
					    	<input type="number" class="form-control" name="hourlyPay" value="6450" required>
						</div>
					</div>
					<span id="spanName" class="help-block"></span>
					
					
					<div class="form-group">
					    <label class="col-md-1 control-label">생년월일</label>
					    <div class="col-md-4">
					    	<input type="date" class="form-control" name="birth" value="1990-05-05" required>
					    	
						</div>
					
					    <label class="col-md-1 control-label">연락처</label>
					    <div class="col-md-4">
					    	<input type="text" class="form-control" name="phone" value="010-0505-0505" required>
					    	<span id="spanPhone" class="help-block"></span>
						</div>
					</div>
					
					<div class="form-group">
					    <label class="col-md-1 control-label">직원타입</label>
					    <div class="col-md-4">
					    	<select name="jobType" class="form-control">
					    		<option value="T" selected>티켓팅</option>
					    		<option value="I">안내</option>
					    	</select>
						</div>
					
					    <label class="col-md-1 control-label">입사일</label>
					    <div class="col-md-4">
					    	<input id="inputDate" type="date" class="form-control" name="hiredAt" required>
					    	<span id="spanHireDate" class="help-block"></span>
						</div>
					</div>
					
					
					<div class="form-group">
					    <label class="col-md-1 control-label">주소</label>
					    <div class="col-md-9">
					    	<input type="text" class="form-control" name="address" value="서울시 종로구 돈화문로 13" required>
					    	<span id="spanAddress" class="help-block"></span>
						</div>
					</div>
					
					<div class="form-group">
					    <label class="col-md-1 control-label">계좌번호</label>
					    <div class="col-md-9">
					    	<input type="text" class="form-control" name="accountNo" value="84984-0881-3648" required>
					    	<span id="spanAccountNo" class="help-block"></span>
						</div>
					</div>
					
					<div class="form-group">
					    <label class="col-md-1 control-label">성별</label>
					    <div class="col-md-4">
					    	<input type="radio" class="btn-input" name="gender" value="M" content="남자" checked/>
					    	<input type="radio" class="btn-input" name="gender" value="F" content="여자"/>
						</div>
					</div>
					
					
						
					<div class="col-md-10" style="margin-top: 36px;">
						<button class="btn btn-primary btn-block" type="submit"><i class="fa fa-user-plus fa-fw"></i>등록</button>
					</div>
				</form>
			</div>
			
		</div>
	</div>
	
</body>
<script>
	$(function() {
		var namePattern = /[가-힇]{2,10}/,
		phonePattern = /[0-9]{2,4}-[0-9]{2,4}-[0-9]{2,4}/,
		accountNoPattern = /[0-9]{3,}-[0-9]{3,}-[0-9]{4,}/;
		
		var $inputName = $('input[name=name]'),
		$inputPhone = $('input[name=phone]'),
		$inputHireDate = $('input[name=hiredAt]'),
		$inputAccountNo = $('input[name=accountNo]'),
		$spanName = $('#spanName'),
		$spanPhone = $('#spanPhone'),
		$spanAccountNo = $('#spanAccountNo');
		
		document.getElementById('inputDate').valueAsDate = new Date();
		
		$('#form-register').submit(function(){
			if(!namePattern.test($inputName.val())) {
				$spanName.text('이름은 한글로 최소 2자입니다');
				return false;
			} else $spanName.text('');
			if(!phonePattern.test($inputPhone.val())) {
				$spanPhone.text('연락처를 형식에 맞춰서 적어주세요 < 예     010-0000-0000 >');
				return false;
			} else $spanPhone.text('');
			if(!accountNoPattern.test($inputAccountNo.val())) {
				$spanAccountNo.text('계좌번호를 입력해주세요 < 예     123-456-7890 >');
				return false;
			} else $spanAccountNo.text('');
			
			return true;
		});
	});
</script>
</html>