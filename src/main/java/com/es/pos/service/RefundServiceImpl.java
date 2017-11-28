package com.es.pos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.financial.vo.CouponCustomer;
import com.es.management.mapper.CustomerMapper;
import com.es.management.vo.Customer;
import com.es.movie.mapper.MovieMapper;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.DiscountTicket;
import com.es.pos.vo.Ticket;
import com.es.pos.vo.TicketReceipt;

@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public TicketReceipt findReceiptByRid(String rid) {
		return ticketMapper.getRidSelect(rid).get(0);
	}
	
	@Override
	public Map<String, Object> findReceiptInfo(String rid) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<TicketReceipt> receipts = ticketMapper.getRidSelect(rid);
		if(receipts.size() != 0) {
			TicketReceipt receipt = receipts.get(0); 
			map.put("receiptInfo", receipt);
			
			List<Ticket> tickets = ticketMapper.getTicketByReceiptId(receipt.getId());
			map.put("ticketList", tickets);
			
			List<DiscountTicket> discounts = ticketMapper.getDiscountsByReceiptId(receipt.getId());
			map.put("discountList", discounts);
			
			List<CouponCustomer> coupones = ticketMapper.getCouponesByReceiptId(receipt.getId());
			map.put("couponList", coupones);
			
			MovieTimetable timetable = movieMapper.getMovieTimetableById(tickets.get(0).getMovieTimetable().getId());
			map.put("movieTime", timetable);

			MovieTranslation movie = movieMapper.getMovieTranslateByScreenMovieId(timetable.getScreenMovie().getId());
			map.put("movie", movie);
		} else {
			map.put("receiptInfo", null);
		}
		
		return map;
	}

	@Override
	public void refundReceipt(TicketReceipt receipt) {
		receipt.setDeleted("Y");
		ticketMapper.updateReceipt(receipt);
		
		Customer customer = receipt.getCustomer();
		Integer miliege = receipt.getMiliege();
		if(customer != null && miliege != null) {
			int customerId = customer.getId();
			
			customer = customerMapper.getDetailCustomer(customerId);
			customer.setMiliege(customer.getMiliege() + miliege);
			customerMapper.updateCustomerInfo(customer);
		}
		
		List<CouponCustomer> coupones = ticketMapper.getCouponesByReceiptId(receipt.getId());
		for(CouponCustomer coupon : coupones) {
			coupon.setUsed(0);
			coupon.getTicketReceipt().setId(null);
			customerMapper.updateCouponCustomerInfo(coupon);
		}
		
	}
}
