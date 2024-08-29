package com.techpalle.swagger.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpalle.swagger.Entity.Employee;
import com.techpalle.swagger.Service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/swag")
public class EmployeeController 
{
   private final EmployeeService employeeService;
   
   @Autowired
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	//insert data into employee table
	@PostMapping("/insert")
	public ResponseEntity<Employee> savetData(@Valid @RequestBody Employee e)
	{
		Employee emp=employeeService.saveEmployee(e);
		return ResponseEntity.ok(emp);
		
	}
	//read the data
	@GetMapping("/read")
	public List<Employee> getAllData()
	{
		return employeeService.getAllDetails();
	}
	//update the data
	@PutMapping("/update/{eid}")
	public Employee updateEmpData( @PathVariable int eid, @Valid @RequestBody Employee e)
	{
		return employeeService.updateEmp(eid,e);
	}
	//delete the data
	@DeleteMapping("/delete/{eid}")
	public void deleteEmpData(@PathVariable int eid)
	{
		employeeService.deleteEmployee(eid);
	}
		
	
}
