package com.techpalle.swagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpalle.swagger.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

}
