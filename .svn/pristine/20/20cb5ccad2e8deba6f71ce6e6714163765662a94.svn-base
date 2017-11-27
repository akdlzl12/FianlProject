package com.es.management.mapper;

import java.util.List;

import com.es.employee.vo.Employee;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.TicketReceipt;

public interface TicketSelectMapper {
	
	// 영수증번호를 검색하여 원하는 값 출력
	List<TicketReceipt> getRidSelect(String rid);
	// 유저아이디로 상세정보 값 출력
	TicketReceipt getRidDetailSelect(int customerId);
	// 포스기기와 로그인한 날짜를 통해서 사원아이디 출력
	PosLoginHistory getFosAndDateSelect(TicketReceipt ticketReceipt);
	
}
