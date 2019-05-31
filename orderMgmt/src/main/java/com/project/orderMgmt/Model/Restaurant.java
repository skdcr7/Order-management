package com.project.orderMgmt.Model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Restaurant", schema = "SOURAV")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Restaurant_Id")
	private int rest_Id;

	@Column(name = "address")
	private String address;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private long phn;

	@Column(name = "price")
	private double price;

	@Column(name = "picture")
	private String picture;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(value = CascadeType.ALL)
	private List<FoodItems> foodItems;

	public Restaurant(int rest_Id, String address, String name, long phn, double price, String picture,
			List<FoodItems> foodItems) {
		super();
		this.rest_Id = rest_Id;
		this.address = address;
		this.name = name;
		this.phn = phn;
		this.price = price;
		this.picture = picture;
		this.foodItems = foodItems;
	}

	public Restaurant() {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public long getPhn() {
		return phn;
	}

	public void setPhn(long phn) {
		this.phn = phn;
	}

	public int getRest_Id() {
		return rest_Id;
	}

	public void setRest_Id(int rest_Id) {
		this.rest_Id = rest_Id;
	}

	public List<FoodItems> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "Restaurant [rest_Id=" + rest_Id + ", address=" + address + ", name=" + name + ", phn=" + phn
				+ ", price=" + price + ", picture=" + picture + ", foodItems=" + foodItems + "]";
	}
	
	

}
