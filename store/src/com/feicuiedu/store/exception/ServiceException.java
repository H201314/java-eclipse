package com.feicuiedu.store.exception;

/**
 * 自定义异常
 * @author 陈严
 */
public class ServiceException extends RuntimeException {


	private static final long serialVersionUID = 8547520390068840417L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
