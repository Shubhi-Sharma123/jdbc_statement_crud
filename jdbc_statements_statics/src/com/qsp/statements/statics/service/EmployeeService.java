package com.qsp.statements.statics.service;

import com.qsp.statements.statics.dao.EmployeeDao;
import java.sql.ResultSet;
import java.util.List;
import com.qsp.statements.statics.dto.Employee;

public class EmployeeService 
{
	
	EmployeeDao dao=new EmployeeDao();
	
	//****this method is for business logic****
	
//insert method for employee table
 public void insertEmployee(Employee employee)
 {
	 String name=employee.getename();
	 int count=0;
	 if(name.length()<=14)
	 {
		 dao.insertEmployee(employee);
	 }
	 else 
	 {
		 System.out.println("Idiot Please provide the name which have 14 character");
	 } 
 }
//update method for employee table
	public void updateEmployee(Employee employee) 
	{
		dao.updateEmployee(employee);
	}
	
//delete method for employee table
	public void deleteEmployee(Employee employee) 
	{
		dao.deleteEmployee(employee);
	}
	
// display Method for employee
		public List<Employee> displayEmployees() 
		{
				
		   return dao.displayEmployees();
		   
		}
}
