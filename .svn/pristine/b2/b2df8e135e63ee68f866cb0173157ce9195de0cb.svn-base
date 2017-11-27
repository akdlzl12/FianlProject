<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Home</title>
<style>

div.row {
	margin: 10px;
	padding: 10px;
}

.margin-right {
	margin-right: 16px;
}
</style>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
	<c:set var="nav_active" value="management" />

	<%@ include file="/WEB-INF/views/common/nav.jsp"%>
	<div class="row">
		<div class="col-md-2 div-side" >
			<c:set var="side_active" value="calculate" />
			<%@ include file="/WEB-INF/views/financial/sidebar/sideBar.jsp"%>
		</div>
		<div class="col-md-10">
			<div class="container" style="margin-top: 50px;">
				<h2 class="page-header">단말기 정산</h2>
				<div class="row box">
					<div class="col-md-3">
						<label class="margin-right">날짜</label><input type="date" />
					</div>
					<div class="col-md-3">
						<label class="margin-right">단말기 번호</label> <select name="posNo">
							<option name="id">B01</option>
							<option name="id">B02</option>
						</select>
					</div>
					<div class="col-md-3">
						<label class="margin-right">판매자</label> <select name="seller">
							<option>강감찬</option>
							<option>리순신</option>
						</select>
					</div>
				</div>
				<div class="row box">
					<div>
						<table class="table table-condensed ">
							<thead>
								<tr>
									<th>시간</th>
									<th>구매목록</th>
									<th>총 금액</th>
									<th>할인액</th>
									<th>결제금액</th>
								</tr>
							</thead>
							<tbody>
								<tr class="highlight">
									<td>17:23</td>
									<td>범죄도시(성인)</td>
									<td>7000</td>
									<td>0</td>
									<td>7000</td>
								</tr>
								<tr class="highlight">
									<td>18:55</td>
									<td>토르(청소년)</td>
									<td>8000</td>
									<td>-1000</td>
									<td>7000</td>
								</tr>
								<tr class="highlight">
									<td>19:30</td>
									<td>범죄도시(성인)</td>
									<td>8000</td>
									<td>0</td>
									<td>8000</td>
								</tr>
								<tr class="highlight">
									<td>21:35</td>
									<td>가르시아</td>
									<td>12000</td>
									<td>0</td>
									<td>12000</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-6">
						<label><strong class="margin-right">기본금 :</strong>200000</label>
					</div>
					<div class="col-md-6">
						<label><strong class="margin-right">총 결제 금액 :</strong>200000</label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-11">
						<button type="button" class="btn btn-default" id="btn-modal"><i class="fa fa-list fa-fw"></i>상세조회</button>
					</div>
				</div>
				<div class="modal fade" id="form-modal" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">상세조회</h4>
							</div>
							<form>
								<div class="modal-body">
									<label class="control-label">구매 목록</label>
									<div class="row" style="border: 2px solid grey;">
										<table class="table table-condensed ">
											<thead>
												<tr>
													<th class="col-sm-3">상품명</th>
													<th class="col-sm-1">수량</th>
													<th class="col-sm-2">금액</th>
													<th class="col-sm-3">할인명</th>
													<th class="col-sm-3">할인금</th>
												</tr>
											</thead>
											<tbody>
												<div class="form-group">
													<tr class="highlight">
														<td class="col-sm-3">토르(청소년)</td>
														<td class="col-sm-1">1</td>
														<td class="col-sm-2">12000</td>
														<td class="col-sm-3">어린이날</td>
														<td class="col-sm-3">-1000</td>
													</tr>
													<tr class="highlight">
														<td class="col-sm-3">토르(청소년)</td>
														<td class="col-sm-1">1</td>
														<td class="col-sm-2">12000</td>
														<td class="col-sm-3">어린이날</td>
														<td class="col-sm-3">-1000</td>
													</tr>
												</div>
												<div id="total">
													<tr>
														<td>총액</td>
														<td></td>
														<td>24000</td>
														<td></td>
														<td>-2000</td>
													</tr>
												</div>
											</tbody>
										</table>
									</div>
								</div>
								<div class="modal-footer">
									<div class="col-sm-12">
										<label><strong class="margin-right">총 결제 금액 :</strong>22000</label>
									</div>
									<div class="col-sm-12">
										<button type="button" class="btn btn-default btn-sm"
											data-dismiss="modal">닫기</button>
									</div>
									<!--<button type="submit" class="btn btn-primary btn-sm" id="btn-add-todo">등록</button>-->
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("#btn-modal").click(function() {
			$("#form-modal").modal("show");
	});
	$(".highlight").click(function() {
	    $(".highlight").css("background-color", "white");
	    $(this).css("background-color", "grey");
	})
});
</script>
</html>