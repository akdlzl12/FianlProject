package com.es.management.vo;

import java.util.Date;

public class Discount {

	private Integer id;
	private String name;
	private String detail;
	private Integer discountPercent;
	private Date startedDate;
	private Date endDate;
	private String discountType;
	private String discountPrice;
	private CustomerType customerType;
	
	private String movieName;
	private Integer ticketPrice;
	
	
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Date getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	@Override
	public String toString() {
		return "Discount [id=" + id + ", name=" + name + ", detail=" + detail + ", discountPercent=" + discountPercent
				+ ", startedDate=" + startedDate + ", endDate=" + endDate + ", discountType=" + discountType
				+ ", discountPrice=" + discountPrice + ", customerType=" + customerType + ", movieName=" + movieName
				+ ", ticketPrice=" + ticketPrice + "]";
	}
	
	
	
	
	
}
