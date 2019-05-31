package com.project.orderMgmt.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Order_Id", schema="SOURAV")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_Id")
	private int oid;
	
	@Column(name="Customer_Phone")
	private long cphone;
	
	@Column(name="Customer_name")
	private String cname;
	
	@Column(name="Restaurant_name")
	private String restName;
	
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Product> product;
	
	@Column(name="status")
	private String status;
	
	@Column(name="Restaurant_Address")
	private String rest_address;
	
	@Column(name="Customer_Address")
	private String cust_address;
	
	@Column(name="Driver_Id")
	private long driver_id;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRest_address() {
		return rest_address;
	}

	public void setRest_address(String rest_address) {
		this.rest_address = rest_address;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public long getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(long driver_id) {
		this.driver_id = driver_id;
	}	
}
