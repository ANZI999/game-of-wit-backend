package com.myproduction.gameofwit.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Challenge {

	@JsonProperty("parts")
	private List<ChallengePart> parts;
	
	public Challenge() {
		
	}
	
	public void setParts(List<ChallengePart> parts) {
		this.parts = parts;
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
