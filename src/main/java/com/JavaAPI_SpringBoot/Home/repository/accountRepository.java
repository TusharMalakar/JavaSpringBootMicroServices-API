package com.JavaAPI_SpringBoot.Home.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.JavaAPI_SpringBoot.Home.model.account;
import com.JavaAPI_SpringBoot.Home.model.response;

public interface accountRepository extends MongoRepository<account, Integer>{
	
	
}


