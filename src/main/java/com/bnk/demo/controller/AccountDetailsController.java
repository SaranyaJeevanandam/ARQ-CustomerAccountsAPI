package com.bnk.demo.controller;

import java.text.ParseException;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.demo.model.AccountDetails;
import com.bnk.demo.service.AccountDetailService;

import lombok.extern.slf4j.Slf4j;



@RestController
@Validated
@RequestMapping("/com/bnk/cust/v2")
@Slf4j
public class AccountDetailsController {
	
	@Autowired
	private AccountDetailService accountDetailService;
	
	@GetMapping("/accounts")
    public Page<AccountDetails> accounts( @RequestHeader(value = "x-appCorrelationID", required=true) @NotBlank String xAppCorrelationID, 
    		@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize) throws ParseException {
		
		log.info("xAppCorrelationID {} => Inside fetchAccoutlist method of AccountDetailsController", xAppCorrelationID);
        
        return accountDetailService.fetchAccountDetails(xAppCorrelationID, pageNo, pageSize);
    }

}
 