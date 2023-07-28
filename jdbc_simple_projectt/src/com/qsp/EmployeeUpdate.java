package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
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

			String update = "update employee set name='Vinod' where id=2000";

			int id = statement.executeUpdate(update);

			if (id != 0) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data is not updated");
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
