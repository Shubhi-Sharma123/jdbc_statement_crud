package com.ibm.jdbc_crud_operation_statements.controller;

import java.util.List;

import java.util.Scanner;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;
import com.ibm.jdbc_crud_operation_statements.service.LaptopService;


public class LaptopController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Laptop laptop = new Laptop();
		LaptopService laptopService = new LaptopService();

		while (true) {
			System.out.println("1.InsertLaptop\n2.UpadateLaptop\n3.DeleteLaptop\n4.DisplayLaptop\n5.Exit");
			System.out.println("choose your choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("Enter the Laptop Id");
				laptop.setId(sc.nextInt());
				System.out.println("Enter the Laptop name");
				laptop.setName(sc.next());
				System.out.println("Enter the Laptop Price");
				laptop.setPrice(sc.nextDouble());
				System.out.println("Enter the Laptop Color");
				laptop.setColor(sc.next());

				laptopService.insertLaptop(laptop);
			}
				break;

			case 2: {
				System.out.println("Enter the Laptop Id");
				laptop.setId(sc.nextInt());
				System.out.println("Enter the Laptop name");
				laptop.setName(sc.next());
				laptopService.updateLaptop(laptop);
			}
				break;
			case 3: {
				System.out.println("Enter the Laptop Id");
				laptop.setId(sc.nextInt());

				laptopService.deleteLaptop(laptop);
			}
				break;
			case 4: {
				List<Laptop>laptops=laptopService.displayLaptops();
				for (Laptop laptop1: laptops) 
				{
					System.out.println(laptop1.getId());
					System.out.println(laptop1.getName());
					System.out.println(laptop1.getPrice());
					System.out.println(laptop1.getColor());
					System.out.println("==========================");
				}
			}
			break;
			case 5: {
			}
				break;

			default: {
			}
				break;
			}

		}

	}
}
