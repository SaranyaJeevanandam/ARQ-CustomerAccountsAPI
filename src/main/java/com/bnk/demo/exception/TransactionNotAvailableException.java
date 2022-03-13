package com.bnk.demo.exception;

import org.springframework.http.HttpStatus;

public class TransactionNotAvailableException extends RuntimeException{


	private static final long serialVersionUID = 7895347091012367607L;
	private HttpStatus httpStatus;
	private ErrorMessage errorMessage;
	
	public TransactionNotAvailableException(HttpStatus httpStatus,ErrorMessage errorMessage ) {
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	
	
}
