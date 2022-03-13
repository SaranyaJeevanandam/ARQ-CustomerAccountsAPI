package com.bnk.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
	
	
	@Id
	private Integer accountNumber;
	private String accountName;
	private AccountType accountType;
	private String balanceDate;
	private CurrencyEnum currencyType;
	private String availableBalance;
	

}
