package com.es.pos.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String login(PosLoginForm loginForm, HttpSession session, Model model) {
		Employee employee = logService.findEmployeeById(loginForm.getEmpId(), loginForm.getEmpPwd());
		if(employee == null) {
			model.addAttribute("error", "잘못된 ID 혹은 비밀번호입니다.");
			return "redirect:/pos/login.esc";
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
	public Map<String, Object> restin(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		EmployeeTimetable timetable = logService.getEmployeeTimetable((PosLoginHistory) session.getAttribute("LOGIN_INFO"));
		if(timetable == null) {
			map.put("success", false);
			map.put("message", "만료된 세션입니다.");
		} else if(timetable.getRestStartedAt() != null) {
			map.put("success", false);
			map.put("message", "이미 휴식을 다녀온 직원입니다.");
		} else {
			timetable = logService.enrollStartingRest(timetable);
			map.put("success", true);
			map.put("timetable", timetable);
		}
		
		return map;
	}
	
	@GetMapping("/workback.esc")
	@ResponseBody
	public Map<String, Object> workingbakc(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		EmployeeTimetable timetable = logService.getEmployeeTimetable((PosLoginHistory) session.getAttribute("LOGIN_INFO"));
		if(timetable == null) {
			map.put("success", false);
			map.put("message", "만료된 세션입니다.");
		} else if(timetable.getRestStartedAt() != null) {
			map.put("success", false);
			map.put("message", "잘못된 접근입니다.");
		} else {
			timetable = logService.enrollFinishingRest(timetable);
			map.put("success", true);
			map.put("timetable", timetable);
		}
		
		return map;
	}
}