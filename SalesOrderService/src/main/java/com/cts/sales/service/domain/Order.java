package com.cts.sales.service.domain;

import java.util.Date;
import java.util.List;



public class Order {
	
	
	private String orderDecription;
	private Date orderDate;
	private String custEmailId;
	private List<String> itemNames;
	
	public String getOrderDecription() {
		return orderDecription;
	}
	public void setOrderDecription(String orderDecription) {
		this.orderDecription = orderDecription;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustEmailId() {
		return custEmailId;
	}
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
	public List<String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}

}
