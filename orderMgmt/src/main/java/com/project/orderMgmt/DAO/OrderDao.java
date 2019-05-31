package com.project.orderMgmt.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.orderMgmt.Model.Order;

@Repository
public class OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	public void addOrder(Order order)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(order);
		for(int index=0;index<order.getProduct().size();index++)
		{
			order.getProduct().get(index).setOrder(order);
			session.save(order.getProduct().get(index));
		}
		tx.commit();
		session.close();	
	}
	
	public void assignDriver(int oid, long did)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("update order_id set driver_id = "+did+" where order_id = "+oid+"").executeUpdate();
		session.createSQLQuery("update driver set status = 'Engaged' where phone = "+did+"").executeUpdate();
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> viewAllOrders()
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> result = new ArrayList<>();
		List<Object[]> orderList=session.createSQLQuery("select * from Order_Id").list();
		for(Object[] obj:orderList)
		{
			Order order = new Order();
			order.setOid(Integer.parseInt(obj[0].toString()));
			order.setCname(obj[1].toString());
			order.setCphone(Long.parseLong(obj[2].toString()));
			order.setCust_address(obj[3].toString());
			order.setDriver_id(Long.parseLong((obj[4].toString())));
			order.setRestName(obj[5].toString());
			order.setRest_address(obj[6].toString());
			order.setStatus(obj[7].toString());
			result.add(order);
		}
		tx.commit();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> showPendingOrders()
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> result = new ArrayList<>();
		List<Object> pendingOrders = session.createSQLQuery("select order_id from Order_Id where driver_id=0").list();
		for(Object obj:pendingOrders)
		{
			Order order = new Order();
			order.setOid((Integer.parseInt((obj.toString()))));
			result.add(order);
		}
		tx.commit();
		session.close();
		return result;
	}
	
}
