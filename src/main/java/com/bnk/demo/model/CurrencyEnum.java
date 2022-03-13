package com.bnk.demo.model;

public enum CurrencyEnum {

	AUD("AUD"),
	SGD("SGD");
	
	private String value;
	
	CurrencyEnum(String value){
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	public static CurrencyEnum fromvalue(String text) {
		for (CurrencyEnum curr : CurrencyEnum.values()) {
			if(String.valueOf(curr.value).equals(text)) {
				return curr;
			}
		}
		return null;
	}
}
