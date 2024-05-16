package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provides a method to establish a connection to a MySQL database.
 * 
 * @author Jayesh Soni
 * @since 2024-05-07
 */
public class DatabaseConnection {

	// Create connection object
	private static Connection databaseConnection;
	// Database URL constant
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employee";
	// Username constant
	public static final String USERNAME = "root";
	// Password constant
	public static final String PASSWORD = "jaysoni105";

	/**
	 * This method establishes a connection to a MySQL database.
	 *
	 * @return con This is the Connection object representing the connection to the database.
	 */
	public static Connection getconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return databaseConnection;
	}

}