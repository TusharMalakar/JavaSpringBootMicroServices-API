package com.JavaAPI_SpringBoot.Home.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaAPI_SpringBoot.Home.model.account;
import com.JavaAPI_SpringBoot.Home.repository.accountRepository;

@Service
public class accountServices {

	@Autowired
	private accountRepository accountRepo;
	
	//find a user
	public account getByUsername(String username) {
		return accountRepo.findByUsername(username);
	}
	
	//update a user
	public account updateUser(String username, String password) {
		account acc = accountRepo.findByUsername(username);
		acc.setUsername(username);
		acc.setPassword(password);
		
		return accountRepo.save(acc);
	}
	
	//Delete all
	public void deleteAll() {
		accountRepo.deleteAll();
	}
	
	//delete one user
	public void delete(String username) {
		account acc = accountRepo.findByUsername(username);
		accountRepo.delete(acc);
	}
}
