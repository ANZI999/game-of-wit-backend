package com.myproduction.gameofwit;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Component
public class AWS {
	private DynamoDBMapper dynamoDBMapper;
	
	public DynamoDBMapper getDynamoDBMapper() {	
		if(dynamoDBMapper == null) {
			dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
		}
		return dynamoDBMapper;
	}	
}
