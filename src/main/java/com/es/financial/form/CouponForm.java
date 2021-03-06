package com.es.financial.form;

import java.util.Date;


public class CouponForm {
	
	private String type;
	private String distributeType;
	private Date distributUntil;
	private String reason;
	private String name;
	private Integer customerRank;
	private Date expiredAt;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDistributeType() {
		return distributeType;
	}
	public void setDistributeType(String distributeType) {
		this.distributeType = distributeType;
	}
	public Date getDistributUntil() {
		return distributUntil;
	}
	public void setDistributUntil(Date distributUntil) {
		this.distributUntil = distributUntil;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCustomerRank() {
		return customerRank;
	}
	public void setCustomerRank(Integer customerRank) {
		this.customerRank = customerRank;
	}
	public Date getExpiredAt() {
		return expiredAt;
	}
	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}
	@Override
	public String toString() {
		return "CouponForm [type=" + type + ", distributeType=" + distributeType + ", distributUntil=" + distributUntil
				+ ", reason=" + reason + ", name=" + name + ", customerRank=" + customerRank + ", expiredAt="
				+ expiredAt + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
