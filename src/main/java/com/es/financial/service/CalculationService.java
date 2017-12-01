package com.es.financial.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.es.employee.vo.Employee;
import com.es.financial.form.PosForm;
import com.es.management.vo.Discount;
import com.es.movie.vo.MovieTranslation;
import com.es.pos.vo.Pos;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

public interface CalculationService {
	
	List<Pos> searchDateByPosId(Date date);
	List<PosLoginHistory> searchDateByEmployeeId(Date date);
	PosForm searchTicket(int id);
	List<PosForm> searchTicket2(int id);
	List<TicketReceipt> searchReceipts(PosForm posForm);
	List<Discount> searchRceiptsIdByDiscountInfo(int id);
}
