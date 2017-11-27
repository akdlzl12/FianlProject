package com.es.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.pos.mapper.TicketMapper;
import com.es.pos.vo.TicketReceipt;

@Service
public class CardHistoryImpl implements CardHistoryService{
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Override
	public List<TicketReceipt> getCardSelect(String creditNo) {
		return ticketMapper.getCardSelect(creditNo);
	}
	
	@Override
	public TicketReceipt getCardDetailSelect(int id) {
		
		return ticketMapper.getCardDetailSelect(id);
	}
}
