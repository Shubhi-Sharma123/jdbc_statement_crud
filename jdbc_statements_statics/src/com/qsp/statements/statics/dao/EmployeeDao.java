package com.qsp.statements.statics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qsp.statements.statics.connection.EmployeeConnection;
import com.qsp.statements.statics.dto.Employee;

public class EmployeeDao 
{

	Connection connection = null;

	/* this method will insert the employee data inside employee table */
	
	public void insertEmployee(Employee employee)
	{

		try 
		{
			connection = EmployeeConnection.getConnection();
			// step-3 Create the Statement:
			Statement statement = connection.createStatement();

			String insert = "insert into employee values(" + employee.getempId() + ",'" + employee.getename() + "','"
					+ employee.getemail() + "')";

			// step-4 execute the query

			statement.execute(insert);

			System.out.println("Data stored..........");

		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			
		} 
		finally 
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////

	// update method for employee table
	public void updateEmployee(Employee employee) 
	{
		connection = EmployeeConnection.getConnection();

		System.out.println(employee.getename());
		
		try 
		{

			Statement statement = connection.createStatement();

			String update = "update employee set ename = '"+employee.getename()+"' where empid ="+employee.getempId()+"";
				
			statement.executeUpdate(update);

			System.out.println("Data updated");
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////
	
	// delete method for employee table
	
		public void deleteEmployee(Employee employee) 
		{
			connection = EmployeeConnection.getConnection();

			System.out.println("emplyee Dao");
			
			try 
			{

				Statement statement = connection.createStatement();

				String delete = "delete from employee where empId="+employee.getempId()+"";
					
				statement.execute(delete);

				System.out.println("Data deleted....");
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		finally 
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
/////////////////////////////////////////////////////////////////////////////////
			// display method for employee table
			public List<Employee> displayEmployees()
			{
				connection=EmployeeConnection.getConnection();
				Statement statement;
				
			try 
			{
				statement=connection.createStatement();
				
				String select="SELECT * FROM employee";
				
				ResultSet resultSet=statement.executeQuery(select);
				
				List<Employee> employees = new ArrayList<Employee>();
				
				while(resultSet.next())
				{
					Employee employee=new Employee();
					
					employee.setempId(resultSet.getInt("empId"));
					employee.setename(resultSet.getString("ename"));
					employee.setemail(resultSet.getString("email"));
					employees.add(employee);
				}
			
			
				return employees ;
			}
			
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
				return null;
		}
		
}

