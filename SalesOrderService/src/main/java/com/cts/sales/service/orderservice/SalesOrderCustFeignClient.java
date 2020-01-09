package com.cts.sales.service.orderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.sales.service.domain.CustomerFeign;



@FeignClient(name="CustomerService")
@RibbonClient(name="CustomerService")
public interface SalesOrderCustFeignClient {
	@RequestMapping("/api/service1/customers/email/{emailId}")	
	public CustomerFeign getCustomerByEmail(@PathVariable("emailId") String emailId) ;
	
}
