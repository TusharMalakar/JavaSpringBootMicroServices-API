# JavaAPI_SpringBoot Micro-services :
	It is an simple JAVA API design using Spring Boot, Tomcat and "Json Web Token (Jwt)" based authentication.  I used Amazon Web Service (AWS) and Mongodb to store my data. 
# Licensed to the Apache Software Foundation
# Spring Security with JWT Authentication
# Secure Hash Algorithm (SHA-512)
# Encrypting & Decrypting soft data : Salt algorithm to encrypte and decrypte
# Mapping : @GetMapping, @PostMapping, @PutMapping and @DeleteMapping

#==========================> TRUN ON YOUR DB<===================================


Endpoints:
	
	0. Welocome page:
		loacalhost:8080
		return/response :  welome to Java Microservices {numberOfDocuments}.

	1.  GET request to log in to exiting account.
			   
		
	   If you run on loacalhost:8080
	   http://localhost:8080/login?username=testuser1&password=password
		
		return {"success":true,"token":"You successfully logged in!"}
			   or {"success":false,"token":"error message"}
	
	
	2.  POST request to create a new account.
		
		http://localhost:8080/createAccount 
			 accountBody =>  {
				    	"username":"testuser1",
				    	"password":"password"
			    		}
			return/response => {
				"success": true,
			        "token": "A new account has been created"
			}

		
	3. find account by username:
		http://localhost:8080/getAccountByName?username=testuser1
		return : {"username":"testuser1","password":"XOOOCt6lVT39knLfQ5iqnw==","id":"5d605c50c31980306cdb0be7"}