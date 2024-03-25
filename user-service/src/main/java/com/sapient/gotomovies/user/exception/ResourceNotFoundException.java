package com.sapient.gotomovies.user.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5031210598340467225L;

	public ResourceNotFoundException(final String msg) {
		super(msg);
	}
}
