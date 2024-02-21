package com.sanket.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sanket.banking.dto.AccountDto;
import com.sanket.banking.entity.Account;
import com.sanket.banking.mapper.AccountMapper;
import com.sanket.banking.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	public AccountServiceImpl(AccountRepo accountRepo) {

		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {

		Account account = AccountMapper.mapToAccount(accountDto);

		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {

		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));

		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));

		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {

		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		if (account.getBalance() < amount) {

			throw new RuntimeException("Insufficient amount");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {

		List<Account> accounts = accountRepo.findAll();

		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(Long id) {
		
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		accountRepo.deleteById(id);
		
	}

}
