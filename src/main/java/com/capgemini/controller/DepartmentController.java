package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Department;
import com.capgemini.entities.Employee;
import com.capgemini.repository.DepartmentRepository;
import com.capgemini.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/")
	public String create(@RequestBody Department department) {
		
		departmentRepository.save(department);
		return "Deparmeent Created";
	}
	
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable int id) {
		
		return departmentRepository.findById(id).get();
	}
	
	// TODO
	@PutMapping("/{departmentId}/employee/{employeeId}")
	public String assignDepartmeentToEmployee(@PathVariable int departmentId, @PathVariable int employeeId) {
		
		Department department =  departmentRepository.findById(departmentId).get();
		Employee employee =  employeeRepository.findById(employeeId).get();
		
		department.getEmployees().add(employee);
		
		// updated.
		departmentRepository.save(department);
		return "Successs";
	}
}
