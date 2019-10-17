package com.example.hibernate.object.types;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@NamedQuery(name = "Messages.id",query = "from Messages where id>?0")
@SelectBeforeUpdate(value = true)
public class Messages {
	
	@Override
	public String toString() {
		return "Messages [id=" + id + ", message=" + message + "]";
	}

	@Id @GeneratedValue
	private int id;
	
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
