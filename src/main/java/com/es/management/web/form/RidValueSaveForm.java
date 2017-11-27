package com.es.management.web.form;

import java.util.Date;

public class RidValueSaveForm {

	private String rid;
	private	Integer id;
	private Integer pos;
	private Date purchaseDate;
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Override
	public String toString() {
		return "RidValueSaveForm [Rid=" + rid + ", id=" + id + ", pos=" + pos + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
	
	
}
