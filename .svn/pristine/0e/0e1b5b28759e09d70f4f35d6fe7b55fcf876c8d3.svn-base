package com.es.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.vo.Criteria;
import com.es.management.service.InformationSelectService;
import com.es.management.vo.Customer;

@RestController
public class InformationSelectAjaxController {
 
	@Autowired
	private InformationSelectService informationSelectService;
	
	// ajax에서 받은 id값을 통해 detail값을 추출한다.
	@RequestMapping("/getDetailCustomer.esc")
	@ResponseBody
	public Customer getDetailCustomer(int id) {
		Customer customer = informationSelectService.getDetailCustomer(id);
		return customer;
	}
	
	// ajax에서 받은 criteria값을 통해 customer값을 추출한다.
	@RequestMapping("/getSearchCustomers.esc")
	@ResponseBody
	public List<Customer> getSearchCustomers(Criteria criteria) {
		return informationSelectService.searchByCustomers(criteria);
	}
}
