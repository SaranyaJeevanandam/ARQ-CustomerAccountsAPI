package com.bnk.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.demo.model.AccountTransaction;
import com.bnk.demo.service.AccountTransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@RequestMapping("/com/bnk/cust/v2")
@Slf4j
public class AccountTransactionController {

	@Autowired
	private AccountTransactionService accountTransactionService;
	
	@GetMapping("fetchAccoutTransaction/{accountNumber}")
    public ResponseEntity<AccountTransaction> fetchAccoutTransaction(@PathVariable(value = "accountNumber") @NotBlank @Size(max = 10) String accountNumer, @RequestHeader(value = "x-appCorrelationID", required=true) @NotBlank String xAppCorrelationID) {
		
		log.info("xAppCorrelationID {} => Account number requested to get Transactions: {} ", xAppCorrelationID, accountNumer);
        
        return new ResponseEntity<AccountTransaction>(accountTransactionService.fetchTransactionSummaryForAccountID(xAppCorrelationID, accountNumer), HttpStatus.OK);
    }
	
}
