$(function() {
	// 첫 시작시 Key의 인당 가격이 높은 순으로 배열
	$("#price-box tbody tr.key-tr").sort(function(a, b) {
   		var aPersonalPrice = 
   			parseInt($(a).find(".amount-price-td").text()) / parseInt($(a).find(".amount-td span").text());
   		var bPersonalPrice = 
   			parseInt($(b).find(".amount-price-td").text()) / parseInt($(b).find(".amount-td span").text());
   		
   		if(aPersonalPrice < bPersonalPrice) {
   			$(a).before(b);
   		}
   	});
	
	// 자주 쓰는 Selector 선언
	var $priceBoxTr = $("#price-box tbody tr");
	var $totalPrice = $("#total-price");
	var $discountPrice = $("#discount-price");
	var $discountBtnBox = $("#discount-btn-box");
	var $membershipModal = $("#membership-modal");
	
	// 실 결제금액 계산 function
	var calculRealPrice = function() {
		$("#real-price").text(parseInt($totalPrice.text()) + parseInt($discountPrice.text()));
	};
	
	// 총 금액 계산 function
	var calculTotalPrice = function() {
   		var totalPrice = 0;
   		var discountPrice = 0;
   		
   		$("#price-box tbody tr").each(function() {
   			var price = parseInt($(this).find(".amount-price-td").text());
   			if(price > 0) {
        		totalPrice += price;
   			} else {
   				discountPrice += price;
   			}
    	});
   		
  		$totalPrice.text(totalPrice);
		$discountPrice.text(discountPrice);
		
		$("input[name='paymentPrice']").val(totalPrice);
		$("input[name='discountPrice']").val(discountPrice);
   		calculRealPrice();        		
	};
	
	// 핸드폰 번호 자동 "-" 추가 function
	var autoMinus = function(str) {
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
		if( str.length < 4) {
			return str;
		} else if(str.length < 7) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3);
			return tmp;
		} else if(str.length < 11) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 3);
			tmp += '-';
			tmp += str.substr(6);
	  		return tmp;
		} else {        
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 4);
			tmp += '-';
			tmp += str.substr(7);
			return tmp;
		}
		return str;
	};
	
	// 카드 번호 자동 "-" 추가 function
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
	
	// 첫 시작시 총금액 계산 & 실금액 계산 & Key 가격 높은 순으로 배열
	calculTotalPrice();
	
	// 카드 / 현금 Radio 클릭 이벤트 & 시작시 카드 trigger
    $("input[name='payment']").on("click", function() {
        var payment = $(this).val();
        
        var htmlContents = "";
        if(payment == "C") {
        	htmlContents += "<div class='row'>";
        	htmlContents += "	<div class='col-sm-3'>";
            htmlContents += "		<label class='payment-info-label'>카드번호</label>";
            htmlContents += "	</div>";
            htmlContents += "	<div class='col-sm-9'>";
            htmlContents += "		<input type='text' name='cardNo' id='card-no' class='form-control'/>";
            htmlContents += "	</div>";
            htmlContents += "</div>";
        } else if(payment == "M") {
        	htmlContents += "<div class='row'>";
        	htmlContents += "	<div class='col-sm-3'>";
            htmlContents += "		<label class='payment-info-label'>받은 금액</label>";
            htmlContents += "	</div>";
            htmlContents += "	<div class='col-sm-9'>";
            htmlContents += "		<input type='number' name='takenPrice' id='taken-price' class='form-control'/>";
            htmlContents += "	</div>";
            htmlContents += "</div>";
            
            htmlContents += "<div class='row'>";
            htmlContents += "	<div class='col-sm-11 text-right'>";
            htmlContents += "		<button type='button' class='btn btn-sm cash-btn'>" + 1000 + "</button>";
            htmlContents += "		<button type='button' class='btn btn-sm cash-btn'>" + 5000 + "</button>";
            htmlContents += "		<button type='button' class='btn btn-sm cash-btn'>" + 10000 + "</button>";
            htmlContents += "		<button type='button' class='btn btn-sm cash-btn'>" + 50000 + "</button>";
            htmlContents += "	</div>";
            htmlContents += "</div>";
            
        	htmlContents += "<div class='row'>";
        	htmlContents += "	<div class='col-sm-3'>";
            htmlContents += "		<label class='payment-info-label'>거스름돈</label>";
            htmlContents += "	</div>";
        	htmlContents += "	<div class='col-sm-9'>";
            htmlContents += "		<div id='change-price' class='payment-info text-right pull-right'></div>";
            htmlContents += "	</div>";
            htmlContents += "</div>";
        }
        $("#needed-payment-box").empty().append(htmlContents);

        $("input[name='purchaseType']").val(payment);
    });
    $("input[value='C']").trigger("click");
    
    // 카드 번호 자동 "-" 입력 위임 Event
    $("#needed-payment-box").on("keyup", "#card-no", function() {
    	var autoNo = autoMinus($(this).val());
		$(this).val(autoNo);
    });
    
    // 현금 금액 btn 금액 덧셈 위임 Event
    $("#needed-payment-box").on("click", ".cash-btn", function() {
    	var price = parseInt($(this).text());
    	var takenPrice = parseInt($("input#taken-price").val());
    	if(!takenPrice) {
    		takenPrice = 0;
    	}
    	
    	$("input#taken-price").val(takenPrice + price).change();
    });
    
    // 현금 받은금액 - 거스름돈 자동 계산 위임 Event
    $("#needed-payment-box").on("change", "input#taken-price", function() {
        var realPrice = parseInt($("#real-price").text());
        var takenPrice = parseInt($(this).val());
        
        $("#change-price").empty()
        if(realPrice <= takenPrice) {
        	$("#change-price").text(takenPrice - realPrice);
        }
    });
    
    // 일반할인 btn Event & 시작시 일반할인 trigger
    $("#general-discount-btn").on("click", function() {
    	$discountBtnBox.empty();
    	
    	$.ajax({
    		type:"GET",
    		url:"general.esc",
    		dataType:"json",
    		success:function(result) {
    			$(result).each(function() {
					var htmlContents = "";
					
					if(this.discountPercent == null) {
						htmlContents += "<button type='button' id='discount-btn-" + this.discountType + this.discountPrice + "' class='btn btn-default btn-sm general-discount-btn'>";
					} else {
						htmlContents += "<button type='button' id='discount-btn-" + this.discountType + this.discountPercent + "' class='btn btn-default btn-sm general-discount-btn'>";
					}
					htmlContents += "	<span id='discount-span-" + this.id + "'>" + this.name + "</span>";
					htmlContents += "	<label class='sr-only'>";							
					if(this.customerType) {
						htmlContents += this.customerType.id;
					}
					htmlContents += "	</label>";
					htmlContents += "</button>";
					
					$discountBtnBox.append(htmlContents);
    			});
    		}
    	});
    });
   	$("#general-discount-btn").trigger("click");
   	
   	// 일반할인 btn 위임 Event
   	$discountBtnBox.on("click", "button.general-discount-btn", function() {
   		var discountName = $(this).find("span").text();
   		var discountKind = $(this).attr("id").replace("discount-btn-", "");
   		var discountId = $(this).find("span").attr("id").replace("discount-span-", "");
   		var discountType = discountKind.substring(0, 1);
   		var discountPrice = discountKind.substr(1);
   		var customerTypeId =  $(this).find("label.sr-only").text();
   		
   		var adjustDiscount = false;
   		$priceBoxTr.filter("tr.key-tr").each(function() {
   			var keyId = $(this).attr("id").replace("key-tr-", "");
   			var amount = parseInt($(this).find("td.amount-td label.sr-only").text());
   			
   			if(amount > 0 && (!(customerTypeId.trim()) || customerTypeId.trim() == keyId)) {
       			var personalPrice = parseInt($(this).find(".amount-price-td").text()) / parseInt($(this).find(".amount-td span").text());
       			
       			var htmlContents = "";
           		htmlContents += "<tr id='target-key-" + keyId + "' class='discount-tr general-discount'>";
           		htmlContents += "	<td class='general-name'>";
           		htmlContents += discountName;
           		htmlContents += "		<label class='sr-only'>" + discountId + "</label>";
           		htmlContents += "	</td>";
           		htmlContents += "	<td>1</td>";
           		if(discountType == "F") {
	           		htmlContents += "	<td class='amount-price-td'>-" + discountPrice + "</td>";
           		} else if(discountType == "S") {
	           		htmlContents += "	<td class='amount-price-td'>-" + (personalPrice - discountPrice) + "</td>";
           		} else {
           			htmlContents += "	<td class='amount-price-td'>-" + (personalPrice * discountPrice / 100) + "</td>";
           		}
           		
           		htmlContents += "	<td>";
           		htmlContents += "		<button class='btn btn-danger btn-xs remove-btn'>";
           		htmlContents += "			<span class='glyphicon glyphicon-remove'></span>";
           		htmlContents += "		</button>";
           		htmlContents += "	</td>";
           		htmlContents += "</tr>";
           		
           		$priceBoxTr.closest("tbody").append(htmlContents);
           		
           		$(this).find("td.amount-td label.sr-only").text((amount - 1));
           		adjustDiscount = true;
           		calculTotalPrice();
           		var hiddenDiscount = $("input[name='usedDiscount']").val();
           		if(hiddenDiscount) {
	           		$("input[name='usedDiscount']").val(hiddenDiscount + "," + discountId);
           		} else {
           			$("input[name='usedDiscount']").val(discountId);
           		}
           		return false;
   			}
   		});
   		
   		if(!adjustDiscount) {
   			alert("적용 가능한 상품이 없습니다.");
   		}
   	});
   	
   	// 할인 remove btn 위임 Event
   	$("#price-box tbody").on("click", ".remove-btn", function() {
   		var $tr = $(this).closest("tr");
   		if($tr.hasClass("general-discount")) {
       		var targetKeyId = $tr.attr("id").replace("target-key-", "");
       		var $targetAmountSr = $("#key-tr-" + targetKeyId).find("td.amount-td label.sr-only");
       		var generalId = $tr.find("td.general-name label.sr-only").text();
       		
       		$targetAmountSr.text(parseInt($targetAmountSr.text()) + 1);
       		
       		var arrGeneralId = $("input[name='usedDiscount']").val().split(",");
       		arrGeneralId.forEach(function(item, index) {
       			if(item == generalId) {
       				arrGeneralId.splice(index, 1);
       			}
       		});
       		$("input[name='usedDiscount']").val(arrGeneralId.join());
       		
       		$tr.remove();
       		calculTotalPrice();
   		} else if($tr.hasClass("coupon-discount")) {
       		var targetKeyId = $tr.attr("id").replace("target-key-", "");
       		var $targetAmountSr = $("#key-tr-" + targetKeyId).find("td.amount-td label.sr-only");
       		var couponId = $tr.find("td.coupon-name label.sr-only").text();
       		
       		$targetAmountSr.text(parseInt($targetAmountSr.text()) + 1);
       		
       		var arrCouponId = $("input[name='usedCoupon']").val().split(",");
       		arrCouponId.forEach(function(item, index) {
       			if(item == couponId) {
       				arrCouponId.splice(index, 1);
       			}
       		});
       		$("input[name='usedCoupon']").val(arrCouponId.join());
       		
       		$("input[name='coupon']").each(function() {
       			if($(this).val() == couponId) {
       				$(this).show();
       			}
       		});
       		
       		$tr.remove();
       		calculTotalPrice();
   		} else if($tr.hasClass("point-discount")) {
   			var usingPoint = $tr.find("td.amount-price-td").text();
   			var remainPoint = $("#remain-point-box h4").text();
   			
   			$("#remain-point-box h4").text(parseInt(remainPoint) - parseInt(usingPoint));
   			var usedPoint = $("input[name='usedPoint']").val();
       		$("input[name='usedPoint']").val(parseInt(usedPoint) + parseInt(usingPoint));
       		
       		$tr.remove();
       		calculTotalPrice();
   		}
   	});
   	
   	// 직원 할인 btn Event
   	$("#employee-discount-btn").on("click", function() {
   		var htmlContents = "";
   		
   		htmlContents += "<form id='check-emp-form' class='form-horizontal'>";
   		htmlContents += "	<div class='form-group'>";
   		htmlContents += "		<div class='col-sm-2'>";
   		htmlContents += "			<label class='control-label'>사원 ID</label>";
   		htmlContents += "		</div>";
   		htmlContents += "		<div class='col-sm-8'>";
   		htmlContents += "			<input type='text' name='empid' class='form-control'/>";
   		htmlContents += "		</div>";
   		htmlContents += "		<div class='col-sm-1'>";
   		htmlContents += "			<button type='submit' id='check-emp-btn' class='btn btn-boots'>확인</button>";
   		htmlContents += "		</div>";
   		htmlContents += "	</div>";
   		htmlContents += "</form>";
   		
   		$discountBtnBox.empty().append(htmlContents);
   	});
   	
   	// 직원 할인 확인 btn 위임 Event
   	$discountBtnBox.on("click", "#check-emp-btn", function(e) {
   		e.preventDefault();
   		var empid = $("input[name='empid']").val();
   		
		console.log(2143);
   		if(empid != "") {
   			$.ajax({
   				type:"POST",
   				url:"checkemp.esc",
   				data:{empid:empid},
   				dataType:"json",
   				success:function(result) {
   					console.log(result.success);
   					if(result.success) {
   						var adjustDiscount = false;
   		           		$priceBoxTr.filter("tr.key-tr").each(function() {
   		           			var keyId = $(this).attr("id").replace("key-tr-", "");
   		           			var amount = parseInt($(this).find("td.amount-td label.sr-only").text());
   		           			
   		           			if(amount > 0) {
   		               			var personalPrice = parseInt($(this).find(".amount-price-td").text()) / parseInt($(this).find(".amount-td span").text());
           						alert(result.employee.name + "직원 확인이 완료되었습니다.");
   		               			
   		               			var htmlContents = "";
   		                   		htmlContents += "<tr id='target-key-" + keyId + "' class='discount-tr emp-discount'>";
   		                   		htmlContents += "	<td>직원할인</td>";
   		                   		htmlContents += "	<td>1</td>";
   		        	           	htmlContents += "	<td class='amount-price-td'>-" + personalPrice + "</td>";
   		                   		htmlContents += "	<td>";
   		                   		htmlContents += "		<button class='btn btn-danger btn-xs remove-btn'>";
   		                   		htmlContents += "			<span class='glyphicon glyphicon-remove'></span>";
   		                   		htmlContents += "		</button>";
   		                   		htmlContents += "	</td>";
   		                   		htmlContents += "</tr>";
   		                   		
   		                   		$priceBoxTr.closest("tbody").append(htmlContents);
   		                   		
   		                   		$(this).find("td.amount-td label.sr-only").text((amount - 1));
   		                   		adjustDiscount = true;
   				           		calculTotalPrice();

   		                   		return false;
   		           			}
   		           		});
   		           		
       		           	if(!adjustDiscount) {
       	           			alert("적용 가능한 상품이 없습니다.");
       	           		}
   					} else {
   						alert(result.message);
   					}
   				},
   				error:function() {
   					alert("알수없는 ERROR입니다.");
   				}
   			});
   		} else {
   			alert("직원 ID를 입력하세요");
   		}
   	});
   	
   	// modal 핸드폰 번호 input Event
   	$("#customer-phone").on("keyup", function() {
   		var autoNo = autoMinus($(this).val());
		$(this).val(autoNo);
   	});
   	
   	// 고객 조회 modal btn Event
   	$("#customer-search-btn").on("click", function() {
   		var customerName = $("input#customer-name").val();
   		var customerPhone = $("input#customer-phone").val();
   		
   		$("#remain-point-box h4").empty();
   		$("#coupon-table tbody").empty();
   		
   		$.ajax({
   			type:"POST",
   			url:"customer.esc",
   			data:{customerName:customerName, customerPhone:customerPhone},
   			dataType:"json",
   			success:function(result) {
   				$("#remain-point-box h4").text(result.customer.miliege);
   				$("#user-id-span").text(result.customer.username);
   				$("#user-rank-span").text(result.customer.customerRank.type);
   				
   				$(result.couponList).each(function() {
   					var htmlContents = "";
   					
   					htmlContents += "<tr>";
   					htmlContents += "	<td><input type='checkbox' name='coupon' value='" + this.id + "'/></td>";
   					htmlContents += "	<td class='coupon-name'>";
   					htmlContents += this.coupon.name;
   					htmlContents += "	</td>";
   					htmlContents += "	<td>" + this.expiredAt + "</td>";
   					htmlContents += "</tr>";
   					
       				$("#coupon-table tbody").append(htmlContents);
   				});
   				
   				$("input[name='customerId']").val(result.customer.id);
   			},
   			error:function() {
   				alert("해당 회원정보가 존재하지 않습니다.");
   			}
   		});
   	});
   	
   	// modal coupon checkbox Event
   	$("#coupon-table").on("click", "input[name='coupon']", function() {
   		var $checkedCoupon = $(this);
   		var couponId = $checkedCoupon.val();
   		var couponName = $checkedCoupon.closest("td").siblings("td.coupon-name").text();
   		
   		var adjustDiscount = false;
   		$priceBoxTr.filter("tr.key-tr").each(function() {
   			console.log($(this));
   			var keyId = $(this).attr("id").replace("key-tr-", "");
   			var amount = parseInt($(this).find("td.amount-td label.sr-only").text());
   			
   			if(amount > 0) {
       			var personalPrice = parseInt($(this).find(".amount-price-td").text()) / parseInt($(this).find(".amount-td span").text());
       			
       			var htmlContents = "";
           		htmlContents += "<tr id='target-key-" + keyId + "' class='discount-tr coupon-discount'>";
           		htmlContents += "	<td class='coupon-name'>";
           		htmlContents += couponName;
           		htmlContents += "		<label class='sr-only'>" + couponId + "</label>";
           		htmlContents += "	</td>";
           		htmlContents += "	<td>1</td>";
	           	htmlContents += "	<td class='amount-price-td'>-" + personalPrice + "</td>";
           		htmlContents += "	<td>";
           		htmlContents += "		<button class='btn btn-danger btn-xs remove-btn'>";
           		htmlContents += "			<span class='glyphicon glyphicon-remove'></span>";
           		htmlContents += "		</button>";
           		htmlContents += "	</td>";
           		htmlContents += "</tr>";
           		
           		$priceBoxTr.closest("tbody").append(htmlContents);
           		
           		$(this).find("td.amount-td label.sr-only").text((amount - 1));
           		adjustDiscount = true;
           		calculTotalPrice();
           		
           		var usedCoupon = $("input[name='usedCoupon']").val();
           		
           		if (usedCoupon) {
	           		$("input[name='usedCoupon']").val(usedCoupon + "," + couponId);
           		} else {
	           		$("input[name='usedCoupon']").val(couponId);
           		}
           		
           		$checkedCoupon.prop("checked", false).hide();
           		return false;
   			}
   		});
   		
   		if(!adjustDiscount) {
   			alert("적용 가능한 상품이 없습니다.");
   			return false;
   		}
   	});
   	
   	
   	// modal 사용 btn Event
   	$("#modal-confirm-btn").on("click", function() {
   		
   		var usingPoint = $("#using-point").val();
   		var remainPoint = $("#remain-point-box h4").text();
   		
   		if(usingPoint && $("#real-price").text() != "0" && parseInt(usingPoint) <= parseInt(remainPoint)) {
   			var htmlContents = "";
       		htmlContents += "<tr class='discount-tr point-discount'>";
       		htmlContents += "	<td>포인트사용</td>";
       		htmlContents += "	<td></td>";
           	htmlContents += "	<td class='amount-price-td'>-" + usingPoint + "</td>";
       		htmlContents += "	<td>";
       		htmlContents += "		<button class='btn btn-danger btn-xs remove-btn'>";
       		htmlContents += "			<span class='glyphicon glyphicon-remove'></span>";
       		htmlContents += "		</button>";
       		htmlContents += "	</td>";
       		htmlContents += "</tr>";
       		
       		$priceBoxTr.closest("tbody").append(htmlContents);
       		calculTotalPrice();
       		$("#remain-point-box h4").text(parseInt(remainPoint) - parseInt(usingPoint));
       		
       		var usedPoint = $("input[name='usedPoint']").val();
       		if(usedPoint) {
           		$("input[name='usedPoint']").val(parseInt(usedPoint) + parseInt(usingPoint));
       		} else {
           		$("input[name='usedPoint']").val(parseInt(usingPoint));
       		}
   		}
   		
   		$("#using-point").val("");
   		$membershipModal.modal("hide");
   	});
   	
   	// 결제 btn Event
   	$("#payment-btn").on("click", function(e) {
   		e.preventDefault();
   		
   		var $purchaseType = $("input[name='purchaseType']");
   		var cardNo = $("input[name='cardNo']").val();
   		if($purchaseType.val() == "C" && cardNo == "") {
   			$purchaseType.val("M");
   		}
   		
   	});
   	
   	// 결제 확인 Modal 확인 btn Event
   	$("#confirm-btn").on("click", function(e) {
   		$("#payment-form").submit();
   	});
});