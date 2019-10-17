package com.examples.initialization_types_examples;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Orders {
	
	@Column
	private String name;
	
	@Column
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
