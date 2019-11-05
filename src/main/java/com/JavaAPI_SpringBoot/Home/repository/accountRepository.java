package com.JavaAPI_SpringBoot.Home.repository;

import com.JavaAPI_SpringBoot.Home.model.account;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */


public interface accountRepository extends MongoRepository<account, Integer>{
	/****************** users DB model ***********
	 
		_id ObjectId    username String   password String
	1  5d605bf9c3198	"testuser1"		  "8ySIU9s7+/QsjHCsWUeVzQ=="
	2  5d605bf9c3198	"testuser2"		  "8ySIU9s7+/QsjHCsWUeVzQ=="
	3  5d605bf9c3198	"testuser3"		  "8ySIU9s7+/QsjHCsWUeVzQ=="
	4  5d605bf9c3198	"testuser4"		  "8ySIU9s7+/QsjHCsWUeVzQ=="


	 * */
	public account findByUsername(String username);
}


