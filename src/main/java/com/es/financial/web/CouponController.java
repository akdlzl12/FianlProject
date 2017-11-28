package com.es.financial.web;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.financial.form.CouponForm;
import com.es.financial.service.CouponService;
import com.es.financial.vo.Coupon;
import com.es.financial.vo.Gift;
import com.es.management.vo.CustomerRank;

@Controller
public class CouponController {
	
	
	
	@Autowired
	CouponService couponService;
	
	@PostMapping("/add.esc")
	public String submit(CouponForm couponForm) {
		
		if(couponForm.getType().equals("coupon")) {
		Coupon coupon = new Coupon();
		BeanUtils.copyProperties(couponForm, coupon);
		
		CustomerRank customerRank = new CustomerRank();
		customerRank.setId(couponForm.getCustomerRank());
		coupon.setCustomerRank(customerRank);
		
		coupon = this.couponService.addCoupon(coupon);
		
		} else if(couponForm.getType().equals("gift")){
			
		Gift gift = new Gift();
		BeanUtils.copyProperties(couponForm, gift);
		
		CustomerRank customerRank = new CustomerRank();
		customerRank.setId(couponForm.getCustomerRank());
		gift.setCustomerRank(customerRank);
		
		gift = this.couponService.addGift(gift);
		}
			
		return "redirect:/financial/searchCoupon.esc";
	}
	
	
	
	@RequestMapping("/managementCoupon.esc")
	public String management() {		
		
		return "managementCoupon";
	}
	
}
