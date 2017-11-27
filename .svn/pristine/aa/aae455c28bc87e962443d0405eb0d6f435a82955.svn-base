package com.es.financial.vo;

import java.util.Date;

import com.es.management.vo.Customer;
import com.es.util.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class GiftCustomer {

	private Integer id;
	@JsonSerialize(using=DateSerializer.class)
	private Date receivedAt;
	private Customer customer;
	private Integer received;
	private Gift gift;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
	public Integer getReceived() {
		return received;
	}
	public void setReceived(Integer received) {
		this.received = received;
	}
}
