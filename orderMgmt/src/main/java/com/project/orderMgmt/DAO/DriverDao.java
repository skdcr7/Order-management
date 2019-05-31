package com.project.orderMgmt.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.orderMgmt.Model.Driver;
import com.project.orderMgmt.Model.Order;

@Repository
public class DriverDao extends AbstractDao {

	private static final String Active = null;
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	public String saveDriver(Driver driver)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.persist(driver);
		tx.commit();
		session.close();
		return "Insertion Successful";
	}
	
	public void removeDriver(Driver driver)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(driver);
		tx.commit();
		session.close();
	}
	
	public void updateDriver(Driver driver)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(driver);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> getAllDrivers()
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Driver> driverList = session.createQuery("from Driver").list();
		tx.commit();
		session.close();
		return driverList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> getActiveDrivers()
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Driver> activeDrivers = session.createQuery("from Driver where status = 'Active'").list();
		tx.commit();
		session.close();
		return activeDrivers;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Order> showAssignedOrders(long id)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Order> res= new ArrayList<>();
		List<Object[]> result = session.createSQLQuery("select order_id,customer_name,customer_address,customer_phone,restaurant_name,restaurant_address from order_id where status = 'Pending' and driver_id ="+id+"").list();
		for(Object[] obj:result) {
			Order order= new Order();
			order.setOid(Integer.parseInt(obj[0].toString()));
			order.setCname(obj[1].toString());
			order.setCust_address(obj[2].toString());
			order.setCphone(Long.parseLong(obj[3].toString()));
			order.setRestName(obj[4].toString());
			order.setRest_address(obj[5].toString());
			res.add(order);
		}
		
		tx.commit();
		session.close();
		return res;
		
	}
	
	public void completeOrder(long phn)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("update Order_Id set status = 'Completed' where driver_id ="+phn+"").executeUpdate();
		session.createSQLQuery("update Driver set status = 'Active' where phone = "+phn+"").executeUpdate();
		tx.commit();
		session.close();
	}
	
	public void completingOrder(long phn)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("update Order_Id set status = 'Completed' where driver_id ="+phn+"").executeUpdate();
		session.createSQLQuery("update Driver set status = 'Active' where phone = "+phn+"").executeUpdate();
		tx.commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> getDriverByPhone(long phn)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Object[]> driverList=session.createSQLQuery("select * from driver where phone = "+phn+"").list();
		List<Driver> list = new ArrayList<>();
		for(Object[] obj:driverList)
		{
			Driver driver = new Driver();
			driver.setPhn(Long.parseLong(obj[0].toString()));
			driver.setEmail(obj[1].toString());
			driver.setLicense(Long.parseLong(obj[2].toString()));
			driver.setName(obj[3].toString());
			driver.setStatus(obj[4].toString());
			list.add(driver);
		}
		tx.commit();
		session.close();
		return list;
	}
	
	public void deleteDriverByPhone(long phn)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("delete from driver where phone ="+phn+"").executeUpdate();
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Driver> getDriverByEmail(String email)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Driver.class);
		cr.add(Restrictions.eq("email", email));
		List<Driver> list = cr.list();
		tx.commit();
		session.close();
		return list;
	}
}
