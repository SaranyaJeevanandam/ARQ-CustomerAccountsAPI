package com.bnk.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bnk.demo.exception.AccountNotFoundException;
import com.bnk.demo.exception.ErrorMessage;
import com.bnk.demo.exception.TransactionNotAvailableException;
import com.bnk.demo.model.AccountTransaction;
import com.bnk.demo.repository.AccountTransactionRepository;
import com.bnk.demo.util.APIConstants;
import com.bnk.demo.util.CustomerUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountTransactionService {

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	public AccountTransaction fetchTransactionSummaryForAccountID(String xAppCorrelationID, String accountNumber){

		AccountTransaction accountTransaction= null;
		List<AccountTransaction> accountTransactionList = CustomerUtil.createAccountTransactionDetailsToLoadInDB();
		
		log.debug("xAppCorrelationID {} => Transactions to be loaded to DB for retrieval purpose: {} ", xAppCorrelationID, accountTransactionList);
        
		accountTransactionList.forEach(x ->accountTransactionRepository.save(x));

		log.debug("xAppCorrelationID {} => Transactions successfully loaded to DB", xAppCorrelationID);
        
		accountTransaction = accountTransactionRepository.findByAccountNumber(accountNumber);

		if(Objects.nonNull(accountTransaction)) {

			if(accountTransaction.getTransactionDetails().isEmpty()) {

				ErrorMessage errMsg = new ErrorMessage();
				errMsg.setCode(APIConstants.TRANSACTION_NOT_AVAILABLE_ERROR_CODE);
				errMsg.setDetails(APIConstants.TRANSACTION_NOT_AVAILABLE_ERROR_DETAIL);
				errMsg.setMessage(APIConstants.TRANSACTION_NOT_AVAILABLE_ERROR_MESSAGE);
				
				throw new TransactionNotAvailableException(HttpStatus.NOT_FOUND, errMsg );

			}else {
				
				log.debug("xAppCorrelationID {} => Transactions for the Account Number {}", xAppCorrelationID, accountTransaction);
				
				return accountTransaction;
			}

		}else {

			ErrorMessage errMsg = new ErrorMessage();
			errMsg.setCode(APIConstants.ACCOUNT_NOT_FOUND_ERROR_CODE);
			errMsg.setDetails(APIConstants.ACCOUNT_NOT_FOUND_ERROR_DETAIL);
			errMsg.setMessage(APIConstants.ACCOUNT_NOT_FOUND_ERROR_MESSAGE);
			
			throw new AccountNotFoundException(HttpStatus.NOT_FOUND, errMsg );
		}

	}

}
