package com.bnk.demo.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum AccountType {

	Savings("Savings"),
	Current("Current");
	
	private String value;
	

	public static AccountType fromvalue(String text) {
		for (AccountType accountType : AccountType.values()) {
			if(String.valueOf(accountType.value).equals(text)) {
				return accountType;
			}
		}
		return null;
	}

}
