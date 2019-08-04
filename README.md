# JavaAPI_SpringBoot Micro-services
# Licensed to the Apache Software Foundation
# Licensed to MIT
# Spring Security with JWT Authentication
# JMS Messaging 
# Encrypting & Decrypting soft data  





Endpoints:

	1.  GET request to log in to exiting account.
			   
		domain + user/login?username=testsuer1&password=password
		
		return {"success":true,"token":"You successfully logged in!"}
			   or {"success":false,"token":"error message"}
	
	
	2.  POST request to create a new account.
		
		domain + /createAccount + 	token + 
								{
									"username" : "testuser41",
									"password" : "password"
								}
		return { "success": true, "token": "success" }
		or     { "success": false, "token": "error message" }