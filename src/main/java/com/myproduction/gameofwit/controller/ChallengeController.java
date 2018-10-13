package com.myproduction.gameofwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.myproduction.gameofwit.AWS;
import com.myproduction.gameofwit.model.Challenge;

@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Challenge get(@PathVariable String id) {
		AmazonDynamoDB dynamoDBClient = AWS.getDynamoDBClient();
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient, new DynamoDBMapperConfig(ConversionSchemas.V2));
		Challenge challenge = mapper.load(Challenge.class, id);
		return challenge;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String get() {
		return "Tere";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Challenge create(@RequestBody Challenge challenge) {
		challenge.setReceived();
		AmazonDynamoDB dynamoDBClient = AWS.getDynamoDBClient();
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient, new DynamoDBMapperConfig(ConversionSchemas.V2));
		mapper.save(challenge);
		
		return challenge;
	}
}
