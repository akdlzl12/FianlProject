package com.es.common.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@GetMapping(value= {"/", "/index.do", "/home.do"})
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
}
