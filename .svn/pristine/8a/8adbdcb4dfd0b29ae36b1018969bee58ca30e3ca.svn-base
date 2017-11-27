<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/js/pos/home.js"></script>
   	<link rel="stylesheet" href="/resources/css/pos/common.css"/>
    <link rel="stylesheet" href="/resources/css/pos/home.css"/>
</head>
<body>
    <%@ include file="/WEB-INF/views/pos/common/nav.jsp" %>
    
    <div class="container">
    <c:set var="nowPage" value="mainPage"/>
 	<%@ include file="/WEB-INF/views/pos/common/nav-tab.jsp" %>
        
        <div id="main-box">
            <div class="col-sm-4">
                <div class="border-box outer-box">
                    <form class="form-inline">
                        <input type="date" name="playingdate" id="playing-date" class="form-control" style="width: 400px;"/>
                        <button type="button" id="playing-date-btn" class="btn btn-boots pull-right">조회</button>
                    </form>
                </div>
                
                <div id="movie-list-box" class="border-box">
                    <table class="table table-condensed">
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
            
            <div class="col-sm-4">
                <div id="time-table-box" class="border-box">
                    <table id="time-table" class="table table-condensed">
                    	<thead>
                     		<tr>
                     			<th>시작시간</th><th>상영관</th><th>잔여석</th>
                     		</tr>
                     	</thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                
                <div class="border-box">
					<div id="price-key-box">
						
					</div>
                </div>
            </div>
            
            <div class="col-sm-4">
                <div id="price-box" class="border-box">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>구분</th><th>수량</th><th>요금</th><th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
                </div>
                
                <div class="border-box">
                    <div id="final-check-box">
                        <form method="post" action="seat.esc" class="col-sm-4">
                        	<input type="hidden" name="movieId" id="hidden-movieId"/>
                        	<input type="hidden" name="timetableId" id="hidden-timetableId"/>
                        	<input type="hidden" name="priceKeyId" id="hidden-priceKeyId"/>
                        	<input type="hidden" name="amount" id="hidden-amount"/>
                            <button type="submit" id="seat-select-btn" class="btn btn-boots btn-lg">좌석 선택</button>
                        </form>
                        
                        <div class="col-sm-6 col-sm-offset-2">
                            <div id="total-price-box" class=" border-box">
                                <label>총 가격</label>
                                <span class="pull-right"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>