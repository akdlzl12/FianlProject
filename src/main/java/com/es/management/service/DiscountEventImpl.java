package com.es.management.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.management.mapper.CustomerMapper;
import com.es.management.mapper.DiscountMapper;
import com.es.management.vo.CustomerType;
import com.es.management.vo.Discount;
import com.es.management.web.form.DiscountForm;

@Service
public class DiscountEventImpl implements DiscountEventService{

	@Autowired
	private DiscountMapper discountMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Discount> getDiscount(int discountId) {
		return discountMapper.getDiscount(discountId);
	}
	
	@Override
	public CustomerType getCustomerTypeByType(int typeId) {
		return customerMapper.getCustomerTypeByType(typeId);
	}
	
	@Override
	public void insertDiscount(DiscountForm discountForm) {
		discountMapper.insertDiscount(discountForm);
	}
	
	@Override
	public List<CustomerType> getCustomerType(int typeId) {
		return customerMapper.getCustomerType(typeId);
	}
	
	@Override
	public void deleteDiscount(Map<String, Object> checkNo) {
		discountMapper.deleteDiscount(checkNo);
	}
}
