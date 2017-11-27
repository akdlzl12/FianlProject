package com.es.employee.vo;

public class EmployeeManagement {

	private Integer id;
	private String detail;
	private Integer deleted;
	private String reason;
	private EmployeeTimetable timetable;
	private Integer timetableId;
	private int employeeId;
	private boolean isRejected;
	@Override
	public String toString() {
		return "EmployeeManagement [id=" + id + ", detail=" + detail + ", deleted=" + deleted + ", reason=" + reason
				+ ", timetable=" + timetable + "]";
	}
	
	public Integer getTimetableId() {
		return timetableId;
	}

	public void setTimetableId(Integer timetableId) {
		this.timetableId = timetableId;
	}

	public boolean isRejected() {
		return isRejected;
	}

	public void setRejected(boolean isRejected) {
		this.isRejected = isRejected;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public EmployeeTimetable getTimetable() {
		return timetable;
	}
	public void setTimetable(EmployeeTimetable timetable) {
		this.timetable = timetable;
	}
	
	
}
