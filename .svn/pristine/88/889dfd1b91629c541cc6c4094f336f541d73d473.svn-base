package com.es.management.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.management.service.LostAndFoundService;
import com.es.management.web.form.InsertItemForm;
import com.es.management.web.form.UpdateGiveItemForm;

@Controller
public class LostAndFoundController {
	
	@Autowired
	private LostAndFoundService lostAndFoundService; 

	@RequestMapping("/lostAndFound.esc")
	public String select() {
		return "lostAndFound";
	}
	
	@RequestMapping("/updateGiveItem.esc")
	public String updateGiveItem(UpdateGiveItemForm updateGiveItemForm) {
		System.out.println("update" + updateGiveItemForm.toString());
		lostAndFoundService.updateGiveItem(updateGiveItemForm);
		return "redirect:lostAndFound.esc";
	}
	
	@RequestMapping("/insertItem.esc")
	public String insertItem(InsertItemForm insertItemForm) {
		lostAndFoundService.insertItem(insertItemForm);
		return "redirect:lostAndFound.esc";
	}
}
