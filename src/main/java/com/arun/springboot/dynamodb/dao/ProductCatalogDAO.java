package com.arun.springboot.dynamodb.dao;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.arun.springboot.dynamodb.entity.ProductCatalog;

/**
 * @author arun.p
 * The Interface ProductCatalogDAO.
 *
 */
@EnableScan
public interface ProductCatalogDAO extends CrudRepository<ProductCatalog, String>{
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product catalog
	 */
	ProductCatalog findById(String id);
	
	/** returns all products
	 */
	List<ProductCatalog> findAll();
	

}
