package com.bnk.demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("fetchAccoutlist/")
    public List<AccountDetails> fetchAccoutlist( @RequestHeader(value = "x-appCorrelationID", required=true) @NotBlank String xAppCorrelationID) throws ParseException {
		
		log.info("xAppCorrelationID {} => Inside fetchAccoutlist method of AccountDetailsController", xAppCorrelationID);
        
        return accountDetailService.fetchAccountDetails(xAppCorrelationID);
    }

}
 