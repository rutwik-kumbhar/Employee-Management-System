package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AppController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		return new ResponseEntity<Employee>( employeeService.getEmployeeBYId(id),HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PutMapping("/employee/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id ,  @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Integer id){
		return new ResponseEntity<Map<String, Boolean>>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}
	

}
