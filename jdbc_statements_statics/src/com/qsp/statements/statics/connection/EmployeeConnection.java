package com.qsp.statements.statics.connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {
	public static Connection getConnection() {
		
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbc_statements_statics";
		String user="root";
		String pass="shubhi@123";
	
		Connection connection=DriverManager.getConnection(url, user, pass);
 
		return connection;
	}
	
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
	return null;
	}
	
}
