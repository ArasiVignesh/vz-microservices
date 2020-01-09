/**
 * 
 */
package com.cts.sales.service.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sales.service.entity.OrderLineItem;
import com.cts.sales.service.entity.SalesOrder;
import com.cts.sales.service.repository.OrderLineItemRepository;
import com.cts.sales.service.repository.SalesOrderRepository;

/**
 * @author 259428
 *
 */
@Service
public class OrderService {

	@Autowired
	OrderLineItemRepository oliRepo;
	@Autowired
	SalesOrderRepository soRepo;
	
	public Long insertSalesOrder(SalesOrder order) {
		SalesOrder sOrder = soRepo.save(order);
		return sOrder.getSalesOrderId();
		
	}
	public void insertOrderLineItem(OrderLineItem oLineItem) {
		oliRepo.save(oLineItem) ;
	}
	
}
