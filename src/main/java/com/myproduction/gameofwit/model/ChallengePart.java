package com.myproduction.gameofwit.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class ChallengePart {
	
	@JsonProperty("isFillable")
	private boolean isFillable;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("allowedLength")
	private Integer allowedLength;
	
	public ChallengePart() {
		
	}

	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	public boolean getIsFillable() {
		return isFillable;
	}

	@DynamoDBAttribute(attributeName = "text")
	public String getText() {
		return text;
	}

	@DynamoDBAttribute(attributeName = "allowedLength")
	public Integer getAllowedLength() {
		return allowedLength;
	}

	public void setIsFillable(boolean isFillable) {
		this.isFillable = isFillable;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAllowedLength(Integer allowedLength) {
		this.allowedLength = allowedLength;
	}	
	
	@Override
	public String toString() {
		return "[ " + (isFillable ? allowedLength : text) + " ]";
	}
	
}
