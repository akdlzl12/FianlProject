package com.es.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.employee.mapper.EmployeeMapper;
import com.es.employee.vo.Employee;
import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.TicketReceipt;

@Service
public class TicketRePrintImpl implements TicketRePrintService{

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Override
	public List<TicketReceipt> getRidSelect(String rid) {
		
		return ticketMapper.getRidSelect(rid);
	}
	
	@Override
	public TicketReceipt getRidDetailSelect(TicketReceipt ticketReceipt) {
		// 티켓영수증번호 변수 생성
		String Rid = ticketReceipt.getRid();
		
		// 티켓영수증번호(id)를 이용해서 디테일한 값 불러오는 매퍼
		ticketReceipt = ticketMapper.getRidSelect(Rid).get(0);
		System.out.println(ticketReceipt.getPos().getId());
		System.out.println(ticketReceipt.getPurchaseDate());
		// 포스번호와 구입날짜를 비교해서 값을 불러오는 매퍼
		PosLoginHistory posLoginHistory = ticketMapper.getFosAndDateSelect(ticketReceipt);
		if(posLoginHistory== null)
			System.out.println("pos 가 null");
		else if (posLoginHistory.getEmployee() == null)
			System.out.println("employee 가 null");
		int employeeId = posLoginHistory.getEmployee().getId();
		System.out.println("impl" + employeeId);
		// 사원번호를 비교해서 사원이름을 알아내는 매퍼
		Employee employee = employeeMapper.read(employeeId);
		
		// 티켓영수증객체에 임플로이객체 삽입
		ticketReceipt.setEmployee(employee);
		
		return ticketReceipt;
	}
	
	@Override
	public void updatePrint(TicketReceipt ticketReceipt) {
		ticketMapper.updateReceipt(ticketReceipt);
	}
	
	
}
