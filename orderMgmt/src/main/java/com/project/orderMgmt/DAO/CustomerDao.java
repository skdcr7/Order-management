package com.project.orderMgmt.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.orderMgmt.Model.Customer;

@Repository
public class CustomerDao extends AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	
	public String saveCustomer(Customer customer)
	{
		
		Session session = this.sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
		return "Insertion Successful";
	}
	
	public void removeCustomer(Customer customer)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	}
	
	public void updateCustomer(Customer customer)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(customer);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Customer> getCustomerByEmail(String email)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("email", email));
		List<Customer> list = cr.list();	
		tx.commit();
		session.close();
		return list;
	}
}
