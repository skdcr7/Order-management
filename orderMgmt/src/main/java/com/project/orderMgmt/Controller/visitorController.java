package com.project.orderMgmt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.Customer;
import com.project.orderMgmt.Service.CustomerService;

@RestController
@RequestMapping(value = "/url", produces = "application/json")
public class visitorController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public String saveVisitors(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return "Saving complete";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE, consumes = "application/json")
	public String removeCustomers(@RequestBody Customer customer) {
		customerService.removeCustomer(customer);
		return "Customer removed successfully";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public String updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return "Updation Completed";
	}
}
