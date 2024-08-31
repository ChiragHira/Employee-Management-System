package com.ChiragHira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChiragHira.Entity.Employee;
import com.ChiragHira.Repository.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public void create(Employee emp) {
		employeeRepo.save(emp);
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

}
