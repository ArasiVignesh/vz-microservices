package com.cts.sales.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.sales.service.entity.OrderLineItem;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long>{
	
}
