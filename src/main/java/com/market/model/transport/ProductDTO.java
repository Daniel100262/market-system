package com.market.model.transport;

import java.io.Serializable;
import java.util.UUID;

import com.market.model.Category;

public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private String name;
	
	private String description;
	
	private String price;
	
	private Category category;

	public ProductDTO(UUID id, String name, String description, String price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
