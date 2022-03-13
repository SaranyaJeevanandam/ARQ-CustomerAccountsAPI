package com.bnk.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.bnk.demo.model.AccountDetails;
import com.bnk.demo.service.AccountDetailService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountDetailService accountDetailService;

	@Test
	@DisplayName("GET /com/bnk/cust/v2/accounts - success")
	void customer_accountlist_success() throws Exception {
		List<AccountDetails> accountDetailsResponse = null;
		
		doReturn(accountDetailsResponse).when(accountDetailService).fetchAccountDetails(any(), anyInt(), anyInt());

		mockMvc.perform(get("/com/bnk/cust/v2/accounts").header("x-appCorrelationID", "CorrID")).andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("GET /com/bnk/cust/v2/accounts - error")
	void customer_accountlist_blank_corrID() throws Exception {
		List<AccountDetails> accountDetailsResponse = null;
		
		doReturn(accountDetailsResponse).when(accountDetailService).fetchAccountDetails(any(), anyInt(), anyInt());

		mockMvc.perform(get("/com/bnk/cust/v2/accounts").header("x-appCorrelationID", "")).andExpect(status().is4xxClientError());
	}

}
