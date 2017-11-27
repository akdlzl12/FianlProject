package com.es.financial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.common.vo.Criteria;
import com.es.financial.mapper.CouponMapper;
import com.es.financial.mapper.FinTestMapper;
import com.es.financial.vo.Coupon;
import com.es.financial.vo.CouponCustomer;
import com.es.financial.vo.Gift;
import com.es.financial.vo.GiftCustomer;
import com.es.management.mapper.CustomerMapper;
import com.es.management.vo.Customer;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private  CouponMapper couponMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private FinTestMapper finTestMapper;
	
	// 등록
	@Override
	public Coupon addCoupon(Coupon coupon) {
		coupon.setId(couponMapper.couponId());
		couponMapper.addCoupon(coupon);
		
		return coupon;
	}
	
	// 업데이트
	@Override
	public void changeReceived(int[] gid) {
		
		for(int id : gid) {
			couponMapper.changeReceived(id);
		}
	}
	
	// Customer의 검색조건에 맞는 값 조회
	
	@Override
	public List<Customer> searchByCoupon(Criteria criteria) {
		return customerMapper.searchByCoupon(criteria);
	}
		
	public List<Customer> searchByGift(Criteria criteria) {
		return customerMapper.searchByGift(criteria);
	}
	@Override
	public List<Customer> searchByOther(Criteria criteria) {
		return customerMapper.searchByOther(criteria);
	}
	
	
	// Customer의 상세정보 중 사용자 조회
	@Override
	public Customer getDetailCustomer(int id) {
		return customerMapper.getDetailCustomer(id);
	}

	@Override
	public List<CouponCustomer> getDetailCoupon(int id) {
		return customerMapper.getDetailCoupon(id);
	}

	@Override
	public List<GiftCustomer> getDetailGift(int id) {
		return customerMapper.getDetailGift(id);
	}

	
	

	

}
