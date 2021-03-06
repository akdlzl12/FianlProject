package com.es.financial.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.employee.vo.Employee;
import com.es.financial.form.PosForm;
import com.es.financial.service.CalculationService;
import com.es.management.vo.Discount;
import com.es.movie.vo.MovieTranslation;
import com.es.pos.vo.Pos;
import com.es.pos.vo.PosLoginHistory;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

@RestController
public class CalculationAjaxController {

	@Autowired
	CalculationService calculationService;
	
	// 포스조회
	@RequestMapping("/searchPosNo.esc")
	@ResponseBody
	public List<Pos> searchDateByPosId(Date date){
		return calculationService.searchDateByPosId(date);
	}
	
	//판매자 조회
	@RequestMapping("/searchSeller.esc")
	@ResponseBody
	public List<PosLoginHistory> searchDateByEmployeeId(Date date) {
		
		return calculationService.searchDateByEmployeeId(date);
	}
	
	// 포스정산
	@RequestMapping("/searchReceipts.esc")
	@ResponseBody
	public List<PosForm> searchList(PosForm posForm){
		
		List<TicketReceipt> searchReceipts = calculationService.searchReceipts(posForm);
		List<PosForm> os = new ArrayList<PosForm>();
		
		for( TicketReceipt ticketReceipt : searchReceipts) {
			
			PosForm psForm = calculationService.searchTicket(ticketReceipt.getId());
			
			os.add(psForm);
			
		}
		return os;
	}
	// 단말기정산 상세정보
	@RequestMapping("/searchRceiptsIdByDiscountInfo.esc")
	@ResponseBody
	public List<Discount> searchRceiptsIdByDiscountInfo(PosForm posForm){
		
		PosForm psForm = calculationService.searchTicket(posForm.getId());
		List<Discount> dis = calculationService.searchRceiptsIdByDiscountInfo(posForm.getId());
		System.out.println(dis);
		if(!(dis.equals(null))) {
			for(Discount discount : dis) {

				discount.setMovieName(psForm.getName());
				discount.setTicketPrice(psForm.getPrice());
			}
			return dis;
		} else {
			for(Discount discount : dis) {
				
				discount.setMovieName("");
				discount.setTicketPrice(0);
				
			}	
				/*List<PosForm> poForm = calculationService.searchTicket2(posForm.getId());*/
			return dis;
		}
	}
	
}
