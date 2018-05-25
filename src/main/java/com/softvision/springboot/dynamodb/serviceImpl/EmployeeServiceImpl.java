package com.softvision.springboot.dynamodb.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.springboot.dynamodb.dao.EmployeeDAO;
import com.softvision.springboot.dynamodb.entity.Employee;
import com.softvision.springboot.dynamodb.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCatalogServiceImpl.
 *
 * @author arun.p
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** The product catelog dao. */
	@Autowired
	private EmployeeDAO employeeDao;

	/**
	 * fins all the eemployee
	 * 
	 * @return List of employees
	 */
	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

	/**
	 * find employee by id
	 * 
	 * @param id
	 */
	@Override
	public Employee findEmployeeById(String id) {
		return employeeDao.findById(id);
	}

	/**
	 * deletes employee by id
	 * 
	 * @param id
	 */
	@Override
	public void deleteEmployeeById(String id) {
		employeeDao.delete(id);
	}

	/**
	 * updates employee
	 * 
	 * @param employee,id
	 */
	@Override
	public Employee updateEmployee(Employee employee, String id) {

		Employee newEmployee = employeeDao.findById(id);

		if (newEmployee == null) {
			return null;
		}

		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setIsActive(employee.getIsActive());
		newEmployee.setOfficeCode(employee.getOfficeCode());
		newEmployee.setEmployeePhone(employee.getEmployeePhone());
		newEmployee.setSalary(employee.getSalary());

		return employeeDao.save(newEmployee);
	}

	/**
	 * save new product
	 * 
	 * @param products
	 *            return list of ProductCatelog
	 */
	@Override
	public List<Employee> saveNewEmployee(List<Employee> employee) {
		return (List<Employee>) employeeDao.save(employee);
	}

}
