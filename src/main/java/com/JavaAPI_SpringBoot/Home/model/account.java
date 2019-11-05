package com.JavaAPI_SpringBoot.Home.model;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 *
 * @author Tushar Malakar
 */


@Data
@AllArgsConstructor
@Document(collection = "accounts")
public class account {
	
	@Id
	private String _id;
	private String username;
	private String password;
	private String cookie;
	
	//default constructor
	public account() {
		this.username = "";
		this.password = "";
		this.cookie = null;
	}
	
	//parameterized constructor
	public account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public void setID(String _id) {
		this._id = _id;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getID() {
		return _id;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public String getCookie() {
		return cookie;
	}
	@Override
	public String toString() {
		return "account [_id=" + _id + ", username=" + username + ", password=" + password + "]";
	}
	

}
