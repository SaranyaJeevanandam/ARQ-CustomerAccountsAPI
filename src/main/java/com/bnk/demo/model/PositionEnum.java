package com.bnk.demo.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum PositionEnum {

	Credit("Credit"),
	Debit("Debit");
	
	private String value;
	

	public static PositionEnum fromvalue(String text) {
		for (PositionEnum position : PositionEnum.values()) {
			if(String.valueOf(position.value).equals(text)) {
				return position;
			}
		}
		return null;
	}

}
