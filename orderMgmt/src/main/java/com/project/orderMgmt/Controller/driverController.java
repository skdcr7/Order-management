package com.project.orderMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.Driver;
import com.project.orderMgmt.Model.Order;
import com.project.orderMgmt.Service.DriverService;

@RestController
@RequestMapping(value="/driver", produces="application/json")
public class driverController {
	
	@Autowired
	DriverService driverService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json")
	public String saveDriver(@RequestBody Driver driver)
	{
		driverService.saveDriver(driver);
		return "Driver Added Successfully";
	}
	
	@RequestMapping(value="/removeDriver", method=RequestMethod.DELETE, consumes="application/json")
	public String removeDriver(@RequestBody Driver driver)
	{
		driverService.removeDriver(driver);
		return "Driver Removed Successfully";
	}
	
	@RequestMapping(value="/updateDriver", method=RequestMethod.PUT, consumes="application/json")
	public String updateDriver(@RequestBody Driver driver)
	{
		driverService.updateDriver(driver);
		return "Driver updated successfully";
	}
	
	@RequestMapping(value="/getAllDrivers", method=RequestMethod.GET, produces="application/json")
	public List<Driver> getAllDrivers()
	{
		List<Driver> driverList = driverService.getAllDrivers();
		return driverList;
	}
	
	@RequestMapping(value="/showAssignedOrders/{id}", method=RequestMethod.POST, produces="application/json")
	public List<Order> showAssignedOrders(@PathVariable("id") long id)
	{
		List<Order> assignedOrders = driverService.showAssignedOrders(id);
		return assignedOrders;
	}
	
	@RequestMapping(value="/completeOrder/{phn}", method=RequestMethod.GET)
	public String completeOrder(@PathVariable("phn") long phn)
	{
		driverService.completeOrder(phn);
		return "Order Completed";
	}
	
	@RequestMapping(value="/completingOrder/{phn}", method=RequestMethod.POST)
	public String completingOrder(@PathVariable("phn") long phn)
	{
		driverService.completingOrder(phn);
		return "Completed";
	}
	
	@RequestMapping(value="/getDriverByPhone/{phn}", method=RequestMethod.GET)
	public List<Driver> getDriverByPhone(@PathVariable("phn") long phn)
	{
		List<Driver> driverList = driverService.getDriverByPhone(phn);
		return driverList;
	}
	
}
