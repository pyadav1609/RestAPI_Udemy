package com.myProj.rest.webservice.restfulwebservices.exception;

public class EceptionResponse {

	private int statusCode;
	private String message;
	private String detail;
	
/*	public EceptionResponse(int statusCode, String message, String detail) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.detail = detail;
	}*/

	public EceptionResponse(String message, String detail) {
		this.message=message;
		this.detail=detail;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	
}
