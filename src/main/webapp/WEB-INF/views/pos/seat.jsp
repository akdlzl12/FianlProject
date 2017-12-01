<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>POS :: Seat</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="/resources/js/pos/seat.js"></script>
    <link rel="stylesheet" href="/resources/css/pos/common.css">
    <link rel="stylesheet" href="/resources/css/pos/seat.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/pos/common/nav.jsp" %>
	
    <div class="container">
        <div id="main-box">
            <div class="row">
                <div id="theater-box" class="col-sm-8">
                    <div id="screen-box" class="row">
                        <div class="col-sm-2">
                            <h4>S</h4>
                        </div>
                        <div class="col-sm-2">
                            <h4>C</h4>
                        </div>
                        <div class="col-sm-2">
                            <h4>R</h4>
                        </div>
                        <div class="col-sm-2">
                            <h4>E</h4>
                        </div>
                        <div class="col-sm-2">
                            <h4>E</h4>
                        </div>
                        <div class="col-sm-2">
                            <h4>N</h4>
                        </div>
                    </div>

                    <div id="seat-box" class="row">
                    
                    </div>
                </div>

                <div id="info-box" class="col-sm-3 pull-right">
                    <div id="movie-info-box" class="row">
                        <table class="table table-condensed">
                            <tbody>
                                <tr>
                                    <th>영화제목</th><td class="text-right">${movieInfo.name }</td>
                                </tr>
                                <tr>
                                    <th>시간</th><td class="text-right"><fmt:formatDate value="${timetable.startedAt }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                </tr>
                                <tr id="screen-tr-${timetable.screenMovie.screen.id }" class="screen-tr">
                                    <th>상영관</th><td class="text-right">${timetable.screenMovie.screen.name }</td>
                                </tr>
                                <tr>
                                    <th>잔여석</th><td class="text-right">${timetable.screenMovie.screen.seatsCount }석</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="selected-info-box" class="row">
                        <table class="table table-condensed">
                            <tbody>
                                <tr>
                                    <th>선택할 좌석 수</th><td class="text-right"><span id="able-select-seat">${totalAmount }</span> 석</td>
                                </tr>
                                <tr>
                                    <th colspan="2">선택한 좌석</th>
                                </tr>
                                <tr>
                                    <td id="selected-seat-td" class="text-right" colspan="2"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="move-btn-box">
                        <form method="post" action="payment.esc">
                        	<input type="hidden" name="movieId" id="hidden-movieId" value="${movieInfo.movie.id }"/>
                        	<input type="hidden" name="timetableId" id="hidden-timetableId" value="${timetable.id }"/>
                        	<input type="hidden" name="priceKeyId" id="hidden-priceKeyId" value="${keyIdList }"/>
                        	<input type="hidden" name="amount" id="hidden-amount" value="${amountList }"/>
                        	<input type="hidden" name="seatId" id="hidden-seatId"/>
                            <button type="submit" id="payment-btn" class="btn btn-boots btn-lg">결제</button>
                            <a href="home.esc" class="btn btn-boots btn-lg pull-right">취소</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>