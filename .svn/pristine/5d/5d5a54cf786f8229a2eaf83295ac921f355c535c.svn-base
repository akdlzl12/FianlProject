package com.es.pos.mapper;

import java.util.List;

import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.TicketReceipt;

public interface TicketMapper {
	
	// 신용카드번호로 정보조회
	List<TicketReceipt> getCardSelect(String creditNo);
	// 신용카드번호로 얻은 정보의 디테일한 정보 얻기
	TicketReceipt getCardDetailSelect(int customerId);
	// 영수증번호를 검색하여 원하는 값 출력
	List<TicketReceipt> getRidSelect(String rid);
	// 포스기기와 로그인한 날짜를 통해서 사원아이디 출력
	PosLoginHistory getFosAndDateSelect(TicketReceipt ticketReceipt);
	// 유저아이디로 상세정보 값 출력
	TicketReceipt getRidDetailSelect(int customerId);
}
