package com.arun.springboot.dynamodb.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.springboot.dynamodb.dao.ProductCatalogDAO;
import com.arun.springboot.dynamodb.entity.ProductCatalog;
import com.arun.springboot.dynamodb.service.ProductCatalogService;

/**
 * The Class ProductCatalogServiceImpl.
 *
 * @author arun.p
 */
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	/** The product catelog dao. */
	@Autowired
	private ProductCatalogDAO productCatelogDao;

	/* (non-Javadoc)
	 * @see com.example.crudspringbootdynamodb.service.ProductCatalogService#findAllProducts()
	 */
	@Override
	public List<ProductCatalog> findAllProducts() {
		return productCatelogDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.example.crudspringbootdynamodb.service.ProductCatalogService#findProductById(java.lang.String)
	 */
	@Override
	public ProductCatalog findProductById(String id) {
		return productCatelogDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.example.crudspringbootdynamodb.service.ProductCatalogService#deleteProductById(java.lang.String)
	 */
	@Override
	public void deleteProductById(String id) {
		productCatelogDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.example.crudspringbootdynamodb.service.ProductCatalogService#updateProduct(com.example.crudspringbootdynamodb.entity.ProductCatalog, java.lang.String)
	 */
	@Override
	public ProductCatalog updateProduct(ProductCatalog product, String id) {

		ProductCatalog productCatalog = productCatelogDao.findById(id);

		if (productCatalog == null) {
			return null;
		}

		productCatalog.setInventoryLow(product.getInventoryLow());
		productCatalog.setPrice(product.getPrice());
		productCatalog.setProductName(product.getProductName());
		productCatalog.setQuantity(product.getQuantity());
		productCatalog.setCurrencyCode(product.getCurrencyCode());

		return productCatelogDao.save(product);
	}

	/** 
	 * save new product
	 * @param products
	 * return list of ProductCatelog
	 */
	@Override
	public List<ProductCatalog> saveNewProduct(List<ProductCatalog> products) {
		
		
		
		
		return (List<ProductCatalog>) productCatelogDao.save(products);
	}

}
