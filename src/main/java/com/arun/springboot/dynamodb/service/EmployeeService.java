package com.arun.springboot.dynamodb.service;

import java.util.List;

import com.arun.springboot.dynamodb.entity.Employee;

/**
 * @author arun.p
 *
 */
public interface EmployeeService {

	/**
	 * @return all products
	 */
	List<Employee> findAllEmployees();

	/**
	 * @param id
	 * @return ProductCatalog
	 */
	Employee findEmployeeById(String id);

	/**
	 * @param id
	 */
	void deleteEmployeeById(String id);

	/**
	 * @param products
	 * @param id 
	 * @return ProductCatalog
	 */
	List<Employee> saveNewEmployee(List<Employee> employees);

	/**
	 * @param product
	 * @param id
	 * @return Employee
	 */
	Employee updateEmployee(Employee employee, String id);

}
