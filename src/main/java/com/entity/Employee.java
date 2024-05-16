package com.entity;

/**
 * This class represents an Employee entity with basic information.
 * It includes two constructors and getter/setter methods for all fields.
 * 
 * @author Jayesh Soni
 * @since 2024-05-07
 */
public class Employee {

	private int id; // Unique identifier for the employee
	private String firstName; // First name of the employee
	private String lastName; // Last name of the employee
	private String email; // Email address of the employee
	private String userName; // Username of the employee
	private String password; // Password of the employee
	private String address; // Address of the employee
	private String mobileNumber; // Mobile number of the employee

	/**
	 * Constructs an Employee object with provided details .
	 * 
	 * @param firstName    The first name of the employee.
	 * @param lastName     The last name of the employee.
	 * @param email        The email address of the employee.
	 * @param userName     The username of the employee.
	 * @param password     The password of the employee.
	 * @param address      The address of the employee.
	 * @param mobileNumber The mobile number of the employee.
	 */
	public Employee(String firstName, String lastName, String email, String userName, String password, String address,
			String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Constructs an Employee object with provided details.
	 * 
	 * @param id           The unique identifier for the employee.
	 * @param firstName    The first name of the employee.
	 * @param lastName     The last name of the employee.
	 * @param email        The email address of the employee.
	 * @param userName     The username of the employee.
	 * @param password     The password of the employee.
	 * @param address      The address of the employee.
	 * @param mobileNumber The mobile number of the employee.
	 */
	public Employee(int id, String firstName, String lastName, String email, String userName, String password,
			String address, String mobileNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	// Getters and setters for the private fields

	/**
	 * Retrieves the ID of the employee.
	 * 
	 * @return The ID of the employee.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the employee.
	 * 
	 * @param id The ID to be set for the employee.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the first name of the employee.
	 * 
	 * @return The first name of the employee.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the employee.
	 * 
	 * @param firstName The first name to be set for the employee.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the employee.
	 * 
	 * @return The last name of the employee.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the employee.
	 * 
	 * @param lastName The last name to be set for the employee.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the email address of the employee.
	 * 
	 * @return The email address of the employee.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the employee.
	 * 
	 * @param email The email address to be set for the employee.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the username of the employee.
	 * 
	 * @return The username of the employee.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the username of the employee.
	 * 
	 * @param userName The username to be set for the employee.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Retrieves the password of the employee.
	 * 
	 * @return The password of the employee.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the employee.
	 * 
	 * @param password The password to be set for the employee.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieves the address of the employee.
	 * 
	 * @return The address of the employee.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the employee.
	 * 
	 * @param address The address to be set for the employee.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Retrieves the mobile number of the employee.
	 * 
	 * @return The mobile number of the employee.
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the mobile number of the employee.
	 * 
	 * @param mobileNumber The mobile number to be set for the employee.
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}