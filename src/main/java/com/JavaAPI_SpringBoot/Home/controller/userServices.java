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
;


@RestController
public class userServices {
	
//	MongoClientURI uri = new MongoClientURI( "mongodbites=true&w=majority");
//	MongoClient mongoClient = new MongoClient(uri);
//	MongoDatabase database = mongoClient.getDatabase("users");
	
	
	
	
	@Autowired
	private accountRepository accountRepo;
	
	//passing reponse on successful or faluire 
	private response Response = new response(false, null);
	
	//default response
	@RequestMapping(method = RequestMethod.GET, value="")
	public String welcomePage() {
		String welcome = "welome to Java Microservices";
		return welcome;
	}
	
	//user/login?username=testsuer1&password=password
	@RequestMapping(method = RequestMethod.GET, value ="/user/login")
	public response login_endpoint(@RequestParam String username, @RequestParam String password) { 
		
		for(int i=0; i< accountRepo.findAll().size(); i++){	
			
			if(accountRepo.findAll().get(i).getUsername().equals(username) && accountRepo.findAll().get(i).getPassword().equals(password)) {
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
		
		System.out.println(Account);
		accountRepo.save(Account);
		Response = new response(true, "success");
		return Response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "getAccountByName")
	public account getAccountByName(){
		for(int i=0; i < accountRepo.findAll().size(); i++) {
			System.out.println(accountRepo.findAll().get(i).getUsername());
		}
		return accountRepo.findAll().get(0);
	}
	
	
	
}