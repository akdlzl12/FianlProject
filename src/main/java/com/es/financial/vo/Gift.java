package com.es.financial.vo;

import java.util.Date;

import com.es.management.vo.CustomerRank;

public class Gift {
	
	private String type;
	private Integer id;
	private String distributeType;
	private Date distributUntil;
	private String name;
	private String reason;
	private CustomerRank customerRank;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDistributUntil() {
		return distributUntil;
	}
	public void setDistributUntil(Date distributUntil) {
		this.distributUntil = distributUntil;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDistributeType() {
		return distributeType;
	}
	public void setDistributeType(String distributeType) {
		this.distributeType = distributeType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public CustomerRank getCustomerRank() {
		return customerRank;
	}
	public void setCustomerRank(CustomerRank customerRank) {
		this.customerRank = customerRank;
	}
	@Override
	public String toString() {
		return "Gift [type=" + type + ", id=" + id + ", distributeType=" + distributeType + ", distributUntil="
				+ distributUntil + ", name=" + name + ", reason=" + reason + ", customerRank=" + customerRank + "]";
	}
	
	
}
