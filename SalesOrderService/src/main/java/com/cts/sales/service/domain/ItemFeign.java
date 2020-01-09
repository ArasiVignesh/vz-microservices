package com.cts.sales.service.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class ItemFeign {

	
	private Long id;
	
	private String itemName;
	
	private String description;
	
	private Double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getitemName() {
		return itemName;
	}
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + itemName + ", description=" + description + ", price=" + price + "]";
	}
	

}
