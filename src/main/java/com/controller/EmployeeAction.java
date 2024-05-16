package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation; // Importing the service implementation
/**
 * Servlet implementation class EmployeeAction. This servlet handles actions
 * related to employees such as deleting or retrieving employee records.
 * 
 * @author Jayesh Soni
 * @since 2024-05-09
 */
@WebServlet("/EmployeeAction")
public class EmployeeAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create an instance of the EmployeeServiceImplementation class
		EmployeeServiceImplementation employeeAction = new EmployeeServiceImplementation();
		// Call the checkEmployeeAction method to handle the action related to employees
		employeeAction.checkEmployeeAction(request, response);
	}

}