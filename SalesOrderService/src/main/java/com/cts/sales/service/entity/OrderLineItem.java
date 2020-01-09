/**
 * 
 */
package com.cts.sales.service.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author 259428
 *
 */

@Entity
public class OrderLineItem implements Serializable{
	
	private static final long serialVersionUID= 1L;
	@Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="lineitem_generator")
	   @SequenceGenerator(name="lineitem_generator", sequenceName="lineitem_seq")
	   @Basic(optional = false)
	   @Column(name = "id",unique=true, nullable = false, updatable = false)
		private long orderLineItemId;
	
	@Column
	private String itemName;
	@Column
	private int quantity;
	@Column
	private long orderId;
	public long getOrderLineItemId() {
		return orderLineItemId;
	}
	public void setOrderLineItemId(long orderLineItemId) {
		this.orderLineItemId = orderLineItemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderLineItem [orderLineItemId=" + orderLineItemId + ", itemName=" + itemName + ", quantity=" + quantity
				+ ", orderId=" + orderId + "]";
	}
	

}