package com.bnk.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bnk.demo.TestCustomerUtil;
import com.bnk.demo.model.AccountTransaction;

@DataJpaTest
public class AccountTransactionRepositoryTest {

	@Autowired
	AccountTransactionRepository accountTransactionRepository;

	@Test
	public void test_repository() {

		List<AccountTransaction> accountTransactionList = TestCustomerUtil.createAccountTransactionDetailsToLoadInDB();

		accountTransactionList.forEach(x ->accountTransactionRepository.save(x));
		
		Assertions.assertNotNull(accountTransactionRepository.findAll());

	}
	
	@Test
	public void test_repository_findByAccountNumber() {

		List<AccountTransaction> accountTransactionList = TestCustomerUtil.createAccountTransactionDetailsToLoadInDB();

		accountTransactionList.forEach(x ->accountTransactionRepository.save(x));
		
		Assertions.assertNotNull(accountTransactionRepository.findByAccountNumber("1111111111"));


	}
}
