package com.myproduction.gameofwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.myproduction.gameofwit.AWS;
import com.myproduction.gameofwit.model.Challenge;

@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@Autowired
	private AWS aws;
	
	@RequestMapping(value="/get/{id:[\\d]+}", method = RequestMethod.GET)
	public String get(@PathVariable Integer id) {
		return "Tere siin on: " + id;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String get() {
		return "Tere";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Challenge create(@RequestBody Challenge challenge) {
		challenge.setReceived();
		AmazonDynamoDB dynamoDBClient = aws.getDynamoDBClient();
		DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
		Table table = dynamoDB.getTable("game-of-wit.challenge");
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
		mapper.save(challenge);
		
		return challenge;
	}
}
