package com.project.orderMgmt.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer", schema = "SOURAV")
public class Customer {

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Id
	@Column(name="Phone")
	private long phn;
	
	@Column(name="Adress")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhn() {
		return phn;
	}

	public void setPhn(long phn) {
		this.phn = phn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
