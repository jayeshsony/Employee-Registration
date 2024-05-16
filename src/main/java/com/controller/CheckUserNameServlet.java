package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;
/**
 * Servlet implementation class CheckUserNameServlet.
 * This servlet is responsible for handling requests related to existing username validation.
 * It receives a POST request with existing username data, validates it, and sends back a response.
 * 
 * @author Jayesh Soni
 * @since 2024-05-14
 */
@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating an instance of the EmployeeServceImplementation to handle existing username validation
		EmployeeServiceImplementation userNameValidation = new EmployeeServiceImplementation();
		// Call the validateUserName method to validate the existing username
		userNameValidation.validateUserName(request, response);
	}

}