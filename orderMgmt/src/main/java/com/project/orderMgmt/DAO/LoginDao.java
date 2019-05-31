package com.project.orderMgmt.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.orderMgmt.Model.Login;
import com.project.orderMgmt.Service.LoginService;

@Repository
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	LoginService loginService;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	public void savePassword(Login login)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(login);
		tx.commit();
		session.close();
	}
	
	public String verify(Login login)
	{
		NativeQuery query;
		String str;
		Session session = sessionFactory.openSession();
			login.setPassword(loginService.getMd5(login.getPassword()));
			query = session.createNativeQuery("select 1 from Login where username ='"+login.getUsername()+"'and password = '"+login.getPassword()+"'");
			if(query.uniqueResult() !=null)
			{
				str="Login successful";
			}
			else
			{
				str="Login failed";
			}
			session.close();
			return str;
	}
	
	public String verifyAdmin(Login login)
	{
		String str;
		Session session = sessionFactory.openSession();
		login.setPassword(loginService.getMd5(login.getPassword()));
		NativeQuery query = session.createNativeQuery("select 1 from Login where username = 'Admin' and password = '"+login.getPassword()+"'");
		 if(query.uniqueResult() !=null)
		 {
			str = "Admin login Successful";
		 }
		 else
		 {
			 str="Login Failed";
		 }
		 session.close();
		 return str;
	}
	
	public String verifyDriver(Login login)
	{
		String str;
		Session session = sessionFactory.openSession();
		login.setPassword(loginService.getMd5(login.getPassword()));
		NativeQuery query = session.createNativeQuery("select 1 from Login where username = '"+login.getUsername()+"'and password = '"+login.getPassword()+"'");
		if(query.uniqueResult() !=null)
		{
			str="Driver login successful";
		}
		else
		{
			str="Driver Login failed";
		}
		session.close();
		return str;
	}
	
}
