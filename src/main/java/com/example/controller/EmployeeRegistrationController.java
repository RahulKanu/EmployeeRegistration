package com.example.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeRegistrationController {
	
	@Value( "${cross.origin.proxy}" )
	private String crossOriginConfig;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@CrossOrigin(origins = "${cross.origin.proxy}")
	@GetMapping(value= "/all")
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@CrossOrigin(origins = "${cross.origin.proxy}")
	@PostMapping(value = "/load")
	public Employee load(@RequestBody final Employee employee) {
		employeeRepository.save(employee);
		return employeeRepository.findById(employee.getId()).get();
	}
	
	@CrossOrigin(origins = "${cross.origin.proxy}")
	@GetMapping(value = "/{id}")
	public Employee findByEmployeeId(@PathVariable final Integer id) throws Exception {
		try{
		return employeeRepository.findById(id).get();
		} catch (NoSuchElementException exception) {
			 new Employee(); 
		}
		return null;
	}


	public void setCrossOriginConfig(String crossOriginConfig) {
		this.crossOriginConfig = crossOriginConfig;
	}

	
	

}
