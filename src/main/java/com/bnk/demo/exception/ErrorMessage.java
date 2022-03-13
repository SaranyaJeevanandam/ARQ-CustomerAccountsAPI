package com.bnk.demo.exception;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Validated
public class ErrorMessage {
	
	@JsonProperty("code")
	private Integer code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("details")
	private String details;	

}
