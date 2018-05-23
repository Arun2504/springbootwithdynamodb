package com.softvision.springboot.dynamodb.entity;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCatalog.
 */
@DynamoDBTable(tableName="ProductCatalog")
public class ProductCatalog {

	/** The id. */
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String id;

	/** The product name. */
	@DynamoDBAttribute
	private String productName;
	
	/** The quantity. */
	@DynamoDBAttribute
	private Integer quantity;
	
	/** The inventory low. */
	@DynamoDBAttribute
	private Boolean inventoryLow;
	
	/** The price. */
	@DynamoDBAttribute
	private BigDecimal price;
	
	/** The currency code. */
	@DynamoDBAttribute
	private String currencyCode;

	/**
	 * Instantiates a new product catalog.
	 */
	public ProductCatalog() {
		
	}

	/**
	 * Instantiates a new product catalog.
	 *
	 * @param productName the product name
	 * @param quantity the quantity
	 * @param inventoryLow the inventory low
	 * @param price the price
	 * @param currencyCode the currency code
	 */
	public ProductCatalog(String productName, Integer quantity, Boolean inventoryLow,
			BigDecimal price, String currencyCode) {
		this.productName = productName;
		this.quantity = quantity;
		this.inventoryLow = inventoryLow;
		this.price = price;
		this.currencyCode = currencyCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the inventory low.
	 *
	 * @return the inventory low
	 */
	public Boolean getInventoryLow() {
		return inventoryLow;
	}

	/**
	 * Sets the inventory low.
	 *
	 * @param inventoryLow the new inventory low
	 */
	public void setInventoryLow(Boolean inventoryLow) {
		this.inventoryLow = inventoryLow;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Gets the currency code.
	 *
	 * @return the currency code
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Sets the currency code.
	 *
	 * @param currencyCode the new currency code
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
