package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;
/**
 * Servlet implementation class CheckUpdatedUserNameServlet.
 * This servlet is responsible for handling requests related to updated username validation.
 * It receives a POST request with updated username data, validates it, and sends back a response.
 * 
 * @author Jayesh Soni
 * @since 2024-05-15
 */
@WebServlet("/CheckUpdatedUserNameServlet")
public class CheckUpdatedUserNameServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create an instance of the EmployeeServceImplementation to handle updated username validation
		EmployeeServiceImplementation updatedUserNameValidation = new EmployeeServiceImplementation();
		// Call the validateUpdatedUserName method to validate the updated username
		updatedUserNameValidation.validateUpdatedUserName(request, response);
	}

}