package com.techpalle.swagger.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpalle.swagger.Entity.Employee;
import com.techpalle.swagger.Repository.EmployeeRepository;

@Service
public class EmployeeService 
{
   private final EmployeeRepository employeeRepository;
   
   @Autowired
   public EmployeeService(EmployeeRepository employeeRepository)
   {
	   this.employeeRepository=employeeRepository;
   }
   //save the employee details
   public Employee saveEmployee(Employee e)
   {
	   return employeeRepository.save(e);
   }
   //Read all the details from the employee details
   public List<Employee> getAllDetails()
   {
	  return employeeRepository.findAll();
	}
   //update the employee data by eid
   public Employee updateEmp(int eid,Employee employee)
   {
	   Optional<Employee> existingEmployee= employeeRepository.findById(eid);
	   if(existingEmployee.isPresent()==true)
	   {
		   Employee emp=existingEmployee.get();
		   emp.setEid(employee.getEid());
		   emp.setName(employee.getName());
		   emp.setEmail(employee.getEmail());
		   emp.setSalary(employee.getSalary());
		   return employeeRepository.save(emp);
	   }
	   else
	   {
		   throw new RuntimeException("product not available");
	   }
   }
   //delete data by eid
   public void deleteEmployee(int eid)
   {
	   employeeRepository.deleteById(eid);
   }
} 
