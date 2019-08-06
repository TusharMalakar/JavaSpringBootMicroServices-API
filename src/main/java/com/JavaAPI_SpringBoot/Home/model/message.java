package com.JavaAPI_SpringBoot.Home.model;

public class message {
	private String sender;
	private String [] recipient;
	private String data;
	
	//constructor
		public message(String sender, String recipient [], String data) {
			
			this.sender    = sender;
			this.recipient = recipient;
			this.data      = data;
		}
	
	//accessors and mutators
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String[] getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient[]) {
		this.recipient = recipient;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
		
}
