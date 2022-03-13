package com.bnk.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.bnk.demo.model.AccountDetails;
import com.bnk.demo.model.AccountTransaction;
import com.bnk.demo.model.AccountType;
import com.bnk.demo.model.CurrencyEnum;
import com.bnk.demo.model.PositionEnum;
import com.bnk.demo.model.TransactionDetails;

public class CustomerUtil {


	public static List<AccountDetails> createCustomerAccountsToLoadInDB() {

		AccountDetails accountDetail = null;
		List<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();

		accountDetail = AccountDetails.builder().accountNumber(111111111).accountName("SGSavings768").accountType(AccountType.Savings)
				.balanceDate("08/11/2021").availableBalance("56,345.90").currencyType(CurrencyEnum.SGD).build();
		accountDetailsList.add(accountDetail);
		accountDetail = AccountDetails.builder().accountNumber(222222222).accountName("AUCurrent123").accountType(AccountType.Current)
				.balanceDate("08/11/2021").availableBalance("86,345.90").currencyType(CurrencyEnum.AUD).build();
		accountDetailsList.add(accountDetail);
		accountDetail = AccountDetails.builder().accountNumber(333333333).accountName("SGSavings456").accountType(AccountType.Savings)
				.balanceDate("08/11/2021").availableBalance("578,100.90").currencyType(CurrencyEnum.SGD).build();
		accountDetailsList.add(accountDetail);
		accountDetail = AccountDetails.builder().accountNumber(444444444).accountName("AUCurrent145").accountType(AccountType.Current)
				.balanceDate("08/11/2021").availableBalance("12,345.90").currencyType(CurrencyEnum.AUD).build();
		accountDetailsList.add(accountDetail);
		accountDetail = AccountDetails.builder().accountNumber(555555555).accountName("AUCurrent190").accountType(AccountType.Current)
				.balanceDate("08/11/2021").availableBalance("45,367.90").currencyType(CurrencyEnum.AUD).build();
		accountDetailsList.add(accountDetail);
		accountDetail = AccountDetails.builder().accountNumber(666666666).accountName("SGSavings987").accountType(AccountType.Savings)
				.balanceDate("08/11/2021").availableBalance("78,009.00").currencyType(CurrencyEnum.SGD).build();
		accountDetailsList.add(accountDetail);

		return accountDetailsList;

	}

	public static List<AccountTransaction> createAccountTransactionDetailsToLoadInDB() {

		
		AccountTransaction accountTransaction = null;
		List<AccountTransaction> accountTransactionList = new ArrayList<AccountTransaction>();
		
		List<TransactionDetails> transactionList = null;
		TransactionDetails transactionDetails = null;

		transactionList = new ArrayList<TransactionDetails>();
		transactionDetails = TransactionDetails.builder().accountName("Current Account").currencyCode(CurrencyEnum.AUD).amount("200.00")
				.position(PositionEnum.Credit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);

		transactionDetails = TransactionDetails.builder().accountName("Current Account").currencyCode(CurrencyEnum.AUD).amount("400.00")
				.position(PositionEnum.Credit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);

		transactionDetails = TransactionDetails.builder().accountName("Current Account").currencyCode(CurrencyEnum.AUD).amount("600.00")
				.position(PositionEnum.Credit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);
		
		accountTransaction = new AccountTransaction();
		accountTransaction.setAccountNumber("1111111111");
		accountTransaction.setTransactionDetails(transactionList);
		accountTransactionList.add(accountTransaction);

		
		transactionList = new ArrayList<TransactionDetails>();
		transactionDetails = TransactionDetails.builder().accountName("Saving Account").currencyCode(CurrencyEnum.AUD).amount("200.00")
				.position(PositionEnum.Debit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);

		transactionDetails = TransactionDetails.builder().accountName("Saving Account").currencyCode(CurrencyEnum.AUD).amount("400.00")
				.position(PositionEnum.Debit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);

		transactionDetails = TransactionDetails.builder().accountName("Saving Account").currencyCode(CurrencyEnum.AUD).amount("600.00")
				.position(PositionEnum.Debit).transactionDate("Jan. 12, 2012").transactionSummary("").build();		
		transactionList.add(transactionDetails);

		accountTransaction = new AccountTransaction();
		accountTransaction.setAccountNumber("2222222222");
		accountTransaction.setTransactionDetails(transactionList);
		accountTransactionList.add(accountTransaction);
		
		
		transactionList = new ArrayList<TransactionDetails>();
		accountTransaction = new AccountTransaction();
		accountTransaction.setAccountNumber("333333333");
		accountTransaction.setTransactionDetails(transactionList);
		accountTransactionList.add(accountTransaction);
		
		return accountTransactionList;
	}
}
