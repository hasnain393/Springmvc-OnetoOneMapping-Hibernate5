package com.lti.springmvc.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
	private int  address_id;
	private String city="enter your city name";
	private String state="enter your city name";
	

	public Address() {
		// TODO Auto-generated constructor stub
	}


	public Address(int address_id, String city, String state) {
		super();
		this.address_id = address_id;
		this.city = city;
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", city=" + city + ", state=" + state + "]";
	}


	

}
