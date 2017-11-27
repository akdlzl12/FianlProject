package com.es.management.service;

import java.util.List;

import com.es.common.vo.Criteria;
import com.es.management.vo.LostCustomerItem;
import com.es.management.web.form.InsertItemForm;
import com.es.management.web.form.UpdateGiveItemForm;

public interface LostAndFoundService {

	List<LostCustomerItem> getLostItemSelect(Criteria criteria);
	LostCustomerItem getDetailLostItemSelect(int id);
	void updateGiveItem(UpdateGiveItemForm updateGiveItemForm);
	void insertItem(InsertItemForm insertItemForm);
}
