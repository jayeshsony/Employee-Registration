package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;

/**
 * Servlet implementation class CheckUpdatedEmailServlet. This servlet is
 * responsible for handling requests related to updated email validation. It
 * receives a POST request with updated mobile email, validates it, and sends
 * back a response.
 *
 * @author Jayesh Soni
 * @since 2024-05-14
 */
@WebServlet("/CheckUpdatedEmailServlet")
public class CheckUpdatedEmailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating an instance of the EmployeeServceImplementation to handle updated email validation
		EmployeeServiceImplementation updatedEmailValidation = new EmployeeServiceImplementation();
		// Call the validateUpdatedEmail method to validate the updated eamil
		updatedEmailValidation.validateUpdatedEmail(request, response);
	}

}