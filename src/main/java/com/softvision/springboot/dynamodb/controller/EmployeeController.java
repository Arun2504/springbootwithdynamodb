package com.softvision.springboot.dynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.springboot.dynamodb.entity.Employee;
import com.softvision.springboot.dynamodb.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
public class EmployeeController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@RequestMapping(path="/employeeService/employees", method=RequestMethod.GET)
	public @ResponseBody List<Employee> findAll() {
		return employeeService.findAllEmployees();
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product catalog
	 */
	@RequestMapping(path="/employeeService/employee/{id}", method=RequestMethod.GET)
	public @ResponseBody Employee findById(@PathVariable String id) {
		return employeeService.findEmployeeById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@RequestMapping(path="/employeeService/employee/delete/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
	}

	/**
	 * Adds the catalog entry.
	 *
	 * @param employees the employees
	 * @return the response entity
	 */
	@RequestMapping(path="/employeeService/employee/add", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody List<Employee> employees) {
		return new ResponseEntity<List<Employee>> (employeeService.saveNewEmployee(employees),HttpStatus.CREATED);
	}
	
	/**
	 * Update catalog entry.
	 *
	 * @param id the id
	 * @param product the product
	 * @return the response entity
	 */
	@RequestMapping(path="/employeeService/employee/update/{id}", method=RequestMethod.PUT, headers="Accept=application/json")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		
		Employee newEmployee = employeeService.updateEmployee(employee,id);
		if(null == newEmployee) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
	}
}
