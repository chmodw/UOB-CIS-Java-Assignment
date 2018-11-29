package com.gsix.rmiinterface;

import java.io.Serializable;

public class App implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String appName;
	private String developerName;

	public App(String appName, String developerName) {
		super();
		this.appName = appName;
		this.developerName = developerName;
	}
	
	public String getAppName() {
		return appName;
	}
	
	public String getDeveloperName() {
		return developerName;
	}

}
