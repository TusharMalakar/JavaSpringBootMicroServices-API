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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.mongodb.client.MongoCollection;


@RestController
public class userServices {
	
	// creating a vector of Report, initial size is 100
	Vector<account> report = new Vector(100);

//	MongoClientURI uri = new MongoClientURI("mongo.......");
//	MongoClient mongoClient = new MongoClient(uri);
//	MongoDatabase database = mongoClient.getDatabase("users");
//	MongoCollection<Document> collection = database.getCollection("accounts");
//	List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

	MongoClient client = new MongoClient("localhost", 27017);
	MongoDatabase database = client.getDatabase("users");
	MongoCollection<Document> collection = database.getCollection("accounts");
	List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
	
	
	@Autowired
	private accountRepository accountRepo;
	
	//passing reponse on successful or faluire 
	private response Response = new response(false, null);
	
	//default response
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String welcomePage() {
		String welcome = "welome to Java Microservices";
		return welcome;
	}
	
	//user/login?username=testsuer1&password=password
	@RequestMapping(method = RequestMethod.GET, value ="/user/login")
	public response login_endpoint(@RequestParam String username, @RequestParam String password) { 
		
		for(int i=0; i<documents.size(); i++){	
			
			if(documents.get(i).get("username").equals(username) && documents.get(i).get("password").equals(password)) {
				Response = new response(true, "You successfully logged in!" );
			}
			
			else {		
				if(!documents.get(i).get("password").equals(password)) {
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
		
		System.out.println(accountRepo);
		accountRepo.save(Account);
		Response = new response(true, "success");
		return Response;
	}
	
	
	
}