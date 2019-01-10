package application;

import java.io.Serializable;

import utils.Helpers;

/**
 * Create a participant object or a Developer object
 * @author Chamodya Wimansha
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String full_name;
	private String email;
	private String country;
	private String device_manufacturer;
	private String device_os;
	private String participated_on;
	private String password; 
	
	/**
	 * create the Survey participant
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
	 * create a Developer object
	 * When creating a new Developer the password is come here already encrypted
	 * @param email
	 * @param password
	 * @param participated_on
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
		this.participated_on = Helpers.DateNow();
		
		Helpers.Status("Developer Object Created");
		
	}
	/**
	 * return the full name participant or a developer
	 * @return
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * return the Eamil address
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * return the developer country
	 * @return
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * return the device manufacturer
	 * @return
	 */
	public String getDevice_manufacturer() {
		return device_manufacturer;
	}
	/**
	 * Return the device OS
	 * @return
	 */
	public String getDevice_os() {
		return device_os;
	}
	/**
	 * Return the Participated date
	 * @return
	 */
	public String getParticipated_on() {
		return participated_on;
	}
	/**
	 * return the developer password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [full_name=" + full_name + ", email=" + email + ", country=" + country + ", device_manufacturer="
				+ device_manufacturer + ", device_os=" + device_os + ", participated_on=" + participated_on
				+ ", password=" + password + "]";
	}
	
	
	
}
