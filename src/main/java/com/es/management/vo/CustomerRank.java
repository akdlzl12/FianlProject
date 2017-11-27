package com.es.management.vo;

public class CustomerRank {

	private Integer id;
	private String type;
	private Integer priority;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "CustomerRank [id=" + id + ", type=" + type + ", priority=" + priority + "]";
	}
	
}
