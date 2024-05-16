package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;

/**
 * Servlet implementation class CheckUpdatedMobileNumberServlet.
 * This servlet is responsible for handling requests related to updated mobile number validation.
 * It receives a POST request with updated mobile number data, validates it, and sends back a response.
 *
 * @author Jayesh Soni
 * @since 2024-05-14
 */
@WebServlet("/CheckUpdatedMobileNumberServlet")
public class CheckUpdatedMobileNumberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating an instance of the EmployeeServceImplementation to handle updated mobile number validation
		EmployeeServiceImplementation updatedMobileNumberValidation = new EmployeeServiceImplementation();
		// Call the validateUpdatedMobileNumber method to validate the updated mobile number
		updatedMobileNumberValidation.validateUpdatedMobileNumber(request, response);
	}

}