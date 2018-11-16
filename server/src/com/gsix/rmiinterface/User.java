package com.gsix.rmiinterface;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String accountType;
	
		
	public User(String username, String password, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	

}
