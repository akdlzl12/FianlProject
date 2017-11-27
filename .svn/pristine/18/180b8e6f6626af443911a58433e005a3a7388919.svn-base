<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>상영관 좌석 관리</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
<style>
	div.selected-Nseat {
		border: 2px solid #000000;
	}
	
	div.selected-seat {
		background-color: #0047b3;
		border: 2px solid #000000;
	}
	div.seat-R {
        background-color: red; 	
	}
	div.seat-N {
		background-color: #00ff00;
	}
	
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
    .sideInput{
    	text-align: center;
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
        <div class="col-sm-8 box" id="seats-box">
            <div class="screen">S C R E E N</div>
           			<c:forEach var="i" begin="1" end="5" step="1" >
           				<div class="seatgroup">
           					<c:forEach var="z" begin="1" end="10" step="1">
           						<c:choose>
           							<c:when test="${i eq 1}">
           								<div class="seat btn" value="A${z}" id="">A${z}</div>
           							</c:when>
           							<c:when test="${i eq 2}">
           								<div class="seat btn" value="B${z}" id="">B${z}</div>
           							</c:when>
           							<c:when test="${i eq 3}">
           								<div class="seat btn" value="C${z}" id="">C${z}</div>
           							</c:when>
           							<c:when test="${i eq 4}">
           								<div class="seat btn" value="D${z}" id="">D${z}</div>
           							</c:when>
           							<c:when test="${i eq 5}">
           								<div class="seat btn" value="E${z}" id="">E${z}</div>
           							</c:when>
           						</c:choose>
			            		
			            	</c:forEach>
           				</div>
           			</c:forEach>
            	
        </div>
        <div class="col-sm-4">
            <div style="width: 270px; border: 1px solid #D8D8D8;">
               <label style="margin: 10px; width: 60px;">일자선택 </label>
               <input style="width: 150px;" type="date" id="select-date"/>
            </div>
            <div style="width: 270px; border: 1px solid #D8D8D8; margin-top: 10px;">
               <label style="margin: 10px; width: 60px; text-align: center;">상영관</label>
               <select name="playhole" id="ordered-list" style="width: 150px;">
                       
                </select>
            </div>
            <div style="width: 270px; border: 1px solid #D8D8D8; margin-top: 10px;">
               <label style="margin: 10px; width: 60px; text-align: center;">영화선택</label>
               <select name="playtime" id="timetable-list" style="width: 150px;">
                      
                </select>
            </div>
            <div id="seat-info" class="seatinfo" style="width: 270px; border: 1px solid #D8D8D8; margin-top: 30px;">
                 <label style="margin: 10px; width: 60px; text-align: center;">좌석정보</label>
                 <ul>
                     <li>선택좌석
                         <input type="text" class="sideInput" id="input-seat" value="-"/>
                     </li>
                     <li>티켓번호
                         <input type="text" class="sideInput" id="input-ticket" value="-"/>
                     </li>
                     <hr/>
                     <li>구매ID<br/>
                         <input type="text" class="sideInput" id="input-id" value="-"/>
                     </li>
                     <li>구매자명
                         <input type="text" class="sideInput" id="input-name" value="-"/>
                     </li>
                     <li>결제수단
                         <input type="text" class="sideInput" id="input-ptype" value="-" />
                     </li>
                     <li>결제방법
                         <input type="text" class="sideInput" id="input-onoff" value="-" />
                     </li>
                 </ul>
            </div>
            <div style="width: 270px; margin-top: 10px; text-align: center">
                <button id="btn-open-modal" class="btn btn-primary modal-btn" style="width: 120; border: 1px solid #D8D8D8">
                <i class="fa fa-user-plus fa-fw fa-fw"></i>좌 석 확 보</button>
                <button id="btn-open-fixmodal" class="btn btn-primary modal-btn" style="width: 120; border: 1px solid #D8D8D8">
                <i class="fa fa-user-plus fa-fw fa-fw"></i>좌 석 수 정</button>
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
                                    <input type="text" id="modal-select-seat" value="" class="form-control" readonly />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">확보사유</label>
                                <div class="col-sm-8">
                                   <textarea class="form-control" rows="5" id="modal-input-text"></textarea> 
                                </div>  
                            </div>
                        </form>
                    </div>
                    
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="modal-save-btn" >
                    	<i class="fa fa-user-plus fa-fw fa-fw"></i>저장
                    </button>
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
	$('#btn-open-modal' ).prop( "disabled", true );
	$('#btn-open-fixmodal').prop( "disabled", true );
	
    $('#select-date').on('change', function() {
    	$('div.seat').removeClass('seat-Y');
		$('div.seat').removeClass('seat-N');
		$('div.seat').removeClass('seat-R');
		$('div.seat').removeClass('selected-seat');
		$('div.seat').removeClass('selected-Nseat');
    	
    	
    	
    	var selectDate = $(this).val()
    	
		$.ajax({
			type:"GET",
			url : "getInfoBydates.esc",
			data:{playDate : selectDate },
			dataType:"json",
			success: function(result) {
				var html = "";
					html+= "<option>선택</option>"
				$.each(result, function(index, item) {
					html+= "<option value="+item.screenName+">"+item.screenName+"</option>"
				})
				$("#ordered-list").html(html);
			}
		})
	})
	
	$('#ordered-list').on('change', function() {
		$('div.seat').removeClass('seat-Y');
		$('div.seat').removeClass('seat-N');
		$('div.seat').removeClass('seat-R');
		$('div.seat').removeClass('selected-seat');
		$('div.seat').removeClass('selected-Nseat');
		
		
		var selectDate = $('#select-date').val()
		var selectScreen = $('#ordered-list option:selected').val()
		
		$.ajax({
			type:"GET",
			url :"getInfoByScreens.esc",
			data: {playDate : selectDate},
			dataType: "json",
			success: function(result) {
				
				var html = "";
				html += "<option>선택</option>"
				$.each(result, function(index, item) {
					if(selectScreen == item.screenName) {
						html += "<option value='"+item.id+"'>"+item.title+"/"+item.ordered+"회차 /"+item.startedAt+"</option>"
					}
				})
				$('#timetable-list').html(html);
				
			}
		})	
	})
	//예약석 뽑아오기
	$('#timetable-list').on('change', function(){
		
		//여기서 좌석 초기화 
		$('div.seat').removeClass('seat-Y');
		$('div.seat').removeClass('seat-N');
		$('div.seat').removeClass('seat-R');
		$('div.seat').removeClass('selected-seat');
		$('div.seat').removeClass('selected-Nseat');
		
		var selectScreen = $('#ordered-list option:selected').val();
		var timetableId = $('#timetable-list option:selected').val();
		console.log(timetableId)
		var oneSeat = $('.seatgroup .btn');
		
		$.ajax({
			type:"GET",
			url :"getReservedSeat.esc",
			data: {selectScreen:selectScreen, timetableId: timetableId },
			dataType: "json",
			success: function(result) {
				console.log(result)
				$.each(oneSeat, function(index,seat) {
					var seatName = seat.innerText;
					$.each(result, function(index, item) {
						if(seatName == item.name){
 						$('div[value='+seatName+']').attr('id', ''+item.id+'')							
 						$('div[value='+seatName+']').addClass('seat-'+item.status+'')							
						}
						
					})
					
				})
				
				
			}
		})	
	})
	
	//좌석선택
	$('.seat').on('click',function() {
  		if($(this).hasClass('seat-Y')){
			$(this).toggleClass("selected-seat")
			$('div.seat-N').removeClass('selected-Nseat')
  		} else if ($(this).hasClass("seat-N")){
  			$(this).toggleClass("selected-Nseat")
  			$('div.seat-Y').removeClass('selected-seat')
  		}
  		
  		
  		$('#input-seat').val('-')
		$('#input-ticket').val('-')
		$('#input-id').val('-')
		$('#input-name').val('-')
		$('#input-ptype').val('-')
		$('#input-onoff').val('-')
  		
		var selectSeatId = $(this).attr('id')
		$('#input-seat').val($(this).text())
		
	/*  수정중 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		var selectedDate = $("#select-date").val()
	
		
		$.ajax({
			type:"GET",
			url : "getSeatInfoSeatId.esc",
			data:{seatId : selectSeatId, date :selectedDate},
			dataType: "json",
			success: function(result) {
				console.log(result)
// 				
				$.each(result, function(index, item) {
					console.log(item.startedAt)
					console.log(selectedDate)
					
					if(result != null) {
	 					$('#input-seat').val(item.seatname)
						$('#input-ticket').val(item.rid)
						$('#input-id').val(item.username)
						$('#input-name').val(item.name)
						if(item.purchaseType == 'C'){
							$('#input-ptype').val('카드')
						} else if (item.purchaseType == 'M'){
							$('#input-ptype').val('현금')
						} else if (item.purchaseType == 'O') {
							$('#input-ptype').val('온라인')
						}
						
						if(item.purchaseType == 'O'){
							$('#input-onoff').val('온라인 결제')
						} else {
							$('#input-onoff').val('현장 결제')
						}
					} 
				})
				
			}	
		})
		
		
  		if ($('.seat').hasClass("selected-Nseat")){
  			$('#btn-open-modal' ).prop( "disabled", true );
  			$('#btn-open-fixmodal').prop( "disabled", false );
  		} else if($('.seat').hasClass("selected-seat")){
  			$('#btn-open-modal' ).prop( "disabled", false );
  			$('#btn-open-fixmodal').prop( "disabled", true );
  		} else {
  			$('#btn-open-modal' ).prop( "disabled", true );
  			$('#btn-open-fixmodal').prop( "disabled", true );
  		}
  		
	})
	
	//좌석 확보
	 $('#btn-open-modal').click(function(){
	    $('#myModal').modal('show');
        
        //선택한 좌석이름 뽑기
		var selectedSeatNames = [];
        
		$('.selected-seat').each(function() {
			selectedSeatNames.push($(this).text());
		});		
		$('#modal-select-seat').val(selectedSeatNames.join(","));

		//모달 저장 (자리확보시키기)
	    $('#modal-save-btn').click(function() {
	    	var selectedSeatIds = [];
	    	var detail =$('#modal-input-text').val();
	    	$('.selected-seat').each(function() {
 	    		selectedSeatIds.push($(this).attr('id'));
			});
			var data = {selectedSeatIds:selectedSeatIds.join(","), detail:detail};
			$.ajax({
				type: "POST",
				url : "insertDissabled.esc",
				data: data,
				dataType: "json",
				success: function(result) {
					console.log(result)
					$.each(result, function(index, item) {	
						$('#'+item.id+'').removeClass("seat-Y")
						$('#'+item.id+'').removeClass("selected-seat")
						$('#'+item.id+'').addClass("seat-N")
					})
				}
			})
		})
    })
    
    //좌석수정
    $('#btn-open-fixmodal').click(function(){
    	
    	
	    $('#myModal').modal('show');
        
        //수정할 좌석이름 뽑기
        var selectedNSeatNames = [];

		$('.selected-Nseat').each(function() {
			console.log($('.selected-Nseat').text());
			console.log($(this))
			selectedNSeatNames.push($(this).text());
		});
// 		console.log(selectedNSeatNames);
		$('#modal-select-seat').val(selectedNSeatNames.join(","));
		
		
	
			//모달 저장 (자리확보수정)
		    $('#modal-save-btn').click(function() {
		    	var selectedSeatIds = [];
// 		    	var detail =$('#modal-input-text').val();
		    	$('.selected-Nseat').each(function() {
	 	    		selectedSeatIds.push($(this).attr('id'));
				});
				var data = {selectedSeatIds:selectedSeatIds.join(",")};
				$.ajax({
					type: "GET",
					url : "getDisabledDetail.esc",
					data: data,
					dataType: "json",
					success: function(result) {
						console.log(result)
						$.each(result, function(index, item) {	
							console.log($('#'+item.seat.id+''))
							$('#'+item.seat.id+'').removeClass("seat-N")
							$('#'+item.seat.id+'').removeClass("selected-Nseat")
							$('#'+item.seat.id+'').addClass("seat-Y")
						})
					}
				})
			})
    })
    
   
    
    
	
	
	
})
</script>
</html>