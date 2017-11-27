package com.es.financial.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.vo.Criteria;
import com.es.financial.service.CouponService;
import com.es.management.service.InformationSelectService;
import com.es.management.vo.Customer;

@RestController
public class CouponAjaxController {
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private InformationSelectService informationSelectService;
	
	@RequestMapping("/searchCustomers.esc")
	@ResponseBody
	public List<Customer> searchCustomers(Criteria criteria) {
		return couponService.searchCustomers(criteria);
	}
	
	@RequestMapping("/searchDetailCustomers.esc")
	@ResponseBody
	public Customer searchDetailCustomers(int id){
		return couponService.searchDetailCustomer(id);
	}
}
