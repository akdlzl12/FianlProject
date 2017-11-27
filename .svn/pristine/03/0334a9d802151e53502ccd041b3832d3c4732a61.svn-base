<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>상영관 좌석 관리</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
<style>
    .screen {
        margin-top: 100px;
        margin-bottom: 30px;
        margin-left: 30px;
        width: 600px;
        height: 40px;
        border: 1px solid black;
        background-color: black;
        color: white;
        text-align: center;
        padding: 5px;
        font-size: 1.5em;
    }
    .seat {
        width: 50px;
        height: 50px;
        border: 1px solid black;
        background-color: darkgray;
        float: left;
        margin-right: 20px;
        margin-bottom: 25px;
    }
</style>
</head>
<body>
	<c:set var="nav_active" value="movie" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2">
			<c:set var="side_active" value="m2one" />
			<%@ include file="/WEB-INF/views/movie/common/side_movie.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
			<h2 class="page-header">상영관 좌석관리</h2>
    <div class="row">
        <div class="col-sm-8 box">
            <div class="screen">S C R E E N</div>
            <div class="seatgroup">
                <div class="seat btn">A1</div>
                <div class="seat btn">A2</div>
                <div class="seat btn">A3</div>
                <div class="seat btn">A4</div>
                <div class="seat btn">A5</div>
                <div class="seat btn">A6</div>
                <div class="seat btn">A7</div>
                <div class="seat btn">A8</div>
                <div class="seat btn">A9</div>
                <div class="seat btn">A10</div>
            </div>
            <div class="seatgroup">
                <div class="seat btn">B1</div>
                <div class="seat btn">B2</div>
                <div class="seat btn">B3</div>
                <div class="seat btn">B4</div>
                <div class="seat btn">B5</div>
                <div class="seat btn">B6</div>
                <div class="seat btn">B7</div>
                <div class="seat btn">B8</div>
                <div class="seat btn">B9</div>
                <div class="seat btn">B10</div>
            </div>
            <div class="seatgroup">
                <div class="seat btn">B1</div>
                <div class="seat btn">B2</div>
                <div class="seat btn">B3</div>
                <div class="seat btn">B4</div>
                <div class="seat btn">B5</div>
                <div class="seat btn">B6</div>
                <div class="seat btn">B7</div>
                <div class="seat btn">B8</div>
                <div class="seat btn">B9</div>
                <div class="seat btn">B10</div>
            </div>
            <div class="seatgroup">
                <div class="seat btn">B1</div>
                <div class="seat btn">B2</div>
                <div class="seat btn">B3</div>
                <div class="seat btn">B4</div>
                <div class="seat btn">B5</div>
                <div class="seat btn">B6</div>
                <div class="seat btn">B7</div>
                <div class="seat btn">B8</div>
                <div class="seat btn">B9</div>
                <div class="seat btn">B10</div>
            </div>
            <div class="seatgroup">
                <div class="seat btn">B1</div>
                <div class="seat btn">B2</div>
                <div class="seat btn">B3</div>
                <div class="seat btn">B4</div>
                <div class="seat btn">B5</div>
                <div class="seat btn">B6</div>
                <div class="seat btn">B7</div>
                <div class="seat btn">B8</div>
                <div class="seat btn">B9</div>
                <div class="seat btn">B10</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div style="width: 270px; border: 1px solid #D8D8D8;">
               <label style="margin: 10px; width: 60px;">일자선택 </label>
               <input style="width: 150px;" type="date" />
            </div>
            <div style="width: 270px; border: 1px solid #D8D8D8; margin-top: 10px;">
               <label style="margin: 10px; width: 60px; text-align: center;">회차</label>
               <select name="playcnt"  style="width: 150px;">
                       <option>1회차</option>
                       <option>2회차</option>
                       <option>3회차</option>
                       <option>4회차</option>
                </select>
            </div>
            <div style="width: 270px; border: 1px solid #D8D8D8; margin-top: 10px;">
               <label style="margin: 10px; width: 60px; text-align: center;">상영관</label>
               <select name="playhole" style="width: 150px;">
                       <option>1관</option>
                       <option>2관</option>
                       <option>3관</option>
                       <option>4관</option>
                </select>
            </div>
            <div id="seat-info" class="seatinfo" style="width: 270px; border: 1px solid #D8D8D8; margin-top: 30px;">
                 <label style="margin: 10px; width: 60px; text-align: center;">좌석정보</label>
                 <ul>
                     <li>선택좌석
                         <input type="text" />
                     </li>
                     <li>티켓번호
                         <input type="text" />
                     </li>
                     <hr/>
                     <li>구매ID<br/>
                         <input type="text" />
                     </li>
                     <li>구매자명
                         <input type="text" />
                     </li>
                     <li>결제수단
                         <input type="text" value="카드" />
                     </li>
                     <li>결제방법
                         <input type="text" value="온라인" />
                     </li>
                 </ul>
            </div>
            <div style="width: 270px; margin-top: 10px; text-align: center">
                <button id="btn-open-modal" class="btn btn-primary" style="width: 270px; border: 1px solid #D8D8D8">
                <i class="fa fa-user-plus fa-fw fa-fw"></i>좌 석 확 보</button>
            </div>
        </div>
    </div>


    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">좌 석 확 보</h4>
                    <hr/>
                    <div class="row">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-2">선택좌석</label>
                                <div class="col-sm-8">
                                    <input type="text" value="B4" class="form-control" readonly />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">확보시간</label>
                                <div class="col-sm-8">
                                    <select class="form-control">
                                        <option value="">상영 10분전</option>
                                        <option value="">상영 30분전</option>
                                        <option value="">상영 60분전</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">확보사유</label>
                                <div class="col-sm-8">
                                   <textarea class="form-control" rows="5"></textarea> 
                                </div>  
                            </div>
                        </form>
                    </div>
                    
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal" >
                    <i class="fa fa-user-plus fa-fw fa-fw"></i>저장</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" >취소</button>
                </div>
            </div>
        </div>
    </div>
</div>
		</div>	
	</div>
</body>
<script>
$(function(){
    $('#btn-open-modal').click(function(){
        $('#myModal').modal('show');
        return false;
    })
})
</script>
</html>