package com.myproduction.gameofwit.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChallengeElement implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("isFillable")
	private boolean isFillable;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("allowedLength")
	private Integer allowedLength;
	
	public ChallengeElement() {
		
	}

	public boolean getIsFillable() {
		return isFillable;
	}

	public String getText() {
		return text;
	}

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

	public boolean isMatch(String next) {
		return next.length() <= allowedLength;
	}
}
