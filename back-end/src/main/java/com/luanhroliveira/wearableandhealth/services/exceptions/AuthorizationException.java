package com.luanhroliveira.wearableandhealth.services.exceptions;

public class AuthorizationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorizationException() {

	}

	public AuthorizationException(String msg) {
		super(msg);
	}
}
