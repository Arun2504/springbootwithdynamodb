package com.softvision.springboot.dynamodb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.softvision.springboot.dynamodb.dao.ProductCatalogDAO;
import com.softvision.springboot.dynamodb.entity.Employee;
import com.softvision.springboot.dynamodb.entity.ProductCatalog;

/**
 * The Class CrudSpringbootDynamodbApplication.
 */
/**
 * @author arun.p
 *
 */
@SpringBootApplication
public class CrudSpringbootDynamodbApplication {

	/** The dynamo DB mapper. */
	private DynamoDBMapper dynamoDBMapper;

    /** The amazon dynamo DB. */
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
	/** The dao. */
	@Autowired
	ProductCatalogDAO dao;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		
		createProductCatalogTable();
		/*ProductCatalog product1 = new ProductCatalog("Book", 10, false, new BigDecimal("10.99"), "USD");
		dao.save(product1);
		
		ProductCatalog product2 = new ProductCatalog("Bag", 10, false, new BigDecimal("5.99"), "USD");
		dao.save(product2);	*/	
		
		deleteEmployeeTable();
		createEmployeeTable();
	}

	private void createEmployeeTable() {
		try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

           CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Employee.class);

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            
        }
		
	}
	private void deleteEmployeeTable() {
		try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(Employee.class);

            if(null != dynamoDBMapper.getTableModel(Employee.class)) {
            amazonDynamoDB.deleteTable(deleteTableRequest);
            }

        } catch (ResourceInUseException e) {
            
        }
		
	}

	/**
	 * Creates the product catalog table.
	 */
	public void createProductCatalogTable(){
        try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductCatalog.class);

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            
        }
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootDynamodbApplication.class, args);
	}
}
