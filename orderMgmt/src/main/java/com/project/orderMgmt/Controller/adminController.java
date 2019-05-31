package com.project.orderMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.Customer;
import com.project.orderMgmt.Model.Driver;
import com.project.orderMgmt.Model.Order;
import com.project.orderMgmt.Model.Restaurant;
import com.project.orderMgmt.Service.CustomerService;
import com.project.orderMgmt.Service.DriverService;
import com.project.orderMgmt.Service.OrderService;
import com.project.orderMgmt.Service.RestaurantService;

@RestController
@RequestMapping(value="/admin", produces="application/json")
public class adminController {
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/saveDriver", method=RequestMethod.POST, consumes="application/json")
	public String addDriver(@RequestBody Driver driver)
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
	
	@RequestMapping(value="/addRestro", method=RequestMethod.POST, consumes="application/json")
	public String addRestaurant(@RequestBody Restaurant restaurant)
	{
		restaurantService.saveRestaurant(restaurant);
		return "Restaurant Added Successfully";
	}
	
	@RequestMapping(value="/removeRestro", method=RequestMethod.DELETE, consumes="application/json")
	public String removeRestaurant(@RequestBody Restaurant restaurant)
	{
		restaurantService.removeRestaurant(restaurant);
		return "Restaurant removed successfully";
	}
	
	@RequestMapping(value="/updateRestro", method=RequestMethod.PUT, consumes="application/json")
	public String updateRestaurant(@RequestBody Restaurant restaurant)
	{
		restaurantService.updateRestaurant(restaurant);
		return "Restaurant updated successfully";
	}
	
	@RequestMapping(value="/getActiveDrivers", method=RequestMethod.GET)
	public List<Driver> getActiveDrivers()
	{
		List<Driver> driverList = driverService.getActiveDrivers();
		return driverList;
	}
	
	@RequestMapping(value="/assignDriver/{oid}/{did}", method=RequestMethod.POST)
	public String assignDriver(@PathVariable("oid") int oid,@PathVariable("did") long did)
	{
		orderService.assignDriver(oid, did);
		return "Driver assigned";	
	}
	
	@RequestMapping(value="/showPendingOrders", method=RequestMethod.GET, produces="application/json")
	public List<Order> showPendingOrders()
	{
		List<Order> pendingOrders = orderService.showPendingOrders();
		return pendingOrders;
	}
	
	@RequestMapping(value="/getCustomerbyEmail", method=RequestMethod.POST, produces="application/json")
	public List<Customer> getCustomerByEmail(@RequestParam("email") String email) 
	{
		List<Customer> customerList = customerService.getCustomerByEmail(email);
		return customerList;
	}
	
	@RequestMapping(value="/deleteDriverByPhone/{phn}", method=RequestMethod.POST)
	public void deleteDriverByPhone(@PathVariable("phn") long phn)
	{
		driverService.deleteDriverByPhone(phn);
	}
	
	@RequestMapping(value="/getDriverByEmail", method=RequestMethod.POST, produces="application/json")
	public List<Driver> getDriverByEmail(@RequestParam("email") String email)
	{
		List<Driver> driverList = driverService.getDriverByEmail(email);
		return driverList;
	}
	
	@RequestMapping(value="/modify/{id}", method=RequestMethod.POST)
	public String modifyRestaurant(@RequestBody Restaurant restaurant, @PathVariable("id") int id)
	{
		restaurantService.modifyRestaurant(restaurant, id);
		return "Restaurant updated";
	}
}
