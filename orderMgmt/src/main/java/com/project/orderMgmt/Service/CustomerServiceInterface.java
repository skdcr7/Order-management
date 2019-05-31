package com.project.orderMgmt.Service;

import java.util.List;

import com.project.orderMgmt.Model.Customer;

public interface CustomerServiceInterface {

	public void saveCustomer(Customer customer);
	
	public  void removeCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public List<Customer> getCustomerByEmail(String email);
}
