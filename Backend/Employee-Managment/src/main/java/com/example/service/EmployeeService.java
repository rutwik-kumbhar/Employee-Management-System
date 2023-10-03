package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.exception.NoEmployeeFound;
import com.example.model.Employee;

public interface EmployeeService {
	
	/**
	 * This method for add employee 
	 * @param emp
	 * @return Employee Object
	 */
	 public Employee addEmployee(Employee emp);
	 
	 
	 /**
	  * This method for get employee by id
	  * @param id
	  * @return Employee Object
	  */
	 public Employee getEmployeeBYId(Integer id) throws NoEmployeeFound;
	 
	 
	 /** This method get all employees
	  * 
	  * @return
	  */
	 public List<Employee> getAllEmployee();
	 
	 
	 
	 /**
	  * Thid method for  update existing employee 
	  * @param emp
	  * @return
	  */
	 public Employee updateEmployee(Integer id, Employee emp);
	 
	 /**
	  * This method for delete employee
	  * @param id
	  * @return Employee
	  */
	 public Map<String,Boolean> deleteEmployee(Integer id);

}
