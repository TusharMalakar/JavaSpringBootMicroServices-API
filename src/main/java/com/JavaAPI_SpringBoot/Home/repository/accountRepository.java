package com.JavaAPI_SpringBoot.Home.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.JavaAPI_SpringBoot.Home.model.account;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */


public interface accountRepository extends MongoRepository<account, Integer>{
	public account findByUsername(String username);
}


