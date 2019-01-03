package com.in.vm.bloodbank.api.exception;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private String uri;

	public ErrorResponse() {
	
	}
	
	public ErrorResponse(String message, String uri) {
		this.message = message;
		this.uri = uri;
	}
	
	
	
}
