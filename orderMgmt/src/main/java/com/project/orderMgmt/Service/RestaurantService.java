package com.project.orderMgmt.Service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.orderMgmt.DAO.RestaurantDao;
import com.project.orderMgmt.Model.Driver;
import com.project.orderMgmt.Model.FoodItems;
import com.project.orderMgmt.Model.Restaurant;

@Service("restaurantService")
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Transactional
	public void saveRestaurant(Restaurant restaurant)
	{
		restaurantDao.saveRestaurant(restaurant);
	}
	
	@Transactional
	public void removeRestaurant(Restaurant restaurant)
	{
		restaurantDao.removeRestaurant(restaurant);
	}
	
	@Transactional
	public void updateRestaurant(Restaurant restaurant)
	{
		restaurantDao.updateRestaurant(restaurant);
	}
	
	@Transactional
	public void addFoodItems(Restaurant restaurant)
	{
		restaurantDao.addFoodItems(restaurant);
	}
	
	@Transactional
	public Restaurant getItems(Integer id)
	{
		return restaurantDao.getItems(id);
	}
	
	@Transactional
	public List<Restaurant> getAllRestaurants()
	{
		List<Restaurant> restaurantList=restaurantDao.getAllRestaurants();
		return restaurantList;
	}
	
	@Transactional
	public List<FoodItems> getAllFoodItems(int id)
	{
		List<FoodItems> foodItems = restaurantDao.getAllFoodItems(id);
		return foodItems;
	}
	
	@Transactional
	public void deleteRestaurantById(int id)
	{
		restaurantDao.deleteRestaurantById(id);
	}
	
	@Transactional
	public List<Restaurant> getRestaurantById(int id)
	{
		List<Restaurant> restaurantDetails = restaurantDao.getRestaurantById(id);
		return restaurantDetails;
	}
	
	@Transactional
	public void modifyRestaurant(Restaurant restaurant, int id)
	{
		restaurantDao.modifyRestaurant(restaurant, id);
	}
	
	@Transactional
	public List<Restaurant> filterRestaurant(int id)
	{
		List<Restaurant> filterList=restaurantDao.filterRestaurant(id);
		return filterList;
	}
}
 