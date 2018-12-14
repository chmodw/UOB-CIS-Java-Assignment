package application;

import utils.Helpers;

public class User {

	private String full_name;
	private String email;
	private String country;
	private String device_manufacturer;
	private String device_os;
	private String participated_on;
	
	private String password; 
	
	/**
	 * Survey participant
	 * @param full_name
	 * @param email
	 * @param country
	 * @param device_manufacturer
	 * @param device_os
	 */
	public User(String full_name, String email, String country, String device_manufacturer, String device_os) {
		this.full_name = full_name;
		this.email = email;
		this.country = country;
		this.device_manufacturer = device_manufacturer;
		this.device_os = device_os;
		this.participated_on = Helpers.DateNow();
		
		Helpers.Status("Participant Object Created");
		
	}
	
	/**
	 * Developer account
	 * @param email
	 * @param password
	 * @param participated_on
	 */
	public User(String email, String password,String participated_on) {
		this.email = email;
		this.password = password;
		this.participated_on = Helpers.DateNow();
		
		Helpers.Status("Developer Object Created");
		
	}
	

	public String getFull_name() {
		return full_name;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getDevice_manufacturer() {
		return device_manufacturer;
	}

	public String getDevice_os() {
		return device_os;
	}

	public String getParticipated_on() {
		return participated_on;
	}

	public String getPassword() {
		return password;
	}
	
}
