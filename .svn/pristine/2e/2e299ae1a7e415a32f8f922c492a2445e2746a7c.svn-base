package com.es.employee.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeForm {
	
	@NotEmpty()
	@Length(min=2, max=10)
	private String name;
	@NotEmpty()
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birth;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String jobType;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hiredAt;
	@NotEmpty
	private String address;
	@Pattern(regexp="^\\d{3,}-\\d{3,}-\\d{4,}$")
	@NotEmpty
	private String accountNo;
	
	private Integer hourlyPay;
	
	public Integer getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(Integer hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	@Override
	public String toString() {
		return "EmployeeForm [name=" + name + ", gender=" + gender + ", birth=" + birth + ", phone=" + phone
				+ ", jobType=" + jobType + ", hiredAt=" + hiredAt + ", address=" + address + ", accountNo=" + accountNo
				+ ", hourlyPay=" + hourlyPay + "]";
	}
	
}
