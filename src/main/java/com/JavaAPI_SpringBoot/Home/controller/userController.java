package com.JavaAPI_SpringBoot.Home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JavaAPI_SpringBoot.Home.model.account;
import com.JavaAPI_SpringBoot.Home.model.response;
import com.JavaAPI_SpringBoot.Home.model.services.accountServices;
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
	private accountServices accountService;
	
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
		return welcome;
	}
	
	/**
	 * If you run on loacalhost:8080
	 * http://localhost:8080/user/login?username=testsuer1&password=password
	 * */
	
	@RequestMapping(method = RequestMethod.GET, value ="/user/login")
	public response login_endpoint(@RequestParam String username, @RequestParam String password) { 
		
		for(int i=0; i< accountRepo.findAll().size(); i++){	
			
			if(accountRepo.findAll().get(i).getUsername().equals(username) && accountRepo.findAll().get(i).getPassword().equals(password)) {
				//System.out.println(accountRepo.findAll().get(i).getUsername());
				Response = new response(true, "You successfully logged in!" );
			}
			
			else {		
				if(!accountRepo.findAll().get(i).getPassword().equals(password)) {
					Response = new response(false,"password didn't match!");
				}
				
//				else{
//					Response = new response(false,"Username doesn't exit!");
//				}
				
			}
		} 
		return Response;
	}
			
	
	
	@RequestMapping(method = RequestMethod.POST, value= "/createAccount")
	public response createAccount(@RequestBody account Account) {
		
		for(int i=0; i< accountRepo.findAll().size(); i++){
			if(!Account.getUsername().equals(accountRepo.findAll().get(i).getUsername())) {
				accountRepo.save(Account);
				Response = new response(true, "lkljalkjflakjflkajlkfja");
			}
			else {
				Response = new response(false, "User already exist");
				
			}
		}
		return Response;
	
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAccountByName")
	public account getAccountByName(@RequestParam String username) { 
		
		return accountService.getByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
	public account updateUser(@RequestParam String username, @RequestParam String password) { 
		
		return accountService.updateUser(username, password);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
	public void deleteUser(@RequestParam String username) { 
		
		accountService.delete(username);
	}
	
}