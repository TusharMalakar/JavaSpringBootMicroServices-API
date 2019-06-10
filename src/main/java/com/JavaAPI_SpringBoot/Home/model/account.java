package com.JavaAPI_SpringBoot.Home.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "accounts")
public class account {
	
	@Id      //Primary key is ID
	private int    id;
	private String username;
	private String password;
	
	//constructor
	public account(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
