package com.es.management.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketRePrintController {

	// 네비버튼을 누르면 실행되는 controller
	@RequestMapping("/ticketRePrint.esc")
	public String select() {
		return "ticketRePrint";
	}
}
