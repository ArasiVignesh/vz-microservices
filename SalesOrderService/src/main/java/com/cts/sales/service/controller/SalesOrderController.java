/**
 * 
 */
package com.cts.sales.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.sales.service.domain.CustomerFeign;
import com.cts.sales.service.domain.ItemFeign;
import com.cts.sales.service.domain.Order;
import com.cts.sales.service.entity.OrderLineItem;
import com.cts.sales.service.entity.SalesOrder;
import com.cts.sales.service.orderservice.OrderService;
import com.cts.sales.service.orderservice.SalesOrderCustFeignClient;
import com.cts.sales.service.orderservice.SalesOrderItemFeignClient;
import com.cts.sales.service.repository.OrderLineItemRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author 259428
 *
 */

@RefreshScope
@Controller
@RequestMapping ("/api/services3")
public class SalesOrderController {
	@Autowired
	SalesOrderCustFeignClient custClient;
	@Autowired
	SalesOrderItemFeignClient itemClient;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderLineItemRepository linerepo;
	@RequestMapping(method = RequestMethod.POST , value= "/orders")
	@ResponseBody
    @HystrixCommand(fallbackMethod="defaultMe")
	public Long insertOrderDetails(@RequestBody Order order) {
		System.out.println("Order Application started");
		Long orderId = 0l;
		//TODO: validate customer by calling customer service with email id
		//TODO: validate items by calling item service with item name
		CustomerFeign cClient = custClient.getCustomerByEmail(order.getCustEmailId());
		
		if(cClient != null) {
			System.out.println("Customer : " + cClient.getEmail() + " Found");

			SalesOrder so = new SalesOrder();
			OrderLineItem li = new OrderLineItem();
			so.setDate(order.getOrderDate());
			so.setDescription(order.getOrderDecription());
			so.setEmailId(order.getCustEmailId());
			//TODO fetch item price from itemservice and set the below
			
			Double price = 0.0;
			boolean itemAvailable = false;
			
			for(String itemName:order.getItemNames()) {
				ItemFeign iClient = itemClient.getItemByName(itemName);
				if(iClient != null) {
					System.out.println("Item : " + iClient.getitemName() + " Found and Price is : " + iClient.getPrice());
					price += iClient.getPrice();
					itemAvailable = true;
				}
			}
			
			if(itemAvailable) {
				so.setPrice(price);
				orderId = orderService.insertSalesOrder(so);
				li.setOrderId(orderId);
				for(String itemName:order.getItemNames()) {
					li.setOrderId(orderId);
					li.setItemName(itemName);
					li.setQuantity(1);
					linerepo.save(li);
				}
			} else {
				System.out.println("Customer Found but Item Name not available...");
			}
		} else {
			System.out.println("Customer not found.... Order not Inserted... ");
		}
		return orderId;
		
	}
	  private Long defaultMe(Order order){
	      System.out.println("Hystrix default method called");
	      
	      return null;
	   }
}
