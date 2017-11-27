package com.es.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.management.mapper.CustomerMapper;
import com.es.management.vo.CustomerType;

@Service
public class KeyInManagementImpl implements KeyInManagementService{

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public void setByKeyIn(CustomerType customerType) {
		customerMapper.setByKeyIn(customerType);
		
	}
	
	@Override
	public List<CustomerType> getKeyInAllSelect() {
		return customerMapper.getKeyInAllSelect();
	}
	
	@Override
	public void deleteByKeyIn(int[] keys) {
		// controller에서 받은 배열을 map에 담아 mapper에 보낸다.
		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("keys", keys);
		customerMapper.deleteByKeyIn(keyMap);
	}
}
