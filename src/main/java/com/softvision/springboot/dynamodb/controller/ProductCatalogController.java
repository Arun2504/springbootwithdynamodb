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

import com.softvision.springboot.dynamodb.entity.ProductCatalog;
import com.softvision.springboot.dynamodb.service.ProductCatalogService;


/**
 * @author arun.p
 *
 */
@RestController
public class ProductCatalogController {

	/** The product catelog service. */
	@Autowired
	private ProductCatalogService productCatelogService;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@RequestMapping(path="/catalogService/products", method=RequestMethod.GET)
	public @ResponseBody List<ProductCatalog> findAll() {
		
		
		return productCatelogService.findAllProducts();
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product catalog
	 */
	@RequestMapping(path="/catalogService/products/{id}", method=RequestMethod.GET)
	public @ResponseBody ProductCatalog findById(@PathVariable String id) {
		return productCatelogService.findProductById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@RequestMapping(path="/catalogService/products/delete/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		 productCatelogService.deleteProductById(id);
	}

	/**
	 * Adds the catalog entry.
	 *
	 * @param products the products
	 * @return the response entity
	 */
	@RequestMapping(path="/catalogService/products/add", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<List<ProductCatalog>> addCatalogEntry(@RequestBody List<ProductCatalog> products) {
		return new ResponseEntity<List<ProductCatalog>> (productCatelogService.saveNewProduct(products),HttpStatus.CREATED);
	}
	
	/**
	 * Update catalog entry.
	 *
	 * @param id the id
	 * @param product the product
	 * @return the response entity
	 */
	@RequestMapping(path="/catalogService/products/update/{id}", method=RequestMethod.PUT, headers="Accept=application/json")
	public ResponseEntity<ProductCatalog> updateCatalogEntry(@PathVariable String id, @RequestBody ProductCatalog product) {
		
		ProductCatalog newProduct = productCatelogService.updateProduct(product,id);
		if(null == newProduct) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ProductCatalog>(newProduct, HttpStatus.OK);
	}
}
