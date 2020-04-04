package com.capgemini.hibernateassign.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.hibernateassign.dao.CustomerDAO;
import com.capgemini.hibernateassign.dao.CustomerDAOImplementation;
import com.capgemini.hibernateassign.dto.Customer_info;

public class Q1Customer {
	public static void main(String[] args) {

		int choice;
		Scanner sc = new Scanner(System.in);
		CustomerDAO dao = new CustomerDAOImplementation();

		do {
			System.out.println("1.to insert");
			System.out.println("2.update");
			System.out.println("3.customer details");
			System.out.println("4.All customers");
			System.out.println("5.delete");
		
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				
				Customer_info info1 = new Customer_info();
				info1.setFirstName("sri");
				info1.setLastName("lakshmi");
				info1.setContactNumber(7093305808l);
				info1.setAddress("gnt");
				info1.setCity("Guntur");
				info1.setState("AP");
				info1.setCountry("India");
				boolean isInserted = dao.insertCustomerInfo(info1);
				if (isInserted == true) {
					System.out.println("Record Inserted");
				} else {
					System.out.println("Record not inserted");
				}
				break;
			case 2:
				CustomerDAO dao2 = new CustomerDAOImplementation();
				boolean b = dao2.updateCustomerInfo(new Customer_info());
				System.out.println("isUpdated-->" + b);
				break;
			case 3:
				
				Customer_info info = dao.getCustomerInfo(7093305808l);
				System.out.println(info.getFirstName());
				System.out.println(info.getLastName());
				System.out.println(info.getContactNumber());
				System.out.println(info.getAddress());
				System.out.println(info.getCity());
				System.out.println(info.getState());
				System.out.println(info.getCountry());
				break;
			case 4:
				
				List<Customer_info> list = dao.getAllCustomers();
				Iterator<Customer_info> it = list.iterator();
				while (it.hasNext()) {
					Customer_info info3 = it.next();
					System.out.println(info3.getFirstName());
					System.out.println(info3.getLastName());
					System.out.println(info3.getContactNumber());
					System.out.println(info3.getAddress());
					System.out.println(info3.getCity());
					System.out.println(info3.getState());
					System.out.println(info3.getCountry());
					System.out.println("---------------------");

				}
				break;

			case 5:

				
				boolean b1 = dao.deleteCustomerInfo(7093305808l);
				if (b1 == true) {
					System.out.println("deleted record");
				} else {
					System.out.println("not deleted");
				}
				break;

			}

		} while (choice != 0);
		sc.close();
		
	}
}
