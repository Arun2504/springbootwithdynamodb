package com.arun.springboot.dynamodb.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * The Class DynamoDBConfig.
 *
 * @author arun.p
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.softvision.springboot.dynamodb.dao")
public class DynamoDBConfig {
	
	/** The dynamo DB end point. */
	@Value("${amazon.dynamodb.endpoint}")
	private String dynamoDBEndPoint;
	
	/** The access key. */
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
	
	/** The secret key. */
	@Value("${amazon.aws.secretkey}")
	private String secretKey;
	
	/**
	 * Amazon dynamo DB.
	 *
	 * @return the amazon dynamo DB
	 */
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(new BasicAWSCredentials(accessKey, secretKey));
		if (!StringUtils.isEmpty(amazonDynamoDB)){
			amazonDynamoDB.setEndpoint(dynamoDBEndPoint);
		}
		return amazonDynamoDB;
	}

}
