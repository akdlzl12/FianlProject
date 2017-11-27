package com.es.pos.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.financial.vo.CouponCustomer;
import com.es.management.mapper.CustomerMapper;
import com.es.management.mapper.DiscountMapper;
import com.es.management.vo.Customer;
import com.es.management.vo.Discount;
import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.DiscountTicket;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private DiscountMapper discountMapper;
	
	@Override
	public void sellMovieTicket(List<Ticket> tickets, List<Discount> discounts, List<CouponCustomer> coupones, TicketReceipt receipt) {
		Date now = new Date();
		String dateNo = new SimpleDateFormat("yyyy-MMdd").format(now);
		
		String time1 = String.valueOf(now.getTime()).substring(5, 9);
		String time2 = String.valueOf(now.getTime()).substring(9, 13);
		
		String rid = dateNo + "-" + time1 + "-" + time2;
		
		int receiptSeq = ticketMapper.getReceiptSeq();
		receipt.setId(receiptSeq);
		receipt.setRid(rid);
		Customer customer = receipt.getCustomer();
		if(customer != null) {
			
			Integer miliege = customer.getMiliege();
			if(miliege != null) {
				receipt.setMiliege(miliege);			
			}
		}
		
		ticketMapper.addTicketReceipt(receipt);
		
		for(Ticket forTicket : tickets) {
			forTicket.setTicketReceipt(receipt);
			ticketMapper.addTicket(forTicket);
		}
		
		for(Discount forDiscount : discounts) {
			DiscountTicket discountTicket = new DiscountTicket();
			discountTicket.setDiscount(forDiscount);
			discountTicket.setTicketReceipt(receipt);
			
			ticketMapper.addDiscountTicket(discountTicket);
		}
		
		for(CouponCustomer forCoupon : coupones) {
			forCoupon.setUsed(1);
			forCoupon.setTicketReceipt(receipt);
			
			customerMapper.updateCouponCustomerInfo(forCoupon);
		}
	}
	
	@Override
	public List<Discount> findAllDiscounts() {
		return discountMapper.getAllDiscounts();
	}
	
	@Override
	public Discount findDiscountInfo(int discountId) {
		return discountMapper.getDiscount(discountId).get(0);
	}

	@Override
	public Map<String, Object> findCustomerInfo(Map<String, String> map) {
		Customer customer = customerMapper.getCustomerByNameNPhone(map);
		List<CouponCustomer> couponList =  customerMapper.getCouponesByCustomerId(customer.getId());
		
		Map<String, Object> customerInfo = new HashMap<String, Object>();
		
		customerInfo.put("customer", customer);
		customerInfo.put("couponList", couponList);
		
		return customerInfo;
	}
	
	@Override
	public Customer findCustomerInfo(int customerId) {
		return customerMapper.getDetailCustomer(customerId);
	}
	
	@Override
	public CouponCustomer findCouponOfCustomer(int customerId) {
		return customerMapper.getCouponCustomerById(customerId);
	}

	@Override
	public void changeCustomerMiliege(Customer customer) {
		Customer checkedCustomer = customerMapper.getDetailCustomer(customer.getId());
		int miliege = customer.getMiliege();
		checkedCustomer.setMiliege(checkedCustomer.getMiliege() - miliege);
		
		customerMapper.updateCustomerInfo(checkedCustomer);
	}
}