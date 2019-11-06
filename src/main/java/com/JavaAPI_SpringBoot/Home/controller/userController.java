package com.JavaAPI_SpringBoot.Home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JavaAPI_SpringBoot.Home.model.account;
import com.JavaAPI_SpringBoot.Home.model.response;
import com.JavaAPI_SpringBoot.Home.repository.accountRepository;
import com.JavaAPI_SpringBoot.Home.security.EncryptionDecryption;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 *
 * @author Tushar Malakar
 */



@RestController
public class userController {
	
//	MongoClientURI uri = new MongoClientURI( "mongodbites=true&w=majority");
//	MongoClient mongoClient = new MongoClient(uri);
//	MongoDatabase database = mongoClient.getDatabase("users");
	
	
	
	
	@Autowired
	private accountRepository accountRepo;
	
	//passing reponse on successful or faluire 
	private response Response = new response(false, null);
	EncryptionDecryption EncryptionDecryptionInstance = null;
	
	//default response
	@RequestMapping(method = RequestMethod.GET, value="")
	public String welcomePage() {
		/**
		 * If you run on loacalhost:8080
		 * http://localhost:8080
		 * */
		String welcome = "welome to Java Microservices";
		System.out.println(accountRepo.findAll().size());
		return welcome +" "+ accountRepo.findAll().size();
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value ="/login")
	public response login_endpoint(@RequestParam String username, @RequestParam String password) { 
		
		/**
		 * If you run on loacalhost:8080
		 * http://localhost:8080/login?username=testuser1&password=password
	     */
		
		if(accountRepo.findByUsername(username).getUsername().equals(username) 
				&& EncryptionDecryptionInstance.decrypt(accountRepo.findByUsername(username).getPassword()).equals(password)) {
			Response = new response(true, "You successfully logged in!" );
		}
		
		else {		
			if(!EncryptionDecryptionInstance.decrypt(accountRepo.findByUsername(username).getPassword()).equals(password)) {
				Response = new response(false,"password didn't match!");
			}
		}
		return Response;
	}
			
	
	
	@RequestMapping(method = RequestMethod.POST, value= "/createAccount")
	public response createAccount(@RequestBody account accountBody) {
		/**
	    http://localhost:8080/createAccount 
		accountBody =>{
				  	"username":"testuser1",
			     	"password":"password"
		}
		return/response => {
			    "success": true,
			    "token": "A new account has been created"
		}
		 * */
		
		String username = accountBody.getUsername();
		String password = accountBody.getPassword();
		if(username==null || password==null || username== "" || password=="") 
		{Response = new response(false, "username or password not provided"); return Response;}
		account accountEntity = accountRepo.findByUsername(username);
		
		if(accountEntity == null) {
			String encrytedPass = EncryptionDecryptionInstance.encrypt(password);
			account Account = new account(username, encrytedPass);
			accountRepo.save(Account);
			Response = new response(true, "A new account has been created");
		}
		else {Response = new response(false, "User already exist");}
	
		return Response;
	
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/update_password")
	public response updateUser(@RequestBody account accountBody) {
		/**
		 * http://localhost:8080/update_password 
		   accountBody =>{
				   "username":"testuser1",
				   "password":"new_password"
		   }
		   return/response => {
					"success": true,
			    	"token": "password has been successfully updated"
		   }
		 * */
		String username = accountBody.getUsername();
		String password = accountBody.getPassword();
		if(username==null || password==null || username== "" || password=="") 
		{Response = new response(false, "username or password not provided"); return Response;}
		
		account accountEntity = accountRepo.findByUsername(username);
		if(accountEntity!=null) {
			accountEntity.setPassword(EncryptionDecryptionInstance.encrypt(password));
			accountEntity.setUsername(username);
			accountRepo.save(accountEntity);
			Response = new response(true, "user account updated successfully");
		}
		else {Response = new response(false, "User does not exist");}
		
		return Response; 
		}
	
	

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
	public account deleteUser(@RequestParam String username) { 
		
		account accountEntity = accountRepo.findByUsername(username);
		accountRepo.delete(accountEntity);
		return accountEntity;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllUsers")
	public void deleteAllUsers() { 
		accountRepo.deleteAll();
	}
	
}