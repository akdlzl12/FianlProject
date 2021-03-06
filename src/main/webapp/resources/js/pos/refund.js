    $(function() {
    	// 판매번호 자동 '-' 추가 function
    	var autoMinus = function(str) {
    		str = str.replace(/[^0-9]/g, '');
    		var tmp = '';
    		
    		if(str.length < 4){
    			return str;
    		} else if(str.length < 8){
    			tmp += str.substr(0, 4);
    			tmp += '-';
    			tmp += str.substr(4);
    			return tmp;
    		} else if(str.length < 12){
    			tmp += str.substr(0, 4);
    			tmp += '-';
    			tmp += str.substr(4, 4);
    			tmp += '-';
    			tmp += str.substr(8);
    			return tmp;
    		} else if(str.length <= 16) {        
    			tmp += str.substr(0, 4);
    			tmp += '-';
    			tmp += str.substr(4, 4);
    			tmp += '-';
    			tmp += str.substr(8, 4);
    			tmp += '-';
    			tmp += str.substr(12, 4);
    			return tmp;
    		} else {
    			tmp += str.substr(0, 4);
    			tmp += '-';
    			tmp += str.substr(4, 4);
    			tmp += '-';
    			tmp += str.substr(8, 4);
    			tmp += '-';
    			tmp += str.substr(12, 4);
    			return tmp;
    		}
    		return str;
    	}
    	
    	// 판매번호 자동 '-' 추가 Event
    	$("#receipt-no-input").on("keyup", function() {
    		var autoNo = autoMinus($(this).val());
    		$(this).val(autoNo);
    	});
    	
    	// 조회 btn Event
    	$("#search-btn").on("click", function(e) {
    		e.preventDefault();
    		
    		var receiptNo = $("#receipt-no-input").val();
    		
    		if(receiptNo) {
    			$.ajax({
    				type:"POST",
    				url:"checkreceipt.esc",
    				data:{rid:receiptNo},
    				dataType:"json",
    				success:function(result) {
    					if(result.success) {
    						$("#search-ticket-form").submit();
    					} else {
    						$("#payment-table-box table tbody").empty();
    						$("#payment-type-box table tbody").empty();
    						$("#purchase-movie-box table tbody").empty();
    						$("#purchase-type-box table tbody").empty();
    						$("#total-price-box").empty();
    						alert(result.message);
    					}
    				},
    				error:function() {
    					alert("알수없는 서버 에러입니다.");
    				}
    			});
    		} else {
    			alert("영수증 번호를 입력하세요.");
    		}
    	});
    	
    	// 재출력 btn Event
    	$("#reprinted-btn").on("click", function() {
    		var receiptNo = $("#receipt-no-input").val();
    		
    		if(receiptNo) {
    			$.ajax({
    				type:"POST",
    				url:"reprint.esc",
    				data:{rid:receiptNo},
    				dataType:"json",
    				success:function(result) {
    					if(result.success) {
    						alert("출력이 완료되었습니다.");
    					} else {
    						alert(result.message);
    					}
    				},
    				error:function() {
    					alert("알수없는 서버 에러입니다.");
    				}
    			});
    		} else {
    			alert("영수증 번호를 입력하세요.");
    		}
    	});
    	
    	// 환불 btn Event
    	$("#refund-btn").on("click", function(e) {
    		e.preventDefault();
    		
    		if($("#hidden-receipt-no").val() == "") {
    			alert("조회를 먼저 진행해 주세요.");
    			return false;
    		}
    		$("#check-refund-modal").modal("show");
    	});
    	
    	// modal 확인 btn Event
    	$("#confirm-btn").on("click", function() {
    		$("#refund-form").submit();
    	});
    });