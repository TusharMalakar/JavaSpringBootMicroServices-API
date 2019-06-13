package com.JavaAPI_SpringBoot.Home.model;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 *
 * @author Tushar Malakar
 */


public class response {
	private boolean success;
	private String  token  ;
	
	public response(boolean success, String token) {
		super();
		this.success = success;
		this.token = token    ;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String gettoken() {
		return token;
	}
	public void settoken(String token) {
		this.token= token;
	}

	
}