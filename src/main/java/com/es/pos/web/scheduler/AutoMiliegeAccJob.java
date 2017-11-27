package com.es.pos.web.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.es.management.mapper.CustomerMapper;
import com.es.management.vo.Customer;
import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.TicketReceipt;

@Component("pointAccJob")
public class AutoMiliegeAccJob {

	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	public void accumulatePoint() {
		System.out.println(1);
		List<TicketReceipt> receiptList = ticketMapper.getEndedReceiptAtYesterdayByDate(new Date());
		if(receiptList.size() > 0) {
			System.out.println(receiptList.size());
			for(TicketReceipt receipt : receiptList) {
				System.out.println(receipt.getId());
				int accPoint = (int) Math.ceil((receipt.getPrice() - receipt.getDiscountedPrice()) * 0.05);
				
				Customer customer = receipt.getCustomer();
				customer.setMiliege(customer.getMiliege() + accPoint);
				
				customerMapper.updateCustomerInfo(customer);
			}
		}
	}
}
