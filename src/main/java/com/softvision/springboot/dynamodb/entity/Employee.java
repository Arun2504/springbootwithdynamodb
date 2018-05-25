package com.softvision.springboot.dynamodb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.softvision.springboot.dynamodb.common.ServiceConstants;

/**
 * The Class Employee.
 *
 * @author arun.p
 */
@DynamoDBTable(tableName = "Employee")
@JsonPropertyOrder({ "id", "employeeName", "employeePhone", "salary", "officeCode", "isActive" })
@JsonIgnoreProperties(value = { "firstName", "lastName" })
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9177511508110726308L;

	/** The id. */
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String id;

	/** The first name. */
	// @JsonIgnore
	@DynamoDBAttribute
	@NotNull
	private String firstName;

	/** The last name. */
	// @JsonIgnore
	@DynamoDBAttribute
	@NotNull
	private String lastName;

	/** The employee phone. */
	@DynamoDBAttribute
	private BigInteger employeePhone;

	/** The is active. */
	@DynamoDBAttribute
	@NotNull
	private Boolean isActive;

	/** The salary. */
	@DynamoDBAttribute
	@NotNull
	private BigDecimal salary;

	/** The office code. */
	@DynamoDBAttribute
	private String officeCode;

	/** The employee name. */
	private String employeeName;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param employeePhone
	 *            the employee phone
	 * @param isActive
	 *            the is active
	 * @param salary
	 *            the salary
	 * @param officeCode
	 *            the office code
	 */
	public Employee(String firstName, String lastName, BigInteger employeePhone, Boolean isActive, BigDecimal salary,
			String officeCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeePhone = employeePhone;
		this.isActive = isActive;
		this.salary = salary;
		this.officeCode = officeCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the employee phone.
	 *
	 * @return the employee phone
	 */
	public BigInteger getEmployeePhone() {
		return employeePhone;
	}

	/**
	 * Sets the employee phone.
	 *
	 * @param employeePhone
	 *            the new employee phone
	 */
	public void setEmployeePhone(BigInteger employeePhone) {
		this.employeePhone = employeePhone;
	}

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive
	 *            the new checks if is active
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary
	 *            the new salary
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * Gets the office code.
	 *
	 * @return the office code
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * Sets the office code.
	 *
	 * @param officeCode
	 *            the new office code
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getEmployeeName() {
		return getFirstName() + ServiceConstants.BLANK_SPACE + getLastName();
	}

}
