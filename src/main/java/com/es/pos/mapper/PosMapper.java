package com.es.pos.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.es.employee.vo.Employee;
import com.es.employee.vo.EmployeeTimetable;
import com.es.financial.form.PosForm;
import com.es.management.vo.Discount;
import com.es.movie.vo.MovieTranslation;
import com.es.pos.vo.Pos;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

public interface PosMapper {

	int addLoginHistorySeq();
	void addPosLoginHistory(PosLoginHistory posLoginHistory);
	void addEmployeeTimetable(EmployeeTimetable employeeTimetable);
	
	Pos getPosById(int posId);
	EmployeeTimetable getEmployeeTimetableByPosHistory(PosLoginHistory posLoginHistory);
	
	void updateEmployeeTimetable(EmployeeTimetable employeeTimetable);
	void updatePosLoginHistory(PosLoginHistory posLoginHistory);
	
	// 날짜로 포스아이디 조회
	List<Pos> searchDateByPosId(Date date);
	
	// 날짜로 직원아이디 조회
	List<PosLoginHistory> searchDateByEmployeeId(Date date);
	
	// 날짜, 직원이름, 포스번호로 영수증 아이디 조회 
	List<TicketReceipt> searchReceipts(PosForm posForm);
	
	// 영수증 아이디로 리스트 값 조회
	PosForm searchTicket(int id);
	
	List<PosForm> searchTicket2(int id);
	// 단말기정산 상세정보
	List<Discount> searchRceiptsIdByDiscountInfo(int id);
	
	
}
