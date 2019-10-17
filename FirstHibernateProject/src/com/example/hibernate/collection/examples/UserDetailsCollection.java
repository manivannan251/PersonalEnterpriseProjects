package com.example.hibernate.collection.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity(name = "udc")
public class UserDetailsCollection {
	
	@Id @GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@ElementCollection
	@JoinTable(name = "user_address",joinColumns = @JoinColumn(name="user_id"))
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = {@Column(name = "address_id")}, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<AddressCollection> addresList = new ArrayList<AddressCollection>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<AddressCollection> getAddresList() {
		return addresList;
	}

	public void setAddresList(Collection<AddressCollection> addresList) {
		this.addresList = addresList;
	}

	
	
	
}
