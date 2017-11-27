package com.es.financial.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.common.vo.Criteria;
import com.es.financial.service.CouponService;
import com.es.financial.vo.Coupon;
import com.es.management.vo.Customer;

@Controller
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@PostMapping("/add.esc")
	public String submit(Coupon coupon) {
		System.out.println(1);
		System.out.println(coupon);
		couponService.addCoupon(coupon);
		System.out.println(2);
		
		return "redirect:/managementCoupon";
	}
	
	@RequestMapping("/managementCoupon.esc")
	public String management(Model model) {
		
		List<Customer> customers = couponService.getAllCustomers();
		model.addAttribute("customers", customers);
		
		return "managementCoupon";
	}
	
}
