package com.es.movie.vo;

import java.util.Date;

import com.es.util.DateSerializer;
import com.es.util.TimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SeatInfo {
	
	private int id;
	private String seatname;
	private String rid;
	private String username;
	private String name;
	private String purchaseType;
	@JsonSerialize(using=DateSerializer.class)
	private Date purchaseDate;
	@JsonSerialize(using=TimeSerializer.class)
	private Date startedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getSeatname() {
		return seatname;
	}
	public void setSeatname(String seatname) {
		this.seatname = seatname;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	@Override
	public String toString() {
		return "SeatInfo [id=" + id + ", seatname=" + seatname + ", rid=" + rid + ", username=" + username + ", name="
				+ name + ", purchaseType=" + purchaseType + ", purchaseDate=" + purchaseDate + ", startedAt="
				+ startedAt + "]";
	}
	
	
	
	
	
}
