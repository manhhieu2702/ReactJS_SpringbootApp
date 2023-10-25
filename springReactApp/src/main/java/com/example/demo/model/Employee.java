package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tbl_employeee")
public class Employee {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_epl",columnDefinition = "INT(6)", nullable=false)
	  private Long id;
	  
	  @Column(name = "name_epl", nullable=false,length=200)
	  private String name;
	  
	  @Column(name = "address_epl", nullable=false,length=200)
	  private String address;
	  
	  @Column(name = "phone_epl", nullable=false,length=200)
	  private String phone;
	  
	  @Column(name = "email_epl", nullable=false, length=200)
	  private String email;
	  
	  @Column(name = "age_epl", nullable=false)
	  private int age;
	  
	  @Column(name = "department_epl", nullable=false,length=200)
	  private String department;
	  
	  @Column(name = "start_date_epl", nullable=false)
	  private Date joinDate;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", age=" + age + ", department=" + department + ", joinDate=" + joinDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Employee() {
		super();
	}

	public Employee(Long id, String name, String address, String phone, String email, int age, String department,
			Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.department = department;
		this.joinDate = joinDate;
	}

	
	  
	  
}
