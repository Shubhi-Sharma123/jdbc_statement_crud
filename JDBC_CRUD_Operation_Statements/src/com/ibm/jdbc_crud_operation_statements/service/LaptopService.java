package com.ibm.jdbc_crud_operation_statements.service;

import java.util.List;

import com.ibm.jdbc_crud_operation_statements.dao.LaptopDao;
import com.ibm.jdbc_crud_operation_statements.dto.Laptop;


public class LaptopService {

	LaptopDao dao = new LaptopDao();

	public void insertLaptop(Laptop laptop) {

		if (laptop.getPrice() <= 40000) {
			dao.insertLaptop(laptop);
		} else {
			System.out.println("Price is too high");
		}
	}

	public void updateLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		dao.updateLaptop(laptop);
	}

	public void deleteLaptop(Laptop laptop) {
		dao.deleteLaptop(laptop);

	}
	public List<Laptop> displayLaptops() {
	
			
	   return dao.displayLaptops();
	   
	}
}