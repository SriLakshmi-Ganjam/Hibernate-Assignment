package com.capgemini.hibernateassign.dao;

import java.util.List;

import com.capgemini.hibernateassign.dto.Customer_info;

public interface CustomerDAO {
	boolean updateCustomerInfo(Customer_info info);
	boolean deleteCustomerInfo(long contactNumber);
	boolean insertCustomerInfo(Customer_info info);
	List<Customer_info> getAllCustomers();
	Customer_info getCustomerInfo(long contactNumber);
	

}
