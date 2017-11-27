<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>	
</head>
<body>
	<c:set var="nav_active" value="management" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="register" />
			<%@ include file="/WEB-INF/views/management/sidebar/sideBar.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container" style="margin-top: 50px;">
			<h2 class="page-header">키인 관리</h2>
       <div style="overflow: auto;" class="box">
            <form action="KeyInManagement.esc">
                <table class="table">
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="checkAll" id="checkAll"></th>
                            <th>키인 명</th>
                            <th>금액</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody id="mainTbody">
                    	<c:forEach var="keyIns" items="${getKeyInAllSelect }">
	                        <tr>
	                            <td><input type="checkbox" name="key" value="${keyIns.id}"></td>
	                            <td>${keyIns.type }</td>
	                            <td>${keyIns.price }</td>
	                            <td>${keyIns.detail }</td>
	                        </tr>
                    	</c:forEach>
                        
                        
                    </tbody>
                </table>
                <div class="text-right" style="margin-left: 10px;">
                    <button type="submit" class="btn btn-danger" id="btn-open-modal"><i class="fa fa-trash fa-fw"></i>삭제</button>
                </div>
            </form>
        </div>
        
        <h2 class="page-header">키인 추가</h2>
        <div style="overflow: auto;" class="box">
            <form class="form-horizontal" action="">
                <div class="form-group">
                     <label class="control-label col-xs-1" for="keyinname">키인 명:</label>
                     <div class="col-sm-10">
                       <input type="text" class="form-control" id="keyinname" placeholder="키인 명" name="keyinname">
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="money">금액:</label>
                     <div class="col-sm-10">          
                       <input type="text" class="form-control" id="money" placeholder="금액" name="money">
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="detail">비고:</label>
                     <div class="col-sm-10">
                        <textarea name="detail" id="detail" cols="" rows="5" class="form-control"></textarea>
                     </div>
                </div>
                <div class="form-group">        
                    <div class="text-right" style="padding-right: 13px;">
                      <button type="button" class="btn btn-primary" id="insertKeyIn"><i class="fa fa-user-plus fa-fw fa-fw"></i>추가</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	$(function() {
		
		// 저장버튼을 눌렀을때
		$("#insertKeyIn").click(function(e) {
			e.preventDefault();
			var keyInName = $("#keyinname").val();
			var money = $("#money").val();
			var detail = $("#detail").val();
			
			// 값을 다 입력하면  ajax실행
			if(keyInName && money && detail) {
				$.ajax({
					type: "GET",
					url: "setByKeyIn.esc",
					dataType: "JSON",
					data: {type: keyInName, price: money, detail: detail},
					success: function(result) {
						var html = "";
						$.each(result, function(index, item) {
							html += "<tr>";						
							html += "<td><input type='checkbox' name='key' value='"+item.id+"'></td>";						
							html += "<td>"+item.type+"</td>";						
							html += "<td>"+item.price+"</td>";						
							html += "<td>"+item.detail+"</td>";						
							html += "</tr>";						
						})
						$("#mainTbody").html(html);
					}
				})
			// 값을 다 입력하지 않으면 알럿이 뜨면서 정지	
			}else {
				alert("값을 입력하지 않았습니다. 값을 입력해 주세요.");
				e.preventDefault();
			}
			// 입력폼 초기화
			$("#keyinname").val("");
			$("#money").val("");
			$("#detail").val("");
		})
		
		// 최상위 체크박스 클릭 시 하위 체크박스 모두 선택
		$("#checkAll").click(function() {
			$(":input[name='key']").prop('checked', this.checked)
		})
		
		// 삭제버튼 클릭 시 체크박스가 선택되지 않으면 삭제 되지 않음
		$("#btn-open-modal").click(function(e) {
			if(!$("input[name=key]:checked").val()) {
				alert("체크박스를 선택하지 않았습니다. 체크박스를 선택해 주세요.");
				e.preventDefault();
				return;
			}else {
				$("#btn-open-modal").submit();
			}
		})
	})
</script>
</html>