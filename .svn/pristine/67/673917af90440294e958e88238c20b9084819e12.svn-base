package com.es.financial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.common.vo.Criteria;
import com.es.financial.mapper.CouponMapper;
import com.es.financial.mapper.FinTestMapper;
import com.es.financial.vo.Coupon;
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
	
	
	@Override
	public void addCoupon(Coupon coupon) {
		System.out.println(1);
		couponMapper.addCoupon(coupon);
	}
	
	@Override
	public List<Customer> searchCustomers(Criteria criteria) {
		return finTestMapper.searchCustomers(criteria);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerMapper.getAllCustomers();
	}
	@Override
	public Customer searchDetailCustomer(int id) {
		return finTestMapper.searchDetailCustomer(id);
	}

}
