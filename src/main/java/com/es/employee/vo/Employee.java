package com.es.employee.vo;

import java.util.Date;
import java.util.List;

import com.es.financial.vo.DailyReport;

public class Employee {

	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Integer hourlyPay;
	private String gender;
	private String accountNo;
	private String jobType;
	private Date hiredAt;
	private Date dismissedAt;
	private Date birth;
	
	private int salaryPerMonth;
	private int mismatchPerMonth;
	private int workingHoursPerMonth;
	
	private List<EmployeeTimetable> timetables;
	private List<EmployeeManagement> managements;
	private List<EmployeeManagement> theifRecords;
	private List<DailyReport> mismatches;
	private int salary;
	
	private List<JobHistory> jobHistory;
	private List<PayHistory> payHistory;
	
	
	public List<DailyReport> getMismatches() {
		return mismatches;
	}
	public void setMismatches(List<DailyReport> mismatches) {
		this.mismatches = mismatches;
	}
	public List<EmployeeManagement> getTheifRecords() {
		return theifRecords;
	}
	public void setTheifRecords(List<EmployeeManagement> theifRecords) {
		this.theifRecords = theifRecords;
	}
	
	public int getWorkingHoursPerMonth() {
		return workingHoursPerMonth;
	}
	public void setWorkingHoursPerMonth(int workingHoursPerMonth) {
		this.workingHoursPerMonth = workingHoursPerMonth;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<JobHistory> getJobHistory() {
		return jobHistory;
	}
	public void setJobHistory(List<JobHistory> jobHistory) {
		this.jobHistory = jobHistory;
	}
	public List<PayHistory> getPayHistory() {
		return payHistory;
	}
	public void setPayHistory(List<PayHistory> payHistory) {
		this.payHistory = payHistory;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(Integer hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public Date getHiredAt() {
		return hiredAt;
	}
	public void setHiredAt(Date hiredAt) {
		this.hiredAt = hiredAt;
	}
	public Date getDismissedAt() {
		return dismissedAt;
	}
	public void setDismissedAt(Date dismissedAt) {
		this.dismissedAt = dismissedAt;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public int getSalaryPerMonth() {
		return salaryPerMonth;
	}
	public void setSalaryPerMonth(int salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	public int getMismatchPerMonth() {
		return mismatchPerMonth;
	}
	public void setMismatchPerMonth(int mismatchPerMonth) {
		this.mismatchPerMonth = mismatchPerMonth;
	}
	public List<EmployeeTimetable> getTimetables() {
		return timetables;
	}
	public void setTimetables(List<EmployeeTimetable> timetables) {
		this.timetables = timetables;
	}
	public List<EmployeeManagement> getManagements() {
		return managements;
	}
	public void setManagements(List<EmployeeManagement> managements) {
		this.managements = managements;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", hourlyPay="
				+ hourlyPay + ", gender=" + gender + ", accountNo=" + accountNo + ", jobType=" + jobType + ", hiredAt="
				+ hiredAt + ", dismissedAt=" + dismissedAt + ", birth=" + birth + ", salaryPerMonth=" + salaryPerMonth
				+ ", mismatchPerMonth=" + mismatchPerMonth + ", workingHoursPerMonth=" + workingHoursPerMonth
				+ ", timetables=" + timetables + ", managements=" + managements + ", theifRecords=" + theifRecords
				+ ", mismatches=" + mismatches + ", salary=" + salary + ", jobHistory=" + jobHistory + ", payHistory="
				+ payHistory + "]";
	}
	
	
}
