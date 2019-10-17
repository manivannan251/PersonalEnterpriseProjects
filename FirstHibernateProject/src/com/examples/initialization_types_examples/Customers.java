package com.examples.initialization_types_examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Customers {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	
	@Column(name="cust_name")
	private String name;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="orders",joinColumns = @JoinColumn(name="user_id"))
	private Set<Orders> ordersList= new HashSet<Orders>();

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(Set<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
	

}
