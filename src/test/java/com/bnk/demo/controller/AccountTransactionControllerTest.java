package com.bnk.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.bnk.demo.model.AccountTransaction;
import com.bnk.demo.service.AccountTransactionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountTransactionService accountTransactionService;
	
	@Test
	@DisplayName("GET fetchAccoutTransaction/{accountNumber} - success")
	void customer_transaction_success() throws Exception {
		//List<AccountTransaction> accountTransactionResponse = CustomerUtil.updateAccountTransactionDetailsinDB();
		
		AccountTransaction accountTransaction = null;
		doReturn(accountTransaction).when(accountTransactionService).fetchTransactionSummaryForAccountID(any(), any());

		mockMvc.perform(get("/com/bnk/cust/v2/fetchAccoutTransaction/111111111").header("x-appCorrelationID", "CorrID")).andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("GET fetchAccoutTransaction/{accountNumber} - success")
	void customer_transaction_blank_corrid() throws Exception {
		//List<AccountTransaction> accountTransactionResponse = CustomerUtil.updateAccountTransactionDetailsinDB();
		
		AccountTransaction accountTransaction = null;
		doReturn(accountTransaction).when(accountTransactionService).fetchTransactionSummaryForAccountID(any(), any());

		mockMvc.perform(get("/com/bnk/cust/v2/fetchAccoutTransaction/111111111").header("x-appCorrelationID", "")).andExpect(status().is4xxClientError());
	}
	
	@Test
	@DisplayName("GET fetchAccoutTransaction/{accountNumber} - success")
	void customer_transaction_blank_accountNumber() throws Exception {
		//List<AccountTransaction> accountTransactionResponse = CustomerUtil.updateAccountTransactionDetailsinDB();
		
		AccountTransaction accountTransaction = null;
		doReturn(accountTransaction).when(accountTransactionService).fetchTransactionSummaryForAccountID("CorrID", "111111111");

		mockMvc.perform(get("/com/bnk/cust/v2/fetchAccoutTransaction/").header("x-appCorrelationID", "CorrID")).andExpect(status().is4xxClientError());
	}
	
}
