package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.NoEmployeeFound;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeBYId(Integer id) throws NoEmployeeFound {
		// TODO Auto-generated method stub

		Optional<Employee> optional = employeeRepository.findById(id);

		Employee employee = optional.orElseThrow(() -> new NoEmployeeFound("Oops Employee Not Found Give id" + id));

		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Integer id, Employee emp) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee oldEmployee = optional
				.orElseThrow(() -> new NoEmployeeFound("Oops Employee Not Found Give id " + emp.getId()));

		oldEmployee.setFirstName(emp.getFirstName());
		oldEmployee.setLastName(emp.getLastName());
		oldEmployee.setDesignation(emp.getDesignation());
		oldEmployee.setEmail(emp.getEmail());
		oldEmployee.setSalary(emp.getSalary());

		return employeeRepository.save(oldEmployee);
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.orElseThrow(() -> new NoEmployeeFound("Oops Employee Not Found Give id" + id));

		employeeRepository.deleteById(id);
		Map<String, Boolean> map = new HashMap<>();
		map.put("isDeleted", true);
		return map;
	}

}
