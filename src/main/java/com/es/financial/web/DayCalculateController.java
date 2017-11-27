package com.es.financial.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DayCalculateController {

	@RequestMapping("/dayCalculate.esc")
	public String calculate() {
		return "dayCalculate";
	}
}
