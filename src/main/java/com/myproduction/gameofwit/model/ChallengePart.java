package com.myproduction.gameofwit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChallengePart {
	
	@JsonProperty("isFillable")
	private boolean isFillable;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("allowedLength")
	private Integer allowedLength;
	
	public ChallengePart() {
		
	}

	public void setFillable(boolean isFillable) {
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
