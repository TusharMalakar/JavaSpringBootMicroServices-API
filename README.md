# JavaAPI_SpringBoot Micro-services :
	It is an simple JAVA API design using Spring Boot, Tomcat and "Json Web Token (Jwt)" based authentication.  I used Amazon Web Service (AWS) and Mongodb to store my data. 
# Licensed to the Apache Software Foundation
# Spring Security with JWT Authentication
# Secure Hash Algorithm (SHA-512)
# Encrypting & Decrypting soft data : Salt algorithm to encrypte and decrypte
# Mapping : @GetMapping, @PostMapping, @PutMapping and @DeleteMapping




Endpoints:

	1.  GET request to log in to exiting account.
			   
		
	   If you run on loacalhost:8080
	   http://localhost:8080/user/login?username=testsuer1&password=password
	 
		
		return {"success":true,"token":"You successfully logged in!"}
			   or {"success":false,"token":"error message"}
	
	
	2.  POST request to create a new account.
		
		domain + /createAccount +  
								{
									"username" : "testuser41",
									"password" : "password"
								}
		return { "success": true, "token": "success" }
		or     { "success": false, "token": "error message" }
		
