package com.es.pos.web;

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
	public TicketReceipt reprint(String rid) {
		return refundService.findReceiptByRid(rid);
	}
}
