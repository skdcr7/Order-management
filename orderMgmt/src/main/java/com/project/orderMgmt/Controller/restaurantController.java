package com.project.orderMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.FoodItems;
import com.project.orderMgmt.Model.Restaurant;
import com.project.orderMgmt.Service.RestaurantService;

@RestController
@RequestMapping(value="/restro", produces="application/json")
public class restaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(value="/addRestro", method=RequestMethod.POST, consumes="application/json")
	public String saveRestaurant(@RequestBody Restaurant restaurant)
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
	
	@RequestMapping(value="/addFoodItems", method=RequestMethod.POST, consumes="application/json")
	public String addFoodItems(@RequestBody Restaurant restaurant)
	{    
		System.err.println("restaurantController.addFoodItems()----->"+restaurant.toString());
		System.err.println(" foodItems : " + restaurant.getFoodItems());
	//	System.err.println("size : " + restaurant.getFoodItems().size());
		restaurantService.addFoodItems(restaurant);
		return "Items added successfully";
	}
	
	/*@RequestMapping(value="/getItems", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<FoodItems>> getRestaurantById(@RequestBody Restaurant restaurant)
	{
		//List<FoodItems> items=restaurantService.getRestaurantById(restaurant);
		//return new ResponseEntity<List<FoodItems>>(items,HttpStatus.OK);
		
	}*/
	
	@RequestMapping(value="/getItems/{id}", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Restaurant getItems(@PathVariable("id") Integer id)
	{
		return restaurantService.getItems(id);
	}
	
	@RequestMapping(value="/getAllRestaurants", method=RequestMethod.GET, produces="application/json")
	public List<Restaurant> getAllRestaurants()
	{
		List<Restaurant> restaurantList = restaurantService.getAllRestaurants();
		return restaurantList;
	}
	
	@RequestMapping(value="/getAllfoodItems/{id}", method=RequestMethod.POST, consumes="application/json", produces="application/json" )
	public List<FoodItems> getAllFoodItems(@PathVariable("id") int id)
	{
		List<FoodItems> foodItems = restaurantService.getAllFoodItems(id);
		return foodItems;
	}
	
	@RequestMapping(value="/deleteRestaurantById/{id}", method=RequestMethod.POST, produces="application/json")
	public String deleteRestaurantById(@PathVariable("id") int id)
	{
		restaurantService.deleteRestaurantById(id);
		return "Restaurant deleted successfully";
	}
	
	@RequestMapping(value="/getRestaurantById/{id}", method=RequestMethod.POST)
	public List<Restaurant> getRestaurantById(@PathVariable("id") int id)
	{
		List<Restaurant> restaurantDetails = restaurantService.getRestaurantById(id);
		return restaurantDetails;
	}
	
	@RequestMapping(value="/filterRestaurant/{id}", method=RequestMethod.POST)
	public List<Restaurant> filterRestaurant(@PathVariable("id") int id)
	{
		List<Restaurant> filterList=restaurantService.filterRestaurant(id);
		return filterList;
	}
	
}
