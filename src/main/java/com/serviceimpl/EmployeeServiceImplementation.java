package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Employee;
import com.service.EmployeeService;
import com.util.DatabaseConnection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class implements the EmployeeService interface and provides
 * implementations for all its methods. Additionally, it includes its own
 * methods that utilize the methods of the interface.
 *
 * @author Jayesh Soni
 * @since 2024-05-07
 */
public class EmployeeServiceImplementation implements EmployeeService {

	// Create connection object
	private Connection databaseConnection;

	@Override
	public boolean saveUser(Employee currentEmployee) {
		// Set success flag to false
		boolean success = false;

		try {
			// Get database connection
			databaseConnection = DatabaseConnection.getconnection();

			// SQL query to insert employee data into the database
			String insertRecord = "insert into employee (firstname, lastname, email, username, password, address, mobile_number) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insertRecordStatement = databaseConnection.prepareStatement(insertRecord);

			// Set values for placeholders in the query
			insertRecordStatement.setString(1, currentEmployee.getFirstName());
			insertRecordStatement.setString(2, currentEmployee.getLastName());
			insertRecordStatement.setString(3, currentEmployee.getEmail());
			insertRecordStatement.setString(4, currentEmployee.getUserName());
			insertRecordStatement.setString(5, currentEmployee.getPassword());
			insertRecordStatement.setString(6, currentEmployee.getAddress());
			insertRecordStatement.setString(7, currentEmployee.getMobileNumber());
			insertRecordStatement.executeUpdate(); // Execute the SQL query

			// Set success flag to true
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

	@Override
	public List<Employee> retriveUser() {
		// Create list to store retrieved records
		List<Employee> EmployeeList = new ArrayList<>();

		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// SQL query to retrieve all employee data from the database
			String retriveRecords = "SELECT * FROM employee ORDER BY id DESC";
			PreparedStatement retriveRecordStatement = databaseConnection.prepareStatement(retriveRecords);
			ResultSet employeeResultSet = retriveRecordStatement.executeQuery(); // Execute the query and get the result
																					// set

			// Iterate through the result set and create Employee objects
			while (employeeResultSet.next()) {
				// Retrieve data for each column
				int id = employeeResultSet.getInt("id");
				String firstName = employeeResultSet.getString("firstname");
				String lastName = employeeResultSet.getString("lastname");
				String email = employeeResultSet.getString("email");
				String userName = employeeResultSet.getString("username");
				String password = employeeResultSet.getString("password");
				String address = employeeResultSet.getString("address");
				String mobileNumber = employeeResultSet.getString("mobile_number");

				// Create Employee object and add it to the list
				Employee emp = new Employee(id, firstName, lastName, email, userName, password, address, mobileNumber);
				EmployeeList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return EmployeeList;
	}

	@Override
	public void deleteUser(int id) {
		try {
			databaseConnection = DatabaseConnection.getconnection();
			// SQL query to delete employee data from database
			String deleteRecord = "DELETE FROM employee WHERE id = ?";
			PreparedStatement deleteRecordStatement = databaseConnection.prepareStatement(deleteRecord);

			// Set values for placeholders in the query
			deleteRecordStatement.setInt(1, id);
			deleteRecordStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Employee retrieveSpecificUser(int id) {
		Employee employeeData = null;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// SQL query to retrieve employee data from the database based on id
			String retriveCurrentEmployee = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement pts = databaseConnection.prepareStatement(retriveCurrentEmployee);
			pts.setInt(1, id); // Set the id parameter before executing the query
			ResultSet currentEmployeeResultSet = pts.executeQuery(); // Execute the query and get the result set

			// Check if there is a result
			if (currentEmployeeResultSet.next()) {
				// Retrieve data for each column
				String firstName = currentEmployeeResultSet.getString("firstname");
				String lastName = currentEmployeeResultSet.getString("lastname");
				String email = currentEmployeeResultSet.getString("email");
				String userName = currentEmployeeResultSet.getString("username");
				String password = currentEmployeeResultSet.getString("password");
				String address = currentEmployeeResultSet.getString("address");
				String mobileNumber = currentEmployeeResultSet.getString("mobile_number");

				// Create Employee object
				employeeData = new Employee(id, firstName, lastName, email, userName, password, address, mobileNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return employeeData;
	}

	@Override
	public void updateUser(int id, String firstName, String lastName, String email, String userName, String password,
			String address, String mobileNumber) {
		try {

			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// SQL query to update employee data
			String updateRecord = "UPDATE employee SET firstname = ?, lastname = ?, email = ?, username = ?, password = ?, address = ?, mobile_number= ? WHERE id = ?";
			PreparedStatement updateRecordStatement = databaseConnection.prepareStatement(updateRecord);

			// Set values for placeholders in the query
			updateRecordStatement.setString(1, firstName);
			updateRecordStatement.setString(2, lastName);
			updateRecordStatement.setString(3, email);
			updateRecordStatement.setString(4, userName);
			updateRecordStatement.setString(5, password);
			updateRecordStatement.setString(6, address);
			updateRecordStatement.setString(7, mobileNumber);
			updateRecordStatement.setInt(8, id);
			updateRecordStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean checkEmail(String email) {
		// Flag to indicate whether the email exists in the database
		boolean mailExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the email already exists in the database
			String checkEmail = "SELECT * FROM employee WHERE email = ?";
			PreparedStatement emailCheckStatement = databaseConnection.prepareStatement(checkEmail);
			emailCheckStatement.setString(1, email);
			ResultSet currentEmailResutSet = emailCheckStatement.executeQuery();

			// If the result set contains any rows, it means the email already exists
			if (currentEmailResutSet.next()) {
				mailExists = true; // Set the flag to true if the email exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return mailExists;
	}

	@Override
	public boolean checkUserName(String userName) {
		// Flag to indicate whether the user name exists in the database
		boolean userNameExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the user name already exists in the database
			String checkUserName = "SELECT * FROM employee WHERE username = ?";
			PreparedStatement userNameCheckStatement = databaseConnection.prepareStatement(checkUserName);
			userNameCheckStatement.setString(1, userName);
			ResultSet currentUserNameResultSet = userNameCheckStatement.executeQuery();

			// If the result set contains any rows, it means the user name already exists
			if (currentUserNameResultSet.next()) {
				userNameExists = true; // Set the flag to true if the user name exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userNameExists;
	}

	@Override
	public boolean checkContactNumber(String contactNumber) {
		// Flag to indicate whether the mobile number exists in the database
		boolean contactNumberExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the mobile number already exists in the database
			String checkContactNumber = "SELECT * FROM employee WHERE mobile_number = ?";
			PreparedStatement contactNumberCheckStatement = databaseConnection.prepareStatement(checkContactNumber);
			contactNumberCheckStatement.setString(1, contactNumber);
			ResultSet currentContactNumberResultSet = contactNumberCheckStatement.executeQuery();

			// If the result set contains any rows, it means the mobile number already
			// exists
			if (currentContactNumberResultSet.next()) {
				contactNumberExists = true; // Set the flag to true if the mobile number exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return contactNumberExists;
	}

	@Override
	public boolean checkUpdatedEmail(String email, int id) {
		// Flag to indicate whether the updated email exists in the database
		boolean mailExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the updated email already exists in the database
			String checkUpdatedEmail = "SELECT * FROM employee WHERE email=? AND id != ?";
			PreparedStatement updatedEmailCheckStatement = databaseConnection.prepareStatement(checkUpdatedEmail);
			updatedEmailCheckStatement.setString(1, email);
			updatedEmailCheckStatement.setInt(2, id);
			ResultSet updatedEmailResultSet = updatedEmailCheckStatement.executeQuery();

			// If the result set contains any rows, it means the email already exists
			if (updatedEmailResultSet.next()) {
				mailExists = true; // Set the flag to true if the email exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return mailExists;
	}

	@Override
	public boolean checkUpdatedUserName(String username, int id) {
		// Flag to indicate whether the updated user name exists in the database
		boolean userNameExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the updated user name already exists in the database
			String checkUpdatedUserName = "SELECT * FROM employee WHERE username =? AND id != ?";
			PreparedStatement updatedUserNameCheckStatement = databaseConnection.prepareStatement(checkUpdatedUserName);
			updatedUserNameCheckStatement.setString(1, username);
			updatedUserNameCheckStatement.setInt(2, id);

			// If the result set contains any rows, it means the user name already exists
			ResultSet updatedUserNameResultSet = updatedUserNameCheckStatement.executeQuery();
			if (updatedUserNameResultSet.next()) {
				userNameExists = true; // Set the flag to true if the user name exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userNameExists;
	}

	@Override
	public boolean checkUpdatedConctactNumber(String mobileNumber, int id) {
		// Flag to indicate whether the updated mobile number exists in the database
		boolean contactNumberExists = false;
		try {
			databaseConnection = DatabaseConnection.getconnection(); // Get database connection
			// Check if the updated mobile number already exists in the database
			String checkUpdatedContactNumber = "SELECT * FROM employee WHERE mobile_number =? AND id != ?";
			PreparedStatement updatedContactNumberCheckStatement = databaseConnection.prepareStatement(checkUpdatedContactNumber);
			updatedContactNumberCheckStatement.setString(1, mobileNumber);
			updatedContactNumberCheckStatement.setInt(2, id);
			ResultSet updatedContactNumberResultSet = updatedContactNumberCheckStatement.executeQuery();

			// If the result set contains any rows, it means the mobile number already
			// exists
			if (updatedContactNumberResultSet.next()) {
				contactNumberExists = true; // Set the flag to true if the mobile number exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return contactNumberExists;
	}

	/**
	 * This method retrieves registration data from the HttpServletRequest object,
	 * checks for duplicate entries in the database, and either saves the new user
	 * or returns an error message if duplicate data is found.
	 * 
	 * @param request  the HttpServletRequest object containing registration data
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void processRegistrationData(HttpServletRequest request, HttpServletResponse response) {
		// Retrieving parameters from the request
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobileNumber = request.getParameter("mobileNumber");

		// Get PrintWriter object to send response back to client
		PrintWriter out;
		HttpSession session = request.getSession();

		// Get database connection
		databaseConnection = DatabaseConnection.getconnection();

		try {
			out = response.getWriter();
			// Check if entered email, user name or mobile number already exists or not
			if (checkEmail(email)) {
				out.print("Email already exists!");
			} else if (checkUserName(userName)) {
				out.print("User name already exists!");
			} else if (checkContactNumber(mobileNumber)) {
				out.print("Contact number already exists!");
			} else {
				// If email, user name and mobile number does not exist, create Employee object
				Employee emp = new Employee(firstName, lastName, email, userName, password, address, mobileNumber);

				// If saveUser method returns true, insert the record in database
				if (saveUser(emp)) {
					// If user saved successfully, send response message "SUCCESS"
					out.print("success");
					session.setAttribute("registration", "Successfully registerd user");
				} else {
					// If user not saved, send response message "FAIL"
					out.print("fails");
					session.setAttribute("registration", "Failed to register user");
				}
			}
		} catch (Exception e) {
			// Handle SQL exception
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method retrieves updated user data from the HttpServletRequest object,
	 * checks for duplicate entries in the database, and updates the user's record
	 * if no duplicates are found.
	 * 
	 * @param request  the HttpServletRequest object containing updated user data
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void processUpdatedData(HttpServletRequest request, HttpServletResponse response) {
		// Getting the current session
		HttpSession session = request.getSession();
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		// Retrieving parameters from the request
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobileNumber = request.getParameter("mobileNumber");

		databaseConnection = DatabaseConnection.getconnection();

		try {
			out = response.getWriter();
			// Check if updated email, user name or mobile number already exists in other employee record
			if (checkUpdatedEmail(email, id)) {
				out.print("Email already exists!");
			} else if (checkUpdatedUserName(userName, id)) {
				out.print("User name already exists!");
			} else if (checkUpdatedConctactNumber(mobileNumber, id)) {
				out.print("Contact number already exists!");
			} else {
				// Calling the updateUser method to update the user's record
				updateUser(id, firstName, lastName, email, userName, password, address, mobileNumber);

				// Setting an attribute in session to indicate that the record has been updated
				session.setAttribute("updatedRecord", "Record updated!");

				out.print("success");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		} finally {
			// Close the Connection
			if (databaseConnection != null) {
				try {
					databaseConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Checks the action to be performed on an employee (delete or update). This
	 * method retrieves the action and employee ID from the HttpServletRequest
	 * object and performs the requested action (delete or update) on the employee
	 * record.
	 * 
	 * @param request  the HttpServletRequest object containing the action and employee ID
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void checkEmployeeAction(HttpServletRequest request, HttpServletResponse response) {
		// Get the session associated with this request
		HttpSession session = request.getSession();

		// Get the action parameter from the request, indicating whether to delete or
		String action = request.getParameter("action");

		// Get the ID of the employee to perform the action on
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			// If the action is "delete", delete the user with the given ID
			if (action.equals("delete")) {
				deleteUser(id); // Delete the user
				session.setAttribute("updatedRecord", "Record deleted!"); // Set a session attribute to indicate success
				response.sendRedirect("EmployeeList.jsp"); // Redirect to EmployeeList.jsp
			} else {
				// If the action is not "delete", retrieve the user with the given ID
				Employee user = retrieveSpecificUser(id); // Retrieve the user
				session.setAttribute("user", user); // Set a session attribute with the retrieved user
				response.sendRedirect("Registration.jsp"); // Redirect to Registration.jsp for further action
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method receives an email address via AJAX request, checks if it already
	 * exists in the database by calling checkEmail method, and sends a response
	 * back to the client indicating whether the email is available or already in
	 * use.
	 * 
	 * @param request  the HttpServletRequest object containing the email to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateEmail(HttpServletRequest request, HttpServletResponse response) {
		// Get email from the AJAX request
		String email = request.getParameter("email");
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		try {
			out = response.getWriter();
			// Check if email already exists in other employee record
			if (checkEmail(email)) {
				out.print("Email");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}
	}

	/**
	 * This method receives a username via AJAX request, checks if it already exists
	 * in the database by calling checkUserName method, and sends a response back to
	 * the client indicating whether the username is available or already in use.
	 * 
	 * @param request  the HttpServletRequest object containing the username to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateUserName(HttpServletRequest request, HttpServletResponse response) {
		// Get user name from the AJAX request
		String userName = request.getParameter("userName");
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		try {
			// Check if updated email, user name or mobile number already exists in other
			// employee record
			out = response.getWriter();
			if (checkUserName(userName)) {
				out.print("Username");
			} else {
				out.print("available");
			}
		} catch (Exception e) {
			// Handle SQL exception
			e.printStackTrace();
		}
	}

	/**
	 * This method receives a mobile number via AJAX request, checks if it already
	 * exists in the database by calling checkContactNumber method, and sends a
	 * response back to the client indicating whether the mobile number is available
	 * or already in use.
	 * 
	 * @param request  the HttpServletRequest object containing the mobile number to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateMobileNumber(HttpServletRequest request, HttpServletResponse response) {
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		// Creating an instance of EmployeeServceImplementation

		// Retrieving parameters from the request
		String mobileNumber = request.getParameter("mobileNumber");

		try {
			out = response.getWriter();
			// Check if updated email, user name or mobile number already exists in other
			// employee record
			if (checkContactNumber(mobileNumber)) {
				out.print("Mobile");
			} else {
				out.print("available");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}
	}

	/**
	 * . This method receives an email address and user ID via AJAX request, checks
	 * if the email already exists in the database excluding the current user's
	 * record by calling checkUpdatedEmail method, and sends a response back to the
	 * client indicating whether the email is available or already in use.
	 * 
	 * @param request  the HttpServletRequest object containing the email and user ID to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateUpdatedEmail(HttpServletRequest request, HttpServletResponse response) {
		// Get email and id from the AJAX request
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));

		// Get PrintWriter object to send response back to client
		PrintWriter out;

		try {
			out = response.getWriter();
			if (checkUpdatedEmail(email, id)) {
				out.print("exists");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}

	}

	/**
	 * This method receives a username and user ID via AJAX request, checks if the
	 * username already exists in the database excluding the current user's record
	 * by calling checkUpdatedUserName method, and sends a response back to the
	 * client indicating whether the username is available or already in use.
	 * 
	 * @param request  the HttpServletRequest object containing the username and user ID to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateUpdatedUserName(HttpServletRequest request, HttpServletResponse response) {
		// Get id and user name from the AJAX request
		int id = Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("userName");
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		try {
			out = response.getWriter();
			// Check if updated email, user name or mobile number already exists in other
			// employee record
			if (checkUpdatedUserName(userName, id)) {
				out.print("exists");
			} else {
				out.print("available");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}
	}

	/**
	 * This method receives a mobile number and user ID via AJAX request, checks if
	 * the mobile number already exists in the database excluding the current user's
	 * record by calling checkUpdatedMobileNumber method, and sends a response back
	 * to the client indicating whether the mobile number is available or already in
	 * use.
	 * 
	 * @param request  the HttpServletRequest object containing the mobile number and user ID to be validated
	 * @param response the HttpServletResponse object used to send response back to the client
	 */
	public void validateUpdatedMobileNumber(HttpServletRequest request, HttpServletResponse response) {
		// Get PrintWriter object to send response back to client
		PrintWriter out;

		// Retrieving parameters from the request
		int id = Integer.parseInt(request.getParameter("id"));
		String mobileNumber = request.getParameter("mobileNumber");

		try {
			out = response.getWriter();
			// Check if updated contact number already exists in other employee record
			if (checkUpdatedConctactNumber(mobileNumber, id)) {
				out.print("exists");
			} else {
				out.print("available");
			}
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}
	}

}