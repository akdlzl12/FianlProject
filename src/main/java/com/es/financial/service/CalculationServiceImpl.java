package com.es.financial.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.employee.vo.Employee;
import com.es.financial.form.PosForm;
import com.es.management.vo.Discount;
import com.es.movie.vo.MovieTranslation;
import com.es.pos.mapper.PosMapper;
import com.es.pos.vo.Pos;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

@Service
public class CalculationServiceImpl implements CalculationService {

	@Autowired
	private PosMapper posMapper;

	@Override
	public List<Pos> searchDateByPosId(Date date) {
		return posMapper.searchDateByPosId(date);
	}

	@Override
	public List<PosLoginHistory> searchDateByEmployeeId(Date date) {
		return posMapper.searchDateByEmployeeId(date);
	}

	@Override
	public PosForm searchTicket(int id) {
		return posMapper.searchTicket(id);
	}

	@Override
	public List<TicketReceipt> searchReceipts(PosForm posForm) {
		return posMapper.searchReceipts(posForm);
	}

	@Override
	public List<Discount> searchRceiptsIdByDiscountInfo(int id) {
		return posMapper.searchRceiptsIdByDiscountInfo(id);
	}

	@Override
	public List<PosForm> searchTicket2(int id) {
		return posMapper.searchTicket2(id);
	}

	
}
