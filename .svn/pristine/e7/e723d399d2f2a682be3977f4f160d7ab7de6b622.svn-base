$(function() {
	var $seatBox = $("#seat-box");
	var screenId = $("#movie-info-box tr.screen-tr").attr("id").replace("screen-tr-", "");
	var timetableId = $("#hidden-timetableId").val();
	
	// 선택된 좌석 가져오는 function
    var getSelectedSeat = function() {
        $("#selected-seat-td").empty();
        
        var selectedSeat = "";
        $("div.selected-seat label").each(function() {
            selectedSeat += $(this).text() + " ";
        });
        
        return selectedSeat;
    };
    
    // 첫 시작시 seat 정보 AJAX 요청
    $.ajax({
    	type:"GET",
    	url:"seat.esc",
    	data:{screenId:screenId,timetableId:timetableId},
    	dataType:"json",
    	success:function(result) {
    		$(result).each(function() {
    			var htmlContents = "";
    			
    			htmlContents += "<div class='seat seat-" + this.status + " col-sm-1'>";
    			htmlContents += "	<label id='seat-no-" + this.id +"''>" + this.name + "</label>"
    			htmlContents += "</div>";
    			
    			$seatBox.append(htmlContents);
    		});
    	}
    });
    // seat click 위임 event
    $seatBox.on("click","div.seat-Y", function() {
        $(this).toggleClass("selected-seat");
        
        var selectedSeat = getSelectedSeat();
        if(parseInt($("#able-select-seat").text()) < selectedSeat.split(" ").length - 1) {
            $(this).removeClass("selected-seat");
            selectedSeat = getSelectedSeat();
            alert("선택 가능한 좌석을 초과하였습니다.");
        }
        
        $("#selected-seat-td").empty().text(selectedSeat);
    });
    
    // 결제 btn Event
    $("#payment-btn").on("click", function(e) {
    	e.preventDefault();
    	var seatId = "";
    	$("div.selected-seat label").each(function() {
        	seatId += $(this).attr("id").replace("seat-no-", "") + ",";
    	});
    	
    	var ableSelectSeat = parseInt($("#able-select-seat").text());
    	if(seatId == "") {
    		alert("좌석을 선택해 주세요.");
    	} else if(ableSelectSeat != getSelectedSeat().split(" ").length - 1) {
    		alert("총 " + ableSelectSeat + "자리를 선택해야 합니다.");
    	} else {
        	$("#hidden-seatId").val(seatId);
        	$(this).closest("form").submit();
    	}
    });
});