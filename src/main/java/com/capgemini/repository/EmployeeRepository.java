package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Derived Method Based on Data Members
	Employee findByEmail(String email);
	List<Employee> findByMobile(String mobile);
	Employee findByEmailAndPassword(String email, String password);
	
	
	// Native SQL Query
	@Query(value = "SELECT * from employee", nativeQuery = true)
	List<Employee> customFindAllEmployees();
	
	@Query(value= "SELECT * from employee WHERE email=?1 AND password=?2", nativeQuery = true)
	Employee customFindByEmailAndPassword(String email, String password);
	
	
	// JPQL
}
