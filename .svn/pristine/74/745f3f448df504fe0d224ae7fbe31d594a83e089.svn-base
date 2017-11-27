package com.es.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.common.vo.Criteria;
import com.es.management.mapper.LostAndFoundMapper;
import com.es.management.vo.LostCustomerItem;
import com.es.management.web.form.InsertItemForm;
import com.es.management.web.form.UpdateGiveItemForm;

@Service
public class LostAndFoundImpl implements LostAndFoundService{

	@Autowired
	private LostAndFoundMapper lostAndFoundMapper; 
	
	@Override
	public List<LostCustomerItem> getLostItemSelect(Criteria criteria) {
		System.out.println("service" + criteria.toString());
		return lostAndFoundMapper.getLostItemSelect(criteria);
	}
	
	@Override
	public LostCustomerItem getDetailLostItemSelect(int id) {

		return lostAndFoundMapper.getDetailLostItemSelect(id);
	}
	
	@Override
	public void updateGiveItem(UpdateGiveItemForm updateGiveItemForm) {
		lostAndFoundMapper.updateGiveItem(updateGiveItemForm);
	}
	
	@Override
	public void insertItem(InsertItemForm insertItemForm) {
		lostAndFoundMapper.insertItem(insertItemForm);
	}
}
