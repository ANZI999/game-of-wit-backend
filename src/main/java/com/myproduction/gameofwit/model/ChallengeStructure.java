package com.myproduction.gameofwit.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "game_of_wit.challenge_structure")
public class ChallengeStructure {
	private Long id;
	private List<ChallengePart> parts;
	
	public ChallengeStructure() {
		
	}
	
	public ChallengeStructure(Long id, List<ChallengePart> parts) {
		this.id = id;
		this.parts = parts;
	}

	@DynamoDBHashKey
	public Long getId() {
		return id;
	}
	
	@DynamoDBAttribute(attributeName = "parts")
	public List<ChallengePart> getParts() {
		return parts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParts(List<ChallengePart> parts) {
		this.parts = parts;
	}
}
