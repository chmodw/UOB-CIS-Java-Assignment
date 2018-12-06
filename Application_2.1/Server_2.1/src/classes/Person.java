package classes;

public class Person {
	
	private String fullName;
	private String email;
	private int age;
	private String country;
	private String deviceBrand;
	private String deviceOs;
	private String password;
	
	/**
	 * Participant
	 * 
	 * @param fullName
	 * @param email
	 * @param age
	 * @param country
	 * @param deviceBrand
	 * @param deviceOs
	 */
	public Person(String fullName, String email, int age, String country, String deviceBrand, String deviceOs) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.country = country;
		this.deviceBrand = deviceBrand;
		this.deviceOs = deviceOs;
	}

	/**	Developer
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 */
	public Person(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	public String getDeviceBrand() {
		return deviceBrand;
	}

	public String getDeviceOs() {
		return deviceOs;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
}
