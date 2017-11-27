package com.es.pos.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.employee.vo.Employee;
import com.es.employee.vo.EmployeeTimetable;
import com.es.pos.service.LogService;
import com.es.pos.vo.PosLoginForm;
import com.es.pos.vo.PosLoginHistory;

@Controller
public class LoginController {

	@Autowired
	private LogService logService;
	
	@GetMapping("/login.esc")
	public String form(HttpSession session) {
		if(session.getAttribute("LOGIN_INFO") != null) {
			return "redirect:/pos/home.esc";
		}
		return "loginform";
	}
	
	@PostMapping("/login.esc")
	public String login(PosLoginForm loginForm, HttpSession session) {
		Employee employee = logService.findEmployeeById(loginForm.getEmpId(), loginForm.getEmpPwd());
		if(employee == null) {
			throw new RuntimeException("잘못된 사원 ID 혹은 비밀번호입니다.");
		}
		
		PosLoginHistory loginInfo = logService.enrollStartingWork(employee, loginForm.getPosId());
		session.setAttribute("LOGIN_INFO", loginInfo);
		session.setMaxInactiveInterval(-1);
		
		return "redirect:/pos/home.esc";
	}
	
	@GetMapping("/logout.esc")
	public String logout(HttpSession session) {
		logService.enrollFinishingWork((PosLoginHistory) session.getAttribute("LOGIN_INFO"));
		
		session.invalidate();
		return "redirect:/pos/login.esc";
	}
	
	@GetMapping("/restin.esc")
	@ResponseBody
	public EmployeeTimetable restin(HttpSession session) {
		EmployeeTimetable timetable = logService.enrollStartingRest((PosLoginHistory) session.getAttribute("LOGIN_INFO"));
		
		return timetable;
	}
	
	@GetMapping("/workback.esc")
	@ResponseBody
	public EmployeeTimetable workingbakc(HttpSession session) {
		EmployeeTimetable timetable = logService.enrollFinishingRest((PosLoginHistory) session.getAttribute("LOGIN_INFO"));
		
		return timetable;
	}
}