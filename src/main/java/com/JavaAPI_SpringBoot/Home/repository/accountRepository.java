package com.JavaAPI_SpringBoot.Home.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.JavaAPI_SpringBoot.Home.model.account;

public interface accountRepository extends MongoRepository<account, Integer>{
	
}


