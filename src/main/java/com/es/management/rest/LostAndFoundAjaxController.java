package com.es.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.common.vo.Criteria;
import com.es.management.service.LostAndFoundService;
import com.es.management.vo.LostCustomerItem;

@Controller
public class LostAndFoundAjaxController {

	@Autowired
	private LostAndFoundService lostAndFoundService;
	
	@RequestMapping("/getLostItemSelect.esc")
	@ResponseBody
	public List<LostCustomerItem> getLostItemSelect(Criteria criteria) {
		System.out.println(criteria.toString());
		return lostAndFoundService.getLostItemSelect(criteria);
	}
	
	@RequestMapping("/getDetailLostItemSelect.esc")
	@ResponseBody
	public LostCustomerItem getDetailLostItemSelect(int id) {
		System.out.println(id);
		return lostAndFoundService.getDetailLostItemSelect(id);
	}
}
