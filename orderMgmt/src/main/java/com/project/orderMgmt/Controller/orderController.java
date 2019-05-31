package com.project.orderMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.Order;
import com.project.orderMgmt.Service.OrderService;

@RestController
@RequestMapping(value="/order", produces="application/json")
public class orderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/place", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public String addOrder(@RequestBody Order order)
	{
		orderService.addOrder(order);
		return "Order placed successfully";
	}
	
	@RequestMapping(value="/viewAllOrders", method=RequestMethod.GET, produces="application/json")
	public List<Order> viewAllOrders()
	{
		List<Order> orderList = orderService.viewAllOrders();
		return orderList;
	}
}
