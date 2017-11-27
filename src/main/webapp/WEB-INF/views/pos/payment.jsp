<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="/resources/js/pos/payment.js"></script>
    <link rel="stylesheet" href="/resources/css/pos/common.css">
    <link rel="stylesheet" href="/resources/css/pos/payment.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/pos/common/nav.jsp" %>
    
    <div class="container">
        <div id="main-box">
            <div class="row">
                <div class="col-sm-4">
                    <div class="row">
                        <div id="price-box" class="border-box">
                            <table class="table table-hover">
                            	<colgroup>
                            		<col width="50%"/>
                            		<col width="20%"/>
                            		<col width="20%"/>
                            		<col width="10%"/>
                            	</colgroup>
                                <thead>
                                    <tr>
                                        <th>구분</th><th>수량</th><th>요금</th><th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="forKey" items="${typeList }">
                                		<tr id="key-tr-${forKey.key.id }" class="key-tr">
                                			<td class="key-type-td">${forKey.key.type }</td>
                                			<td class="amount-td">
                                				<span>${forKey.amount }</span>
                                				<label class="sr-only">${forKey.amount }</label>
                                			</td>
                                			<td colspan="2" class="amount-price-td">${forKey.key.price * forKey.amount }</td>
                                		</tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                        
                        <div id="select-info-box" class="border-box">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <th>영화명</th><td colspan="3">${movieInfo.name }</td>
                                    </tr>
                                    <tr>
                                        <th>시간</th><td><fmt:formatDate value="${timetable.startedAt }" pattern="yyyy-MM-dd HH:mm"/></td>
                                        <th>상영관</th><td>${timetable.screenMovie.screen.name }</td>
                                    </tr>
                                    <tr>
                                        <th>선택좌석</th>
                                        <td id="selected-seat-td" colspan="3">
                                        	<c:forEach var="forSeat" items="${seats }">
                                        		<span>${forSeat.name } </span>
                                        	</c:forEach>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-8">
                    <div class="row">
                        <div id="payment-info-box" class="border-box">
                            <div id="payment-radio-box" class="row">
                                <input type="radio" name="payment" value="C" id="payment-card"/>
                                <label for="payment-card">카드</label>
                                
                                <input type="radio" name="payment" value="M" id="payment-cash"/>
                                <label for="payment-cash">현금</label>
                            </div>
                            
                            <div class="row">
                                <div class="payment-border col-sm-5">
                                    <label class="payment-info-label col-sm-3">총 가격</label>
                                    <div id="total-price" class="payment-info col-sm-9 text-right"></div>
                                    
                                    <label class="payment-info-label col-sm-3">할인 가격</label>
                                    <div id="discount-price" class="payment-info col-sm-9 text-right">0</div>
                                    
                                    <label class="payment-info-label col-sm-3">결제 금액</label>
                                    <div id="real-price" class="payment-info col-sm-9 text-right"></div>
                                </div>
                                
                                <div class="payment-border col-sm-5">
                                    <form method="post" action="confirm.esc" id="payment-form">
                                    	<input type="hidden" name="paymentPrice"/>
                                    	<input type="hidden" name="discountPrice"/>
                                    	<input type="hidden" name="purchaseType"/>
                                    	<input type="hidden" name="movieTimetable" value="${timetable.id }"/>
                                    	<input type="hidden" name="customerType" value="${type }"/>
                                    	<input type="hidden" name="seat" value="${seatId }"/>
                                    	<input type="hidden" name="customerId" value="0"/>
                                    	<input type="hidden" name="usedCoupon"/>
                                    	<input type="hidden" name="usedPoint"/>
                                    	<input type="hidden" name="usedDiscount"/>
                                        <div id="needed-payment-box">
                                            
                                        </div>
                                                       
                                        <div id="final-select-btn" class="pull-right">
                                            <button type="button" id="payment-btn" class="btn btn-boots btn-lg" data-toggle="modal" data-target="#check-payment-modal">결제</button>
                                            <a href="home.esc" class="btn btn-boots btn-lg">취소</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        
                        <div id="discount-select-box" class="border-box">
                            <div class="row">
                                <div id="discount-btn-box" class="col-sm-9 border-box">
                                
                                </div>
                                
                                <div id="discount-kind-box" class="col-sm-2 pull-right">
                                    <button type="button" id="membership-btn" class="discount-btn btn btn-boots btn-lg" data-toggle="modal" data-target="#membership-modal">멤버쉽</button>
                                    <button type="button" id="general-discount-btn" class="discount-btn btn btn-boots btn-lg">일반 할인</button>
                                    <button type="button" id="employee-discount-btn" class="discount-btn btn btn-boots btn-lg">직원 할인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div id="check-payment-modal" class="modal bs-example-modal-lg">
    	<div class="modal-dialog modal-lg">
    		<div class="modal-content">
		    	<div class="modal-body">
		    		<h3>결제를 완료합니다. 진행하시겠습니까?</h3>
		    	</div>
		    	
		    	<div class="modal-footer">
		    		<div class="pull-right">
		    			<button id="confirm-btn" type="button" class="btn btn-boots btn-lg">확인</button>
		    			<button type="button" class="btn btn-defalut btn-lg" data-dismiss="modal">취소</button>
		    		</div>
		    	</div>
    		</div>
    	</div>
    </div>
    
    <div id="membership-modal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4>멤버쉽</h4>
                </div>
                

                <div class="modal-body">
                    <div id="search-member-box">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-3">이름</label>
                                <div class="col-sm-8">
                                    <input type="text" name="customerName" id="customer-name" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3">전화번호</label>
                                <div class="col-sm-8">
                                    <input type="tel" name="customerPhone" id="customer-phone" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2 pull-right">
                                    <button type="button" id="customer-search-btn" class="btn btn-boots btn-xs">조회</button>
                                </div>
                            </div>
                        </form>
                        
                        <div class="row">
                        	<div class="col-sm-1 col-sm-offset-1">
	                        	<label>ID</label>
                        	</div>
                        	<div class="col-sm-5">
	                        	<span id="user-id-span"></span>
                        	</div>
                        	<div class="col-sm-2">
	                        	<label>등급</label>
                        	</div>
                        	<div class="col-sm-3">
	                        	<span id="user-rank-span"></span>
                        	</div>
                        </div>
                    </div>

                    <div id="point-box">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-3">잔여 포인트</label>
                                <div id="remain-point-box" class="col-sm-8 text-right">
                                    <h4></h4>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3">사용할 포인트</label>
                                <div class="col-sm-8">
                                    <input type="number" name="using-point" id="using-point" class="form-control"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                            	<div class="col-sm-2 pull-right">
	                            	<button type="button" id="modal-confirm-btn" class="btn btn-boots btn-xs">사용</button>
                            	</div>
                            </div>
                        </form>
                    </div>

                    <div id="coupon-box" class="border-box">
                        <table id="coupon-table" class="table table-bordered table-condensed table-hover text-center">
                            <thead>
                                <tr>
                                    <th></th><th class="text-center">쿠폰명</th><th class="text-center">사용가능기간</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>