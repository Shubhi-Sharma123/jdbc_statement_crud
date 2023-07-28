package com.ibm.jdbc_crud_operation_statements.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ibm.jdbc_crud_operation_statements.dto.Laptop;


public class LaptopDao {

	public void insertLaptop(Laptop laptop) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "shubhi@123";

			Connection connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			String insert = "insert into laptop values(" + laptop.getId() + ",'" + laptop.getName() + "',"
					+ laptop.getPrice() + ",'" + laptop.getColor() + "')";
			statement.execute(insert);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateLaptop(Laptop laptop) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "shubhi@123";

			Connection connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			String update = " update laptop set name ='" + laptop.getName() + "'" + " where id =" + laptop.getId();
			int id = statement.executeUpdate(update);

			if (id != 0) {
				System.out.println("Data updated");
			} else {
				System.out.println("id is not present");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteLaptop(Laptop laptop) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "shubhi@123";

			Connection connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();
			String delete = " delete from laptop where id =" + laptop.getId() + "";
			statement.execute(delete);
			System.out.println("Data deleted....");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Laptop> displayLaptops() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "shubhi@123";

			Connection connection = DriverManager.getConnection(url, user, pass);
		    Statement statement = connection.createStatement();

			String select = "SELECT * FROM laptop";

			ResultSet resultSet = statement.executeQuery(select);

			List<Laptop> Laptops = new ArrayList<Laptop>();

			while (resultSet.next()) {
				Laptop laptop = new Laptop();

				laptop.setId(resultSet.getInt("Id"));
				laptop.setName(resultSet.getString("name"));
				laptop.setPrice(resultSet.getDouble("price"));
				laptop.setColor(resultSet.getString("color"));
				Laptops.add(laptop);
			}

			return Laptops;
		}

		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
}
