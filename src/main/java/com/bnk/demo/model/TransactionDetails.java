package com.bnk.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable 
public class TransactionDetails {

	
	private String accountName;
	private String transactionDate;
	private String amount;
	private PositionEnum position;
	private CurrencyEnum currencyCode;
	private String transactionSummary;
	
}
