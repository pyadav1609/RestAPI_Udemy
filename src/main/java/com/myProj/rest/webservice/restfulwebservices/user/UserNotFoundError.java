package com.myProj.rest.webservice.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundError extends RuntimeException {


	public UserNotFoundError(String message) {
		super(message);
		
	}


}
