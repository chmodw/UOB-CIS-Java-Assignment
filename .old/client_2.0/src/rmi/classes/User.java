package rmi.classes;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String fullName;
	private String email;
	private String age;
	private String country;
	private String deviceManufacturer;
	private String deviceOS;
	private String password;
	
	//Participant
	public User(String fullName, String email, String age, String country, String deviceManufacturer,
			String deviceOS) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.country = country;
		this.deviceManufacturer = deviceManufacturer;
		this.deviceOS = deviceOS;
	}
	
	//Developer
	public User(String email,String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}

	public String getDeviceOS() {
		return deviceOS;
	}

	@Override
	public String toString() {
		return "Participant [fullName=" + fullName + ", email=" + email + ", age=" + age + ", country=" + country
				+ ", deviceManufacturer=" + deviceManufacturer + ", deviceOS=" + deviceOS + "]";
	}
	
}
