package com.project.orderMgmt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.orderMgmt.DAO.OrderDao;
import com.project.orderMgmt.Model.Order;

@Service("orderService")
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Transactional
	public void addOrder(Order order)
	{
		orderDao.addOrder(order);
	}
	
	@Transactional
	public void assignDriver(int oid, long did)
	{
		orderDao.assignDriver(oid, did);
	}
	
	@Transactional
	public List<Order> viewAllOrders()
	{
		List<Order> orderList = orderDao.viewAllOrders();
		return orderList;
	}
	
	@Transactional
	public List<Order> showPendingOrders()
	{
		List<Order> pendingOrders = orderDao.showPendingOrders();
		return pendingOrders;
	}
}
