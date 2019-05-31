package com.project.orderMgmt.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.orderMgmt.Model.FoodItems;
import com.project.orderMgmt.Model.Restaurant;

@Repository
public class RestaurantDao extends AbstractDao {

	@Autowired
	private SessionFactory  sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	public String saveRestaurant(Restaurant  restaurant)
	{
		
		Session session = this.sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.persist(restaurant);
		tx.commit();
		session.close();
		return "Insertion Successful";
	}
	
	public void removeRestaurant(Restaurant restaurant)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(restaurant);
		tx.commit();
		session.close();
	}
	
	public void updateRestaurant(Restaurant restaurant)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(restaurant);
		tx.commit();
		session.close();
	}
	
	public void addFoodItems(Restaurant restaurant)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.err.println("Restaurent dto1: " + restaurant.toString());
		session.save(restaurant);
		System.err.println("Restaurent dto2: " + restaurant.toString());
		if(restaurant != null && restaurant.getFoodItems() != null) 
		{
			System.err.println("Restaurent dto3: " + restaurant.toString());
			for(int index=0;index<restaurant.getFoodItems().size();index++)
			{
				System.err.println("Restaurent dto4: " + restaurant.toString());
				restaurant.getFoodItems().get(index).setRestaurant(restaurant);
				System.err.println("Restaurent dto5: " + restaurant.toString());
				session.save(restaurant.getFoodItems().get(index));
				System.err.println("Restaurent dto6: " + restaurant.toString());
			}
			System.err.println("Restaurent dto7: " + restaurant.toString());
		}
		System.err.println("Restaurent dto8: " + restaurant.toString());
		tx.commit();
		session.close();
	}
	
	public Restaurant getItems(Integer id)
	{
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Restaurant res= (Restaurant) session.get(Restaurant.class, id);
			tx.commit();
			session.close();
			return res;	
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> getAllRestaurants()
	{
		Session session =this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Object[]> restaurantList = session.createSQLQuery("select * from Restaurant").list();
		List<Restaurant> list = new ArrayList<>();
		for(Object[] obj:restaurantList)
		{
			Restaurant restaurant = new Restaurant();
			restaurant.setRest_Id(Integer.parseInt(obj[0].toString()));
			restaurant.setAddress(obj[1].toString());
			restaurant.setName(obj[2].toString());
			restaurant.setPhn(Long.parseLong(obj[3].toString()));
			restaurant.setPicture(obj[4].toString());
			restaurant.setPrice(Double.parseDouble(obj[5].toString()));
			list.add(restaurant);
			
		}
		tx.commit();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<FoodItems> getAllFoodItems(int id)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<FoodItems> list = new ArrayList<>();
		List<Object[]> foodItems = session.createSQLQuery(" select * from fooditems where restaurant_id="+id+" ").list();
		for(Object[] obj:foodItems)
		{
			FoodItems items = new FoodItems();
			items.setFood_id(Integer.parseInt(obj[0].toString()));
			items.setName(obj[1].toString());
			items.setPrice(Double.parseDouble(obj[2].toString()));
			list.add(items);
		}
		tx.commit();
		session.close();
		return list;
	}
	
	public void deleteRestaurantById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("delete from fooditems where restaurant_id = "+id+"").executeUpdate();
		session.createSQLQuery("delete from restaurant where restaurant_id = "+id+"").executeUpdate();
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Object[]> restaurantDetails=session.createSQLQuery("select * from restaurant where restaurant_id = "+id+"").list();
		List<Restaurant> list = new ArrayList<>();
		for(Object[] obj:restaurantDetails)
		{
			Restaurant restaurant = new Restaurant();
			restaurant.setRest_Id(Integer.parseInt(obj[0].toString()));
			restaurant.setAddress(obj[1].toString());
			restaurant.setName(obj[2].toString());
			restaurant.setPhn(Long.parseLong(obj[3].toString()));
			restaurant.setPicture(obj[4].toString());
			restaurant.setPrice(Double.parseDouble(obj[5].toString()));
			list.add(restaurant);
		}
		tx.commit();
		session.close();
		return list;
	}
	
	public void modifyRestaurant(Restaurant restaurant, int id)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "update restaurant set address = '" + restaurant.getAddress() + "', name = '" + restaurant.getName() + "', phone= " + restaurant.getPhn() +
				", price = " + restaurant.getPrice() + " where restaurant_id = " + id ;
		System.err.println("[RestaurantDao][modifyRestaurant]Query : " + queryString);
		session.createSQLQuery(queryString).executeUpdate();
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> filterRestaurant(int id)
	{
		List<Restaurant> filterList=new ArrayList<>();
		List<Object[]> list;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(id==0)
		{
			  list = session.createSQLQuery("select * from restaurant order by price").list();
		}
		else
		{
			 list = session.createSQLQuery("select * from restaurant order by price desc").list();
		}
		for(Object[] obj:list)
		{
			Restaurant restaurant = new Restaurant();
			restaurant.setRest_Id(Integer.parseInt(obj[0].toString()));
			restaurant.setAddress(obj[1].toString());
			restaurant.setName(obj[2].toString());
			restaurant.setPhn(Long.parseLong(obj[3].toString()));
			restaurant.setPicture(obj[4].toString());
			restaurant.setPrice(Double.parseDouble(obj[5].toString()));
			filterList.add(restaurant);
		}
		tx.commit();
		session.close();
		return filterList;
	}
}
