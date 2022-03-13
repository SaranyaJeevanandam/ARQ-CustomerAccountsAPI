package com.bnk.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bnk.demo.TestCustomerUtil;
import com.bnk.demo.model.AccountDetails;

@DataJpaTest
public class AccountDetailsRepositoryTest {
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Test
	public void test_repository() {
		
		List<AccountDetails> accountDetailsList = TestCustomerUtil.createCustomerAccountsToLoadInDB();

		for(AccountDetails accountDetail : accountDetailsList) {
			accountDetailsRepository.save(accountDetail);
			
		}
		Assertions.assertNotNull(accountDetailsRepository.findAll());
		
		
	}

}
