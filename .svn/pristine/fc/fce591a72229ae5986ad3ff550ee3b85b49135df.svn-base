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
    <script>
        $(function() {
          
			$("#real-price").text(parseInt($("#total-price").text()) + parseInt($("#discount-price").text()));
			
            $("input[name='payment']").on("click", function() {
                var payment = $(this).val();
                
                var htmlContents = "";
                if(payment == "card") {
                    htmlContents += "<label class='payment-info-label'>카드번호</label>";
                    htmlContents += "<input type='text' name='card-no' id='card-no' class='form-control'/>";        
                } else if(payment == "cash") {
                    htmlContents += "<label class='payment-info-label'>받은 금액</label>";
                    htmlContents += "<input type='text' name='taken-price' id='taken-price' class='form-control'/>";
                    htmlContents += "<label class='payment-info-label'>거스름돈</label>";
                    htmlContents += "<div id='change-price' class='payment-info col-sm-9 text-right pull-right'></div>";
                }
                $("#needed-payment-box").empty().append(htmlContents);
            });
            $("input[value='card']").trigger("click");
            
            $("#needed-payment-box").on("keyup", "input[name='taken-price']", function() {
                var realPrice = parseInt($("#real-price").text());
                var takenPrice = parseInt($(this).val());
                
                $("#change-price").empty().text(takenPrice - realPrice);
            });

        });
    </script>
    <%@ include file="/WEB-INF/views/pos/common/style.jsp" %>
    <style>
        #main-box {
            border: 10px solid #6a5dc0;
            width: 1770px;
			height: 754px;
        }
        #price-box {
            margin: 20px;
			height: 350px;
			font-size: 17px;
        }
        #select-info-box {
            margin: 20px;
            height: 300px;
            font-size: 17px;
        }
        #payment-info-box {
            margin: 20px;
            height: 400px;
        }
        #discount-select-box {
            margin: 20px;
            height: 251px;
        }
        #payment-radio-box {
            margin: 15px;
            margin-left: 200px;
            font-size: 23px;
        }
        #payment-radio-box input[type='radio'] {
            margin: 10px;
            margin-left: 150px;
            width: 20px;
            height: 20px;
        }
        .payment-border {
            margin: 30px;
        }
        label.payment-info-label {
            margin-top: 25px;
        }
        div.payment-info {
            margin-top: 10px;
            padding-left: 50px;
            border: 3px solid #6a5dc0;
            width: 330px;
            height: 50px;
            font-size: 32px;
        }
        input#card-no {
            margin-top: 20px;
            border: 3px solid #6a5dc0;
            height: 40px;
        }
        #needed-payment-box {
            height: 200px;
        }
        button.discount-btn {
            width: 150px;
        }
        #discount-btn-box {
            margin-left: 20px;
            height: 200px;
        }
        #coupon-box {
            margin-top: 20px;
            height: 400px;
        }
        #point-box {
            margin-top: 10px;
            border-top: 1px solid silver;
        }
		#discount-kind-box .btn {
			margin: 5px;
		}
    </style>
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
                                <thead>
                                    <tr>
                                        <th>구분</th><th>수량</th><th>요금</th><th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        
                        <div id="select-info-box" class="border-box">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <th>영화명</th><td colspan="3">토르 : 라그나로크</td>
                                    </tr>
                                    <tr>
                                        <th>시간</th><td>2017-11-04 13:45</td>
                                        <th>상영관</th><td>2관</td>
                                    </tr>
                                    <tr>
                                        <th>선택좌석</th><td id="selected-seat-td" colspan="3">A1 A2</td>
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
                                <input type="radio" name="payment" value="card" id="payment-card"/>
                                <label for="payment-card">카드</label>
                                
                                <input type="radio" name="payment" value="cash" id="payment-cash"/>
                                <label for="payment-cash">현금</label>
                            </div>
                            
                            <div class="row">
                                <div class="payment-border col-sm-5">
                                    <label class="payment-info-label col-sm-3">총 가격</label>
                                    <div id="total-price" class="payment-info col-sm-9 text-right">5000</div>
                                    
                                    <label class="payment-info-label col-sm-3">할인 가격</label>
                                    <div id="discount-price" class="payment-info col-sm-9 text-right">-1000</div>
                                    
                                    <label class="payment-info-label col-sm-3">결제 금액</label>
                                    <div id="real-price" class="payment-info col-sm-9 text-right"></div>
                                </div>
                                
                                <div class="payment-border col-sm-5">
                                    <form>
                                        <div id="needed-payment-box">
                                            
                                        </div>
                                                       
                                        <div id="final-select-btn" class="pull-right">
                                            <button type="submit" class="btn btn-boots btn-lg">결제</button>
                                            <a href="seat.html" class="btn btn-boots btn-lg">취소</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        
                        <div id="discount-select-box" class="border-box">
                            <div class="row">
                                <div id="discount-btn-box" class="col-sm-9 border-box">
									<button type="button" class="btn btn-default btn-sm">대학생 할인</button>
									<button type="button" class="btn btn-default btn-sm">10000원의 행복</button>
									<button type="button" class="btn btn-default btn-sm">천고마비 할인</button>
                                </div>
                                
                                <div id="discount-kind-box" class="col-sm-2 pull-right">
                                    <button type="button" id="membership-btn" class="discount-btn btn btn-boots btn-lg" data-toggle="modal" data-target="#membership-modal">멤버쉽</button>
                                    <button type="button" class="discount-btn btn btn-boots btn-lg">일반 할인</button>
                                    <button type="button" class="discount-btn btn btn-boots btn-lg">직원 할인</button>
                                    <button type="button" class="discount-btn btn btn-boots btn-lg">포인트 할인</button>
                                </div>
                            </div>
                        </div>
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
                                    <input type="text" name="customer-name" id="customer-name" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3">전화번호</label>
                                <div class="col-sm-8">
                                    <input type="tel" name="customer-phone" id="customer-phone" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2 pull-right">
                                    <button type="submit" class="btn btn-boots btn-xs">조회</button>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div id="point-box">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-3">잔여 포인트</label>
                                <div class="col-sm-8 text-right">
                                    <h4>500</h4>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3">사용할 포인트</label>
                                <div class="col-sm-8">
                                    <input type="number" name="using-point" id="using-point" class="form-control"/>
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
                                <tr>
                                    <td><input type="checkbox" name="coupon"/></td>
                                    <td>대학생 할인</td>
                                    <td>2017-12-01</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="modal-footer">
                	<button type="submit" class="btn btn-boots btn-sm" data-dismiss="modal">확인</button>
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>