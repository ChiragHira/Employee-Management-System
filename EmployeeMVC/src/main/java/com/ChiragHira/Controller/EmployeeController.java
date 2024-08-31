package com.ChiragHira.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ChiragHira.Entity.Employee;
import com.ChiragHira.Services.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServices empServices; 

	@GetMapping("/getForm")
	public ModelAndView getRegisterationForm() {
		String view = "Registration";
		Map<String,Object> model = new HashMap<>();
		
		//Employee emp = new Employee();
		//emp.setId(100);
		//emp.setFirstname("Chirag");
		//emp.setLastname("Hira");
		
		model.put("employeeData", new Employee());
		
		return  new ModelAndView(view,model);
		
	}
	
	@PostMapping("/getForm")
	public ModelAndView submitForm(Employee emp) {
		
		empServices.create(emp);
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/submit");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/submit")
	public ModelAndView submission() {
		return new ModelAndView("submit");
	}
	
	@GetMapping("/getAll")
	public ModelAndView getAll() {
		String view = "AllEmployee";
		Map<String,Object>model = new HashMap<>();
		List<Employee> employees = empServices.getAllEmployee(); 
		
		model.put("AllEmployee", employees);
		
		return new ModelAndView(view,model);
	}
	
	
	
}
