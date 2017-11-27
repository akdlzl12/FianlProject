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
			<h2 class="page-header">할인 이벤트 조회</h2>
       <div style="overflow: auto;" class="box">
            <form action="deleteDiscountEvent.esc">
                <table class="table">
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="checkAll"></th>
                            <th>할인 명</th>
                            <th>분류</th>
                            <th>할인율</th>
                            <th>적용대상</th>
                            <th>키인설명</th>
                            <th>시작날짜</th>
                            <th>종료날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="value" items="${discountList }">
	                        <tr>
	                            <td><input type="checkbox" name="checkId" value="${value.id }"></td>
	                            <td>${value.name }</td>
	                            <td>
	                            	<c:choose>
	                            		<c:when test="${value.discountType == 'P'}">
	                            			퍼센트
	                            		</c:when>
	                            		<c:when test="${value.discountType == 'F'}">
	                            			고정가 할인
	                            		</c:when>
	                            		<c:when test="${value.discountType == 'S'}">
	                            			고정가 판매
	                            		</c:when>
	                            	</c:choose>
	                            </td>
	                            <td>
	                            	<c:choose>
	                            		<c:when test="${value.discountPrice != null}">
	                            			${value.discountPrice }	
	                            		</c:when>
	                            		<c:when test="${value.discountPercent != null}">
	                            			${value.discountPercent }%	
	                            		</c:when>
	                            	</c:choose>
	                            	
	                            </td>
	                            <td>
	                            	<c:if test="${value.customerType.type == null || value.customerType.type == ''}">
	                            		전체
	                            	</c:if>
	                            	${value.customerType.type }
	                            </td>
	                            <td>${value.detail }</td>
	                            <td><fmt:formatDate value="${value.startedDate }" pattern="yyyy-MM-dd"/></td>
	                            <td><fmt:formatDate value="${value.endDate }" pattern="yyyy-MM-dd"/></td>
	                        </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
                <div class="form-group text-right">
                	<button class="btn btn-danger" type="submit" id="btnDelete"><i class="fa fa-trash fa-fw"></i>삭제</button>
                </div>
            </form>
        </div>
        
        <h2 class="page-header">할인 이벤트 등록</h2>
        <div style="overflow: auto;" class="box">
            <form class="form-horizontal" action="addDiscountEvent.esc">
                <div class="form-group">
                     <label class="control-label col-xs-1" for="name">할인 명:</label>
                     <div class="col-sm-5">
                       <input type="text" class="form-control" id="name" placeholder="할인 명" name="name">
                     </div>
                
                     <label class="control-label col-xs-1" for="customerTypeId">적용대상:</label>
                     <div class="col-sm-5">          
                       <select name="customerTypeId" id="customerTypeId" class="form-control">
                           <option value="4">전체</option>
                           <c:forEach var="value" items="${customerTypeList }">
	                           <option value="${value.id }">${value.type }</option>
                           </c:forEach>
                       </select>
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="discountType">분류:</label>
                     <div class="col-sm-5">
                       <select name="discountType" id="discountType" class="form-control">
                           <option value="P">%할인</option>
                           <option value="S">고정가 할인</option>
                           <option value="F">고정가 판매</option>
                       </select>
                     </div>
                	
                	 <div id="dpt">
	                     <label class="control-label col-xs-1" for="discountPercent">할인율:</label>
	                     <div class="col-sm-5">          
	                       <input type="text" class="form-control" id="discountPercent" placeholder="금액" name="discountPercent">
	                     </div>
                     </div>
                     
                     <div id="dpe">
	                     <label class="control-label col-xs-1" for="discountPrice">할인금액:</label>
	                     <div class="col-sm-5">          
	                       <input type="text" class="form-control" id="discountPrice" placeholder="금액" name="discountPrice">
	                     </div>
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="startedDate">시작날짜:</label>
                     <div class="col-sm-5">
                     	<input type="date" class="form-control" name="startedDate" id="startedDate">
                     </div>
                
                     <label class="control-label col-xs-1" for="endDate">종료날짜:</label>
                     <div class="col-sm-5">          
                       <input type="date" class="form-control" id="endDate" name="endDate">
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="detail">상세설명:</label>
                     <div class="col-sm-10">
                       <textarea name="detail" id="detail" cols="140" rows="10"></textarea>
                     </div>
                </div>
                <div class="form-group">        
                    <div class="text-right" style="padding-right: 13px;">
                      <button type="submit" class="btn btn-primary" id="btnInsert"><i class="fa fa-user-plus fa-fw fa-fw"></i>추가</button>
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
		// 고정가격 input숨기기
		$("#dpe").hide();
		// %할인 input보이기
		$("#dpt").show();
		// 셀렉트박스 클릭시
		$("#discountType").click(function() {
			
			// 값이 p이면 %할인이 보이고 고정가격을 숨긴다.
			if($(this).val() == 'P') {
				$("#dpt").show();
				$("#dpe").hide();
			// 값이 p가 아니면 %할인을 숨기고 고정가격을 보이게 한다.	
			}else {
				$("#dpt").hide();
				$("#dpe").show();
			}
		})
		
		// 최상위에 있는 체크박스 선택시 하위에 있는 모든 체크박스 선택
		$("input[name=checkAll]").click(function() {
			$("input[name=check]").prop("checked", this.checked);
		})
		
		// 저장버튼 클릭시 값을 입력하지 않거나 날짜값이 시작일보다 끝일이 크면 알럿을 띄움
		$("#btnInsert").click(function(e) {
			
			var name = $("#name").val();
			var customerTypeId = $("#customerTypeId").val();
			var discountType = $("#discountType").val();
			var discountPercent = $("#discountPercent").val();
			var discountPrice = $("#discountPrice").val();
			var detail = $("#detail").val();
			
			var startDate = $("#startedDate").val();
			var endDate = $("#endDate").val();
			var startDateValue = startDate.split('-');
			var endDateValue = endDate.split('-');
			
			var startDateCompare = new Date(startDateValue[0], parseInt(startDateValue[1])-1, startDateValue[2]);
	        var endDateCompare = new Date(endDateValue[0], parseInt(endDateValue[1])-1, endDateValue[2]);
	        console.log(name + "" + customerTypeId + "" + discountPercent + "" + detail);
	        
	        // 할인종류가 P일 때 입력창에 입력값을 입력하지 않으면 알럿을 띄움
	        if(discountType == "P") {
	        	if(!(name && customerTypeId && discountPercent && detail)) {
		        	alert("값을 입력하지 않았습니다. 값을 입력해 주세요.")
		        	e.preventDefault();
		        	return;
		        }	
	        }
	        
	        // 할인율의 숫자를 3자리이상 넣었을 때 알럿을 띄움
	        var stringSize = $("#discountPercent").val();
	        if(stringSize.length >= 3) {
	        	alert("할인율은 3자릿수가 될 수 없습니다.")
	        	e.preventDefault();
	        	return;
	        }
	        
	        // 시작일이 종료일보다 크면 알럿창 띄움
	        if(startDateCompare.getTime() > endDateCompare.getTime()) {
	             
	            alert("시작날짜가 종료날짜보다 큽니다. 확인해 주세요.");
	            e.preventDefault();
	             
	            return;
	        }
		})
		
		// 삭제버튼 클릭시 하위체크박스가 선택되지 않으면 알럿창 띄움
		$("#btnDelete").click(function(e) {
			if(!($("input[name=checkId]:checked").val())) {
				alert("체크박스를 선택하지 않았습니다. 체크박스를 선택해 주세요.");
				e.preventDefault();
				return;
			}else {
				$("#btnDelete").submit();
			}
		})
	})
</script>
</html>