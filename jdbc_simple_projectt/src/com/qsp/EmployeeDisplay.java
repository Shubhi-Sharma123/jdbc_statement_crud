package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDisplay {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// step-1 Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Create the connection

			String url = "jdbc:mysql://localhost:3306/jdbc_simple_projectt";
			String user = "root";
			String pass = "shubhi@123";

			conn = DriverManager.getConnection(url, user, pass);

			// step-3 Create the statement
			Statement statement = conn.createStatement();

			// step-4 Execute the Query

			String select = "SELECT * FROM employee ";			
			ResultSet resultset=statement.executeQuery(select);
			while(resultset.next())
			{                                            //either position of the column or the name of the column.
				System.out.println("id="+resultset.getInt(1));
				System.out.println("name="+resultset.getString(2));
				System.out.println("email="+resultset.getString(3));
			}
			System.out.println(conn);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
			try {
				// step-5 Close Connection
				conn.close();

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
}
