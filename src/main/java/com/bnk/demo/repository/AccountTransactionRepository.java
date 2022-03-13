package com.bnk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnk.demo.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {
	
	AccountTransaction findByAccountNumber(String accountNumber);

}
