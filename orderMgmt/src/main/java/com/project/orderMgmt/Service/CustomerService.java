package com.project.orderMgmt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.orderMgmt.DAO.CustomerDao;
import com.project.orderMgmt.Model.Customer;

@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	public void saveCustomer(Customer customer)
	{
		customerDao.saveCustomer(customer);
	}
	
	@Transactional
	public  void removeCustomer(Customer customer)
	{
		customerDao.removeCustomer(customer);
	}
	
	@Transactional
	public void updateCustomer(Customer customer)
	{
		customerDao.updateCustomer(customer);
	}
	
	@Transactional
	public List<Customer> getCustomerByEmail(String email)
	{
		List<Customer> customerList = customerDao.getCustomerByEmail(email);
		return customerList;
	}
}
