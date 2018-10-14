package com.myproduction.gameofwit.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "game_of_wit.submission_structure")
public class SubmissionStructure {

	private Long id;
	private List<String> parts;

	public SubmissionStructure() {
		
	}
	
	public SubmissionStructure(Long id, List<String> parts) {
		this.id = id;
		this.parts = parts;
	}

	@DynamoDBHashKey
	public Long getId() {
		return id;
	}
	
	@DynamoDBAttribute(attributeName = "parts")
	public List<String> getParts() {
		return parts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParts(List<String> parts) {
		this.parts = parts;
	}
}
