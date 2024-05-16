package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceimpl.EmployeeServiceImplementation;


/**
 * Servlet implementation class UpdateRecordServlet.
 * This servlet is responsible for updating employee records.
 * 
 * @author Jayesh Soni
 * @since 2024-05-10
 */
@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create an instance of EmployeeServceImplementation to process updated data
		EmployeeServiceImplementation updatedData = new EmployeeServiceImplementation();
		// Call method to process updated data
		updatedData.processUpdatedData(request, response);
	}

}