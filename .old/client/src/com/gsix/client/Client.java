package com.gsix.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	

	public static void main(String[] args) throws NotBoundException, ClassNotFoundException, IOException {
				
		AppClient app = new AppClient();
		
//		
		System.out.println(app.login("ashik", "1234"));
		
//		System.out.println(app.newUser("ashik", "1234", "developer"));
		
//		Questionnaire q = new Questionnaire();
//		q.startQuestionnaire();

	}
	
}