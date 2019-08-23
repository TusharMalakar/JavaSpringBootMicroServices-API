package com.JavaAPI_SpringBoot.Home.model;

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
	
	public String getID() {
		return _id;
	}
	public void setID(String _id) {
		this._id = _id;
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
	
	@Override
	public String toString() {
		return "account [_id=" + _id + ", username=" + username + ", password=" + password + "]";
	}
	

}
