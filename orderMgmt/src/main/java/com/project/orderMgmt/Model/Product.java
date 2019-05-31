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
@Table(name="Product", schema="SOURAV")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private int pid;

	@Column(name="Product_Name")
	private String pname;
	
	@Column(name="price")
	private double price;
	
	@Column(name="Qty")
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="Order_Id", referencedColumnName="Order_Id")
	private Order order;

	public String getPname() {
		return pname; 
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
	
}
