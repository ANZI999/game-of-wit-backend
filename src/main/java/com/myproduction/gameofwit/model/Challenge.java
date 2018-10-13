package com.myproduction.gameofwit.model;

import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBTable(tableName = "game-of-wit.challenge")
public class Challenge {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("created")
	private Long created;

	@JsonProperty("parts")
	private List<ChallengePart> parts;
	
	public Challenge() {
		
	}
	
	@DynamoDBHashKey
	public String getId() {
		return id;
	}
	
	@DynamoDBAttribute(attributeName="created") 
    public Long getCreated() { 
		return created; 
	}
	
	@DynamoDBAttribute(attributeName="parts") 
    public List<ChallengePart> getParts() { 
		return parts; 
	}
	
	public void setParts(List<ChallengePart> parts) {
		this.parts = parts;
	}
	
	public void setReceived() {
		this.created = System.currentTimeMillis();
		this.id = UUID.randomUUID().toString();
	}
	
	public Item toItem() {
		Item item = new Item();
		item.with("id", id);
		item.with("created", created);
		item.withList("parts", parts);
		
		return item;
	}

	@Override
	public String toString() {
		StringBuilder answer = new StringBuilder();
		answer.append("[");
		for(int i = 0; i < parts.size(); i++) {
			if(i != 0) {
				answer.append(", ");
			}
			answer.append(parts.get(i));
		}
		answer.append("]");
		return answer.toString();
	}
}
