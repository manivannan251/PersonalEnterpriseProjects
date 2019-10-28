package com.example.rest.services.Messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {
	
	private long id;
	
	private String message;
	
	private Date dateCreated;
	
	private String author;
	
	public Message() {
		
	}

	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.dateCreated = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", dateCreated=" + dateCreated + ", author=" + author
				+ "]";
	}
	
	
	
	
}
