package com.BankingApp.BankingApp.service;

import com.BankingApp.BankingApp.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(Long id);
		
	AccountDto deposit(Long id, double ammount);
}
