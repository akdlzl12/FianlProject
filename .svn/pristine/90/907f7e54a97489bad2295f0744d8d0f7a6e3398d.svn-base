package com.es.pos.web.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.es.pos.vo.PosLoginHistory;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private Set<String> urlSet;
	public void setUrlSet(Set<String> urlSet) {
		this.urlSet = urlSet;
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
		if(urlSet.contains(requestUri)) {
			return true;
		}
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("/pos/login.esc");
			return false;
		}
		
		PosLoginHistory login = (PosLoginHistory) session.getAttribute("LOGIN_INFO");
		if(login == null) {
			response.sendRedirect("/pos/login.esc");
			return false;
		}
		
		return true;
	}
}
