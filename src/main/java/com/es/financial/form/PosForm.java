package com.es.financial.form;

import java.util.Date;

import com.es.util.TimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PosForm {
	
	private Integer id;
	private String name;
	private String posName;
	@JsonSerialize(using=TimeSerializer.class)
	private Date time;
	private Integer price;
	private Integer discount;
	
	
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
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "PosForm [id=" + id + ", name=" + name + ", posName=" + posName + ", time=" + time + ", price=" + price
				+ ", discount=" + discount + "]";
	}
	
	

	
}
