package com.es.management.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.management.service.KeyInManagementService;
import com.es.management.vo.CustomerType;

@Controller
public class KeyInManagementController {

	@Autowired
	private KeyInManagementService keyInManagementService;
	
	// 네비를 통해 들어올 때 실행되는 controller
	@RequestMapping("/KeyInManagement.esc")
	public String select(@RequestParam(value="key",required=false) int[] key, Model model) {
		// checkbox의 value값을 받아 삭제 시키고 다시 사이트를 재로딩함
		if(key != null) {
			System.out.println(key.length);
			keyInManagementService.deleteByKeyIn(key);
		}
		List<CustomerType> getKeyInAllSelect = keyInManagementService.getKeyInAllSelect();
		model.addAttribute("getKeyInAllSelect", getKeyInAllSelect);
		return "KeyInManagement";
	}
	
}
