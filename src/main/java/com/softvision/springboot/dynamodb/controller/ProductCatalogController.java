package com.softvision.springboot.dynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.springboot.dynamodb.common.ServiceConstants;
import com.softvision.springboot.dynamodb.entity.ProductCatalog;
import com.softvision.springboot.dynamodb.service.ProductCatalogService;

/**
 * @author arun.p
 *
 */
@RestController
@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.CATALOG_SERVICE)
public class ProductCatalogController {

	/** The product catelog service. */
	@Autowired
	private ProductCatalogService productCatelogService;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody List<ProductCatalog> findAll() {

		return productCatelogService.findAllProducts();
	}

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the product catalog
	 */
	@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.PRODUCTS + ServiceConstants.BACK_SLASH
			+ ServiceConstants.OPENING_CURLY_BRACKET + ServiceConstants.ID
			+ ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.GET)
	public @ResponseBody ProductCatalog findById(@PathVariable String id) {
		return productCatelogService.findProductById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id
	 *            the id
	 */
	@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.PRODUCTS + ServiceConstants.BACK_SLASH
			+ ServiceConstants.DELETE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
			+ ServiceConstants.ID + ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		productCatelogService.deleteProductById(id);
	}

	/**
	 * Adds the catalog entry.
	 *
	 * @param products
	 *            the products
	 * @return the response entity
	 */
	@RequestMapping(path = ServiceConstants.BACK_SLASH + ServiceConstants.PRODUCTS + ServiceConstants.BACK_SLASH
			+ ServiceConstants.ADD, method = RequestMethod.POST, headers = ServiceConstants.ACCEPT_APPLICATION_JSON)
	public ResponseEntity<List<ProductCatalog>> addCatalogEntry(@RequestBody List<ProductCatalog> products) {
		return new ResponseEntity<List<ProductCatalog>>(productCatelogService.saveNewProduct(products),
				HttpStatus.CREATED);
	}

	/**
	 * Update catalog entry.
	 *
	 * @param id
	 *            the id
	 * @param product
	 *            the product
	 * @return the response entity
	 */
	@RequestMapping(path =  ServiceConstants.BACK_SLASH + ServiceConstants.PRODUCTS + ServiceConstants.BACK_SLASH
			+ ServiceConstants.UPDATE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
			+ ServiceConstants.ID + ServiceConstants.CLOSING_CURLY_BRACKET, method = RequestMethod.PUT, headers = ServiceConstants.ACCEPT_APPLICATION_JSON)
	public ResponseEntity<ProductCatalog> updateCatalogEntry(@PathVariable String id,
			@RequestBody ProductCatalog product) {

		ProductCatalog newProduct = productCatelogService.updateProduct(product, id);
		if (null == newProduct) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ProductCatalog>(newProduct, HttpStatus.OK);
	}
}
