package com.es.management.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.management.service.InformationSelectService;
import com.es.management.vo.Customer;

@Controller
public class InformationSelectController {

	@Autowired
	private InformationSelectService informationSelectService;
	
	@RequestMapping("/informationSelect.esc")
	public String getAllCustomers(Model model) {
		List<Customer> customers = informationSelectService.getAllCustomers();
		
		model.addAttribute("customers", customers);
		return "information-select";
	}
}
