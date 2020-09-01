package com.interview.rest.handlererror;

import org.springframework.stereotype.Component;

@Component
public class ApiErrorHandler {
	
	protected String path;
	public String message;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
