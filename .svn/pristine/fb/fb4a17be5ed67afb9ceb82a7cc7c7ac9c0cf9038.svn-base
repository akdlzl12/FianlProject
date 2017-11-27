package com.es.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.employee.mapper.EmployeeMapper;
import com.es.employee.vo.Employee;
import com.es.management.mapper.TicketSelectMapper;
import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.TicketReceipt;

@Service
public class TicketRePrintImpl implements TicketRePrintService{

	@Autowired
	private TicketSelectMapper ticketSelectMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Override
	public List<TicketReceipt> getRidSelect(String rid) {
		
		return ticketSelectMapper.getRidSelect(rid);
	}
	
	@Override
	public TicketReceipt getRidDetailSelect(TicketReceipt ticketReceipt) {
		// 티켓영수증번호 변수 생성
		int customerId = ticketReceipt.getId();
		
		// 티켓영수증번호(id)를 이용해서 디테일한 값 불러오는 매퍼
		ticketReceipt = ticketMapper.getRidDetailSelect(customerId);
		System.out.println(ticketReceipt.getPos().getId());
		System.out.println(ticketReceipt.getPurchaseDate());
		// 포스번호와 구입날짜를 비교해서 값을 불러오는 매퍼
		PosLoginHistory posLoginHistory = ticketMapper.getFosAndDateSelect(ticketReceipt);
		int employeeId = posLoginHistory.getEmployee().getId();
		// 사원번호를 비교해서 사원이름을 알아내는 매퍼
		Employee employee = employeeMapper.read(employeeId);
		
		// 티켓영수증객체에 임플로이객체 삽입
		ticketReceipt.setEmployee(employee);
		
		return ticketReceipt;
	}
	
	
}
