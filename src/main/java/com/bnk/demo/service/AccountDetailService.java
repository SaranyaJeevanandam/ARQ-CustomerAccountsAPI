package com.bnk.demo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnk.demo.model.AccountDetails;
import com.bnk.demo.repository.AccountDetailsRepository;
import com.bnk.demo.util.CustomerUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountDetailService {

	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public List<AccountDetails> fetchAccountDetails(String xAppCorrelationID) throws ParseException {

		List<AccountDetails> accountDetailsList = CustomerUtil.createCustomerAccountsToLoadInDB();

		accountDetailsList.forEach(x->accountDetailsRepository.save(x));
		log.debug("xAppCorrelationID {} => Transactions successfully loaded to DB", xAppCorrelationID);

		return accountDetailsRepository.findAll();
	}

}
