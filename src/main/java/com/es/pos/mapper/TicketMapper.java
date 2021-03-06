package com.es.pos.mapper;

import java.util.Date;
import java.util.List;

import com.es.financial.vo.CouponCustomer;
import com.es.pos.vo.DiscountTicket;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

public interface TicketMapper {
	
	int getReceiptSeq();
	
	void addTicketReceipt(TicketReceipt ticketReceipt);
	void addTicket(Ticket ticket);
	void addDiscountTicket(DiscountTicket discountTicket);
	
	List<Ticket> getReservedSeatsByTimetableId(int timetableId);
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
	List<Ticket> getTicketByReceiptId(int receiptId);
	List<DiscountTicket> getDiscountsByReceiptId(int receiptId);
	List<CouponCustomer> getCouponesByReceiptId(int receiptId);
	List<TicketReceipt> getEndedReceiptAtYesterdayByDate(Date now);
	
	void updateReceipt(TicketReceipt ticketReceipt);
}