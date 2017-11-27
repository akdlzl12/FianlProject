package com.es.financial.mapper;


import com.es.financial.vo.Coupon;

public interface CouponMapper {
	
	int couponId();
	void addCoupon(Coupon coupon);
	void changeReceived(int gid);
}
