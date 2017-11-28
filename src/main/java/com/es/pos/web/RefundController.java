package com.es.pos.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.pos.service.RefundService;
import com.es.pos.vo.PaymentForm;
import com.es.pos.vo.TicketReceipt;

@Controller
public class RefundController {

	@Autowired
	private RefundService refundService;
	
	@GetMapping("/refund.esc")
	public String refund() {
		return "refund";
	}
	
	@PostMapping("/refund.esc")
	public String search(@RequestParam("receiptNo") String rid, Model model) {
		Map<String, Object> map = refundService.findReceiptInfo(rid);
		model.addAttribute("info", map);
		
		return "refund";
	}
	
	@PostMapping("/refundconfirm.esc")
	public String confirm(PaymentForm paymentForm) {
		TicketReceipt receipt = refundService.findReceiptByRid(paymentForm.getReceiptNo());
		refundService.refundReceipt(receipt);
		
		return "redirect:/pos/home.esc";
	}
	
	@PostMapping("/reprint.esc")
	@ResponseBody
	public Map<String, Object> reprint(String rid) {
		Map<String, Object> map = new HashMap<String, Object>();
		TicketReceipt receipt = refundService.findReceiptByRid(rid);
		
		if(receipt != null && "N".equals(receipt.getDeleted())) {
			map.put("success", true);
			map.put("receipt", receipt);
		} else if(receipt != null && "Y".equals(receipt.getDeleted())) {
			map.put("success", false);
			map.put("message", "이미 환불된 티켓입니다.");
		} else if(receipt == null) {
			map.put("success", false);
			map.put("message", "존재하지 않는 티켓번호입니다.");
		}
		
		return map;
	}
}
