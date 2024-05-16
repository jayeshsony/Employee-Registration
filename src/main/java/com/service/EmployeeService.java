package com.service;

import java.util.List;
import com.entity.Employee;

/**
 * This interface defines the methods for managing Employee entities. It
 * provides functionality to interact with the Employee database table.
 * 
 * @author Jayesh Soni
 * @since 2024-05-07
 */
public interface EmployeeService {

	/**
	 * Inserts an employee entity details into the database.
	 *
	 * @param emp The employee to be saved.
	 * @return true if the employee was successfully saved, false otherwise.
	 */
	boolean saveUser(Employee emp);

	/**
	 * Retrieves a list of all employees from the database.
	 *
	 * @return A list containing all employee entities.
	 */
	List<Employee> retriveUser();

	/**
	 * Deletes an employee from the database based on the provided ID.
	 *
	 * @param id The ID of the employee to be deleted.
	 */
	void deleteUser(int id);

	/**
	 * Retrieves a specific employee from the database based on the provided ID.
	 *
	 * @param id The ID of the employee to be retrieved.
	 * @return The employee entity with the specified ID, or null if not found.
	 */
	Employee retrieveSpecificUser(int id);

	/**
	 * Updates an existing employee's details in the database.
	 *
	 * @param id           The ID of the employee to be updated.
	 * @param firstName    The updated first name of the employee.
	 * @param lastName     The updated last name of the employee.
	 * @param email        The updated email of the employee.
	 * @param userName     The updated username of the employee.
	 * @param password     The updated password of the employee.
	 * @param address      The updated address of the employee.
	 * @param mobileNumber The updated mobile number of the employee.
	 */
	void updateUser(int id, String firstName, String lastName, String email, String userName, String password,
			String address, String mobileNumber);

	/**
	 * Checks if the provided email is already in use.
	 *
	 * @param email The email to check.
	 * @return true if the email is already in use, false otherwise.
	 */
	boolean checkEmail(String email);

	/**
	 * Checks if the provided username is already in use.
	 *
	 * @param userName The username to check.
	 * @return true if the username is already in use, false otherwise.
	 */
	boolean checkUserName(String userName);

	/**
	 * Checks if the provided contact number is already in use.
	 *
	 * @param contactNumber The contact number to check.
	 * @return true if the contact number is already in use, false otherwise.
	 */
	boolean checkContactNumber(String contactNumber);

	/**
	 * Checks if the provided updated email is already in use by another employee.
	 *
	 * @param email The updated email to check.
	 * @param id The ID of the employee whose email is being updated.
	 * @return true if the updated email is already in use by another employee, false otherwise.
	 */
	boolean checkUpdatedEmail(String email, int id);

	/**
	 * Checks if the provided updated username is already in use by another
	 * employee.
	 *
	 * @param username The updated username to check.
	 * @param id The ID of the employee whose username is being updated.
	 * @return true if the updated username is already in use by another employee, false otherwise.
	 */
	boolean checkUpdatedUserName(String username, int id);

	/**
	 * Checks if the provided updated contact number is already in use by another
	 * employee.
	 *
	 * @param mobileNumber The updated contact number to check.
	 * @param id The ID of the employee whose contact number is being updated.
	 * @return true if the updated contact number is already in use by another employee, false otherwise.
	 */
	boolean checkUpdatedConctactNumber(String mobileNumber, int id);

}