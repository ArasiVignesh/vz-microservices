/**
 * 
 */
package com.cts.sales.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.sales.service.entity.SalesOrder;

/**
 * @author 259428
 *
 */
@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long>{

}
