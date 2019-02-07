package com.arun.springboot.dynamodb.service;

import java.util.List;

import com.arun.springboot.dynamodb.entity.ProductCatalog;

/**
 * @author arun.p
 *
 */
public interface ProductCatalogService {

	/**
	 * @return all products
	 */
	List<ProductCatalog> findAllProducts();

	/**
	 * @param id
	 * @return ProductCatalog
	 */
	ProductCatalog findProductById(String id);

	/**
	 * @param id
	 */
	void deleteProductById(String id);

	/**
	 * @param products
	 * @param id 
	 * @return ProductCatalog
	 */
	List<ProductCatalog> saveNewProduct(List<ProductCatalog> products);

	ProductCatalog updateProduct(ProductCatalog product, String id);

}
