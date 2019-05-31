package com.project.orderMgmt.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FoodItems", schema="SOURAV")
public class FoodItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="food_id")
	private int food_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="Restaurant_Id", referencedColumnName="Restaurant_Id")
	private Restaurant restaurant;

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/*@Override
	public String toString() {
		return "FoodItems [food_id=" + food_id + ", name=" + name + ", price=" + price + ", restaurant=" + restaurant.getRest_Id()
				+ "]";
	}*/
	
}
