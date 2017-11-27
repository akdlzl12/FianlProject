<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	<style>
        div.row{margin: 10px; padding: 10px;}
    </style>
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
</head>
<body>
	<c:set var="nav_active" value="financial" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="management" />
			<%@ include file="/WEB-INF/views/financial/sidebar/sideBar.jsp"%>
		</div>
		<div class="col-md-10">
			<div class="container" style="margin-top: 50px;">
				<h2 class="page-header">쿠폰 / 사은품 조회 및 수령</h2>
				<div class="row">
					<form id="search-form" class="form-inline">
						<div class="form-group">
							<select class="form-control" id="opt">
								<option value="username">아이디</option>
								<option value="name">이름</option>
								<option value="grade">등급</option>
								<option value="couponId">쿠폰 번호</option>
								<option value="giftId">사은품 번호</option>
							</select> 
							<select class="form-control" id="vip">
								<option value=1>VIP</option>
								<option value=2>PLATINUM</option>
								<option value=3>GOLD</option>
								<option value=4>SILVER</option>
								<option value=5>BRONZE</option>
							</select> 
							<input type="text" class="form-control" id="keyword" />
							<button type="submit" class="btn btn-primary" id="btn-search">조회</button>
						</div>
					</form>
				</div>
				<div class="row box">
					<div>
						<table class="table table-condensed ">
							<thead>
								<tr>
									<th>아이디</th>
									<th>이름</th>
									<th>생일</th>
									<th>연락처</th>
									<th>메일주소</th>
								</tr>
							</thead>
							<tbody id="searchTable">
								
							</tbody>
						</table>
					</div>
					<div class="text-right" style="margin: 8px;">
						<button type="button" class="btn btn-default" id="btn-modal"><i class="fa fa-list fa-fw"></i>상세조회</button>
					</div>
				</div>
				
				<div class="modal fade" id="form-modal" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">상세조회</h4>
							</div>
							<form id="gift-form" action="changeReceived.esc" method="post">
								<div class="modal-body">
									<div class="form-group">
										<table class="table table-condensed">
											<tr>
												<th>아이디</th><td id="detailId" />
												<th>이름</th><td id="detailName" />
												<th>회원등급</th><td id="detailGrade" />
											</tr>
											<tr>
												<th>생일</th><td id="detailBirth" />
												<th>연락처</th><td id="detailPhone" />
												<th>메일주소</th><td id="detailEmail" />
											</tr>
										</table>
									</div>
									<div class="form-group">
										<label class="control-label">쿠폰 내역</label>
										<div class="row box">
											<table class="table table-condensed ">
												<thead>
													<tr>
														<th class="col-sm-3" >쿠폰명</th>
														<th class="col-sm-3" >사용여부</th>
														<th class="col-sm-3" >사용날짜</th>
														<th class="col-sm-3" >만료날짜</th>
													</tr>
												</thead>
												<tbody id="modalCouponTable">
													
												</tbody>
											</table>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label">사은품 내역</label>
										<div class="row box" >
											<table class="table table-condensed ">
												<thead>
													<tr>
														<th class="col-sm-1"><input type="checkbox" id="giftCheck" ></th>
														<th class="col-sm-3">사은품명</th>
														<th class="col-sm-4">수령여부</th>
														<th class="col-sm-4">수령날짜</th>
													</tr>
												</thead>
												<tbody id="modalGiftTable">
													
												</tbody>
											</table>
											<div class="text-right">
												<button id="btn-received" class="btn btn-primary btn-sm" name="updateGiftReceived">수령완료</button>
											</div>
										</div>
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default btn-sm"
										data-dismiss="modal">닫기</button>
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
	
	 // 상세페이지 체크박스 전체 셀렉트
	$('input#giftCheck').change(function() {
			var isChecked = $(this).is(':checked');
			if(isChecked) {
				$('input[name=gid]').prop("checked", true);
			} else {
				$('input[name=gid]').prop("checked", false);
			}
	});
	// 수령변환
	$('#btn-received').click(function(event){
		event.preventDefault();
		
		$.ajax({
			type:'POST',
			url:"changeReceived.esc",
			data:$("#gift-form").serialize(),
			dataType:"text",
			success:function(result) {
				$("input[name=gid]:checked").each(function() {
					$(this).closest("tr").find(".received-td").text("Y");
				});
			}
		})
		
	}); 
	
	// 하이라이트
	$("#searchTable").on("click",".highlight", function() {
	    $(".highlight").css("background-color", "white");
		$(this).css("background-color", "#aaa");
		
		var value = $(this).attr('id');
		
		if(value){
			// 모달
			$("#btn-modal").click(function() {
				$("#form-modal").modal("show");
				
				$.ajax({
					type:"GET",
					url:"searchDetailCustomers.esc",
					data:{
						id:value
					},
					dataType:"json",
					success:function(result){
						$("#detailId").text(result.searchAll.username); 
						$("#detailName").text(result.searchAll.name);
						$("#detailGrade").text(result.searchAll.customerRank.type); 
						$("#detailBirth").text(result.searchAll.birth);
						$("#detailPhone").text(result.searchAll.phone);
						$("#detailEmail").text(result.searchAll.email); 
						var html="";
						$.each(result.searchCoupon, function(index, item) {
							html += "<tr>"
							html += "<td>"+item.coupon.name+"</td>"
							if(item.used == 1){
								html += "<td>Y</td>"
							} else {
								html += "<td>N</td>"
							}
							if(item.receivedAt != null){
								html += "<td>"+item.receivedAt+"</td>"
							} else {
								html += "<td></td>"
							}
							html += "<td>"+item.expiredAt+"</td>"
							html += "</tr>"
						});
						$("#modalCouponTable").html(html);
						var html="";
						$.each(result.searchGift, function(index, item) {
					
							html += "<tr>"
							html += "<td><input type='checkbox' name='gid' value='"+item.id+"'/></td>"
							html += "<td>"+item.gift.name+"</td>"
							if(item.received == 1){
								
								html += "<td class='received-td'>Y</td>"
							} else {
								html += "<td class='received-td'>N</td>"
							}
							if(item.receivedAt != null){
								html += "<td>"+item.receivedAt+"</td>"
							} else {
								html += "<td></td>"
							}
							html += "</tr>"
						});
						$("#modalGiftTable").html(html);
						
					}
				})
				
			})
		} else {
			history.go;
		}
	}); 
	// 검색 
	$("#btn-search").click(function(e) {
			e.preventDefault();
			
			var type = $("#opt").val();
			var searchValue = $("#keyword").val();
			if(type == "grade"){
				searchValue = $("#vip").val();
			}
			$.ajax({
				type : "POST",
				url : "searchCustomers.esc",
				data : {
					opt : type,
					keyword : searchValue
				},
				dataType : "json",
				success : function(result) {
					var html = "";
					
					$.each(result, function(index, item) {
						html += "<tr class='highlight' style='background-color: white' id='"+item.id+"'>"
						html += "<td>" + item.username + "</td>"
						html += "<td>" + item.name + "</td>"
						html += "<td>" + item.birth + "</td>"
						html += "<td>" + item.phone + "</td>"
						html += "<td>" + item.email + "</td>"
						html += "</tr>"
					})
					$("#searchTable").html(html);
				}
			})
		});
	// 등급, 검색 화면처리
	$("#vip").hide();
	$("#opt").change(function(){
		if($(this).val() == 'grade') {
			$("#vip").show();
			$("#keyword").hide();
		} else {
			$("#vip").hide();
			$("#keyword").show();
		}
	})
	
});
</script>
</html>