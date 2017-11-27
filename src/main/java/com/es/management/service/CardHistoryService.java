package com.es.management.service;

import java.util.List;

import com.es.pos.vo.TicketReceipt;

public interface CardHistoryService {

	List<TicketReceipt> getCardSelect(String creditNo);
	TicketReceipt getCardDetailSelect(int id);
}
