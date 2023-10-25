package com.example.demo.dto;

import java.sql.Date;

public class EmployeeDTO {
    private String name;

    private String email;

    private String address;

    private int age;

    private String phone;

    private String department;

    private Date startDate;

    private Date endDate;

    private int pageNum;

    private int pageSize;
	
	public EmployeeDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public EmployeeDTO(String name, String email, String address, int age, String phone, String department,
			Date startDate, Date endDate, int pageNum, int pageSize) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
		this.phone = phone;
		this.department = department;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", email=" + email + ", address=" + address + ", age=" + age + ", phone="
				+ phone + ", department=" + department + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
	
	
    
    
}
