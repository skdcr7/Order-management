package com.project.orderMgmt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.orderMgmt.DAO.DriverDao;
import com.project.orderMgmt.Model.Driver;
import com.project.orderMgmt.Model.Order;

@Service("driverService")
public class DriverService {

	@Autowired
	DriverDao driverDao;
	
	@Transactional
	public void saveDriver(Driver driver)
	{
		driverDao.saveDriver(driver);
	}
	
	@Transactional
	public void removeDriver(Driver driver)
	{
		driverDao.removeDriver(driver);
	}
	
	@Transactional
	public void updateDriver(Driver driver)
	{
		driverDao.updateDriver(driver);
	}
	
	@Transactional
	public List<Driver> getAllDrivers()
	{
		List<Driver> driverList = driverDao.getAllDrivers();
		return driverList;
	}
	
	@Transactional
	public List<Driver> getActiveDrivers()
	{
		List<Driver> activeDrivers = driverDao.getActiveDrivers();
		return activeDrivers;
	}
	
	@Transactional
	public List<Order> showAssignedOrders(long id)
	{
		List<Order> assignedOrders = driverDao.showAssignedOrders(id);
		return assignedOrders;
	}
	
	@Transactional
	public void completeOrder(long phn)
	{
		driverDao.completeOrder(phn);
	}
	
	@Transactional
	public void completingOrder(long phn)
	{
		driverDao.completingOrder(phn);
	}
	
	@Transactional
	public List<Driver> getDriverByPhone(long phn)
	{
		List<Driver> driverList = driverDao.getDriverByPhone(phn);
		return driverList;
	}
	
	@Transactional
	public void deleteDriverByPhone(long phn)
	{
		driverDao.deleteDriverByPhone(phn);
	}
	
	@Transactional
	public List<Driver> getDriverByEmail(String email)
	{
		List<Driver> driverList = driverDao.getDriverByEmail(email);
		return driverList;
	}
}
