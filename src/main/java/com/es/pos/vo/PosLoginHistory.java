package com.es.pos.vo;

import java.util.Date;

import com.es.employee.vo.Employee;
import com.es.util.TimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PosLoginHistory {

	private Integer id;
	@JsonSerialize(using=TimeSerializer.class)
	private Date signedIn;
	@JsonSerialize(using=TimeSerializer.class)
	private Date signedOut;
	private Employee employee;
	private Pos pos;
	
	@JsonSerialize(using=TimeSerializer.class)
	private Date time;
	
	
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getSignedIn() {
		return signedIn;
	}
	public void setSignedIn(Date signedIn) {
		this.signedIn = signedIn;
	}
	public Date getSignedOut() {
		return signedOut;
	}
	public void setSignedOut(Date signedOut) {
		this.signedOut = signedOut;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Pos getPos() {
		return pos;
	}
	public void setPos(Pos pos) {
		this.pos = pos;
	}
}
