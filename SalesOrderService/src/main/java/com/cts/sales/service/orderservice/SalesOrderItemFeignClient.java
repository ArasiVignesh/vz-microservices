package com.cts.sales.service.orderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.sales.service.domain.ItemFeign;



@FeignClient(name="ItemService")
@RibbonClient(name="ItemService")
public interface SalesOrderItemFeignClient {
	
	@RequestMapping("/api/service2/item/{itemName}")
	public ItemFeign getItemByName(@PathVariable("itemName") String itemName);

}
