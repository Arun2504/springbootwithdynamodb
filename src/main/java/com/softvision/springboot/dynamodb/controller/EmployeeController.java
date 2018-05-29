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

import com.softvision.springboot.dynamodb.common.ServiceConstants;
import com.softvision.springboot.dynamodb.entity.Employee;
import com.softvision.springboot.dynamodb.service.EmployeeService;

/**
 * @author arun.p
 */
@RestController
@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEE_SERVICE)
public class EmployeeController {

    /**
     * The employee service.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Find all.
     *
     * @return the list
     */
    @RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEES, method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the product catalog
     */
    @RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEE + ServiceConstants.BACK_SLASH
            + ServiceConstants.OPENING_CURLY_BRACKET + ServiceConstants.ID
            + ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.GET)
    public @ResponseBody
    Employee findById(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEE + ServiceConstants.BACK_SLASH
            + ServiceConstants.DELETE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
            + ServiceConstants.ID + ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    /**
     * Adds the catalog entry.
     *
     * @param employees the employees
     * @return the response entity
     */
    @RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEE + ServiceConstants.BACK_SLASH
            + ServiceConstants.ADD, method = RequestMethod.POST, headers = ServiceConstants.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody List<Employee> employees) {
        return new ResponseEntity<List<Employee>>(employeeService.saveNewEmployee(employees), HttpStatus.CREATED);
    }

    /**
     * Update catalog entry.
     *
     * @param id      the id
     * @param product the product
     * @return the response entity
     */
    @RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.EMPLOYEE + ServiceConstants.BACK_SLASH
            + ServiceConstants.UPDATE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
            + ServiceConstants.ID
            + ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.PUT, headers = ServiceConstants.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {

        Employee newEmployee = employeeService.updateEmployee(employee, id);
        if (null == newEmployee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }
}
