package com.es.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.management.service.CardHistoryService;
import com.es.management.service.TicketRePrintService;
import com.es.pos.vo.TicketReceipt;

@Controller
public class CardHistoryAjaxController {

	@Autowired
	private CardHistoryService cardHistoryService;
	
	@Autowired
	private TicketRePrintService ticketRePrintService;
	
	@RequestMapping("/getCardSelect.esc")
	@ResponseBody
	public List<TicketReceipt> getCardSelect(String creditNo) {
		
		return cardHistoryService.getCardSelect(creditNo);
	}
	
	@RequestMapping("/getCardDetailSelect.esc")
	@ResponseBody
	public TicketReceipt getCardDetailSelect(String id) {
		System.out.println(id);
		return ticketRePrintService.getRidSelect(id).get(0);
	}
}
