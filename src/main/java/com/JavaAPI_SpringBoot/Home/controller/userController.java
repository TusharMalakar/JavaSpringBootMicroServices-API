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
	/**
	 * If you run on loacalhost:8080
	 * http://localhost:8080
	 * */
	@RequestMapping(method = RequestMethod.GET, value="")
	public String welcomePage() {
		String welcome = "welome to Java Microservices";
		System.out.println(accountRepo.findAll().size());
		return welcome;
	}
	
	/**
	 * If you run on loacalhost:8080
	 * http://localhost:8080/user/login?username=testsuer1&password=password
	 * */
	
	@RequestMapping(method = RequestMethod.GET, value ="/login")
	public response login_endpoint(@RequestParam String username, @RequestParam String password) { 
		
		for(int i=0; i< accountRepo.findAll().size(); i++){	
			
			if(accountRepo.findAll().get(i).getUsername().equals(username) 
					&& EncryptionDecryptionInstance.decrypt(accountRepo.findAll().get(i).getPassword()).equals(password)) {
				//System.out.println(accountRepo.findAll().get(i).getUsername());
				Response = new response(true, "You successfully logged in!" );
			}
			
			else {		
				if(!EncryptionDecryptionInstance.decrypt(accountRepo.findAll().get(i).getPassword()).equals(password)) {
					Response = new response(false,"password didn't match!");
				}
			}
		} 
		System.out.println(accountRepo.findAll().size());
		return Response;
	}
			
	
	
	@RequestMapping(method = RequestMethod.POST, value= "/createAccount")
	public response createAccount(@RequestParam String username, @RequestParam String password) {
		
		for(int i=0; i< accountRepo.findAll().size(); i++){
			if(!username.equals(accountRepo.findAll().get(i).getUsername())) {
				String encrytedPass = EncryptionDecryptionInstance.encrypt(password);
				account Account = new account(username, encrytedPass);
				accountRepo.save(Account);
				Response = new response(true, "A new account has been created");
			}
			else {
				Response = new response(false, "User already exist");
				
			}
		}
		System.out.println(accountRepo.findAll().size());
		return Response;
	
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAccountByName")
	public account getAccountByName(@RequestParam String username) { 
		
		System.out.println(accountRepo.findAll().size());
		return accountRepo.findByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
	public account updateUser(@RequestParam String username, @RequestParam String password) { 
		
		account accountEntity = accountRepo.findByUsername(username);
		if(accountEntity!=null)
			accountEntity.setPassword(password);
			accountEntity.setUsername(username);
			accountRepo.save(accountEntity);
		return accountEntity;
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