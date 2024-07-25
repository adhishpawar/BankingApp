package com.BankingApp.BankingApp.service.impl;

import org.springframework.stereotype.Service;

import com.BankingApp.BankingApp.dto.AccountDto;
import com.BankingApp.BankingApp.entity.Account;
import com.BankingApp.BankingApp.mapper.AccountMapper;
import com.BankingApp.BankingApp.repository.AccountRepository;
import com.BankingApp.BankingApp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
		
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
		
		double totalBalance = account.getBalance() + amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(account);
	}

	
}
