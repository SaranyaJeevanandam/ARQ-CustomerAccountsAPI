package com.bnk.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bnk.demo.repository.AccountDetailsRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DataJpaTest
public class AccountDetailServiceTest {
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	

}
