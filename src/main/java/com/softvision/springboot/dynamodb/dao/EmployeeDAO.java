package com.softvision.springboot.dynamodb.dao;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.softvision.springboot.dynamodb.entity.Employee;

/**
 * @author arun.p
 * The Interface EmployeeDAO.
 *
 */
@EnableScan
public interface EmployeeDAO extends CrudRepository<Employee, String>{
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product catalog
	 */
	Employee findById(String id);
	
	/** returns all products
	 */
	List<Employee> findAll();
	

}
