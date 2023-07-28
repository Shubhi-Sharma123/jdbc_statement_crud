package com.qsp.statements.statics.controller;
import java.sql.ResultSet;
import java.util.List;
import com.qsp.statements.statics.dto.Employee;
import com.qsp.statements.statics.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		
		EmployeeService employeeService = new EmployeeService();
		
		boolean b = true;
		
		while(b) 
		{
			switch (4) 
		{
			case 1:
			{ //for insert the data
				employee.setempId(301);
				employee.setename("Mark");
				employee.setemail("mark@gmail.com");
				employeeService.insertEmployee(employee);
			}
			break;
			
			case 2:
			{ //for update the data
				employee.setempId(307);
				employee.setename("Tarun");
				employeeService.updateEmployee(employee);
			}
			break;
			case 3:
			{ //for delete the data
				employee.setempId(306);
				System.out.println("controller-class");
				employeeService.deleteEmployee(employee);
			}
			break;
			case 4:
			{ //for display the data
				List<Employee> employees=employeeService.displayEmployees();
				for(Employee employee2:employees)
				{
					System.out.println(employee2.getempId());
					System.out.println(employee2.getename());
					System.out.println(employee2.getemail());
					System.out.println("==========================");
				}
			}
			break;
			
			default:
				break;
			}
			
			b=false;
		}
		
	}
}


