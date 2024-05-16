package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;

/**
/**
 * Servlet implementation class EmployeeServlet
 * This servlet is responsible for inserting employee records in databse.
 *
 * @author Jayesh Soni
 * @since 2024-05-07
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

	// This doPost method to handle POST requests
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create an instance of EmployeeServceImplementation to process registered data
		EmployeeServiceImplementation registeredData = new EmployeeServiceImplementation();
		// Call method to process updated data
		registeredData.processRegistrationData(request, response);
	}

}