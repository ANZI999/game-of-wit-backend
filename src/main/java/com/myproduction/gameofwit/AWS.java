package com.myproduction.gameofwit;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Component
public class AWS {
	private static final AmazonDynamoDB DYNAMO_DB_CLIENT = AmazonDynamoDBClientBuilder.defaultClient();
	
	public static AmazonDynamoDB getDynamoDBClient() {		
		return DYNAMO_DB_CLIENT;
	}
	
}
