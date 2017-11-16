package com.feicuiedu.store.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 5339113821203216248L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
