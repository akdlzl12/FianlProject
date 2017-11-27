package com.es.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.management.service.KeyInManagementService;
import com.es.management.vo.CustomerType;

@Controller
public class KeyInManagementAjaxController {

	@Autowired
	private KeyInManagementService keyInManagementService;

	// ajax를 이용해서 값을 넘겨주어 키인값을 저장한다.
	@RequestMapping("/setByKeyIn.esc")
	@ResponseBody
	public List<CustomerType> setByKeyIn(CustomerType customerType) {
		keyInManagementService.setByKeyIn(customerType);
		
		return keyInManagementService.getKeyInAllSelect();
	}
}
