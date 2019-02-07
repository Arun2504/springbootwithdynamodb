package com.arun.springboot.dynamodb.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.arun.springboot.dynamodb.entity.Employee;
import com.arun.springboot.dynamodb.entity.ProductCatalog;

/**
 * @author arun.p
 *
 */
@Component
public class CommonComponent {
	
	/** The dynamo DB mapper. */
	private DynamoDBMapper dynamoDBMapper;

    /** The amazon dynamo DB. */
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
	/**
	 * Inits the.
	 */

	@PostConstruct
	public void init() {
		
		createProductCatalogTable();
		//deleteEmployeeTable();//It can be used to delete the table when needed
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
}
