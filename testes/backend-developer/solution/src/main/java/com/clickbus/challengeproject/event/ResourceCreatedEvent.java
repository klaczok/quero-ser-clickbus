package com.clickbus.challengeproject.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceCreatedEvent extends ApplicationEvent{
	
	private Long id;
	private HttpServletResponse response;
	private static final long serialVersionUID = 1L;
	
	public ResourceCreatedEvent(Object source, Long id, HttpServletResponse response) {
		super(source);
		this.id = id;
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
