package com.bnk.demo.model;

import java.util.List;

import javax.persistence.ElementCollection;
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
public class AccountTransaction {
	
	@Id
	private String accountNumber;
	
	@ElementCollection
	List<TransactionDetails> transactionDetails;
	


}
