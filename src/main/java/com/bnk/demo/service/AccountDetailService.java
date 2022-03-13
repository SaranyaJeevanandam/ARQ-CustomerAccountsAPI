package com.bnk.demo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public Page<AccountDetails> fetchAccountDetails(String xAppCorrelationID, int pageNo, int pageSize) throws ParseException {

		List<AccountDetails> accountDetailsList = CustomerUtil.createCustomerAccountsToLoadInDB();

		accountDetailsList.forEach(x->accountDetailsRepository.save(x));
		log.debug("xAppCorrelationID {} => Transactions successfully loaded to DB", xAppCorrelationID);

		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		return accountDetailsRepository.findAll(paging);
	}

}
