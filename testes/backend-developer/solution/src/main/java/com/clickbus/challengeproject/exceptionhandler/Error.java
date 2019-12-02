package com.clickbus.challengeproject.exceptionhandler;

public class Error {

	private String userMessage;
	private String developMessage;
	
	public Error(String userMessage, String developMessage) {
		this.userMessage = userMessage;
		this.developMessage = developMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getDevelopMessage() {
		return developMessage;
	}
}
