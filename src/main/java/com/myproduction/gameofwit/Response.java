package com.myproduction.gameofwit;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
	
	private String data;
	
	public void setData(Object data) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.data = mapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			this.data = null;
		}
	}
	
	@JsonRawValue
	public String getData() {
		return data;
	}
	
}
