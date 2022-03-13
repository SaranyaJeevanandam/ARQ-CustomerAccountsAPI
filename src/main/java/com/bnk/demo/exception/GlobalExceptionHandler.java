package com.bnk.demo.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bnk.demo.util.APIConstants;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
		
		log.error("Got ConstraintViolationException");
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setCode(APIConstants.VALIDATION_ERROR_CODE);
		errMsg.setDetails(ex.getMessage());
		errMsg.setMessage(APIConstants.VALIDATION_ERROR_MESSAGE);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
	}
	
	@ExceptionHandler({AccountNotFoundException.class})
	public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ex){

		log.error("Got AccountNotFoundException");
		return ResponseEntity.status(ex.getHttpStatus()).body(ex.getErrorMessage());
	}
	
	@ExceptionHandler({TransactionNotAvailableException.class})
	public ResponseEntity<Object> handleTransactionNotAvailableException(TransactionNotAvailableException ex){

		log.error("Got TransactionNotAvailableException");
		return ResponseEntity.status(ex.getHttpStatus()).body(ex.getErrorMessage());
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception ex){
		
		log.error("Got Exception");
		
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setCode(APIConstants.UNEXPECTED_ERROR_CODE);
		errMsg.setDetails(ex.getMessage());
		errMsg.setMessage(APIConstants.UNEXPECTED_ERROR_MESSAGE);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg);
	}
}
