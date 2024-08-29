package com.techpalle.swagger.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
   private int eid;
	
	@NotEmpty(message="mandtory to give the employee name")
   private String name;
	
	@Email(message="please check the email....that' not proper")
   private String email;
	
	@Min(value=5000, message="the value must be greater than 5000")
	@Max(value=15000,message="the value must be less than 15000")
   private int salary;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
