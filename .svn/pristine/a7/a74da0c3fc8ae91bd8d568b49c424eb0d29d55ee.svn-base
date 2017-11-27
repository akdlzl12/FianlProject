package com.es.financial.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.vo.Criteria;
import com.es.financial.service.CouponService;
import com.es.financial.vo.CouponCustomer;
import com.es.financial.vo.GiftCustomer;
import com.es.management.service.InformationSelectService;
import com.es.management.vo.Customer;

@RestController
public class CouponAjaxController {
	
	@Autowired
	private CouponService couponService;
	
	
	@RequestMapping("/searchCustomers.esc")
	@ResponseBody
	public List<Customer> searchCustomers(Criteria criteria) {
		if(criteria.getOpt().equals("couponId")) {			
			return couponService.searchByCoupon(criteria);
		} else if(criteria.getOpt().equals("giftId")) {
			return couponService.searchByGift(criteria);
		} else {
			return couponService.searchByOther(criteria);
		}
	}
	
	@RequestMapping("/changeReceived.esc")
	@ResponseBody
	public String updateById(int[] gid){
		
		couponService.changeReceived(gid);
		
		return null;
	}
	
	@RequestMapping("/searchDetailCustomers.esc")
	@ResponseBody
	public Map<String, Object> searchDetailCustomers(int id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		 Customer searchAll= couponService.getDetailCustomer(id);
		 List<CouponCustomer> searchCoupon = couponService.getDetailCoupon(id);
		 List<GiftCustomer> searchGift = couponService.getDetailGift(id);
		 
		map.put("searchAll", searchAll);
		map.put("searchCoupon", searchCoupon);
		map.put("searchGift", searchGift);
		return map;
	}
}
