package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;

/**
 * Servlet implementation class CheckMobileNumberServlet.
 * This servlet is responsible for handling requests related to existing mobile number validation.
 * It receives a POST request with mobile number data, validates it, and sends back a response.
 *
 * @author Jayesh Soni
 * @since 2024-05-14
 */
@WebServlet("/CheckMobileNumberServlet")
public class CheckMobileNumberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating an instance of the EmployeeServceImplementation to handle existing mobile number validation
		EmployeeServiceImplementation mobileNumberValidation = new EmployeeServiceImplementation();
		// Call the validateMobileNumber method to validate the existing mobile number
		mobileNumberValidation.validateMobileNumber(request, response);
	}

}