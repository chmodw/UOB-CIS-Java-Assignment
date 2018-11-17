package com.gsix.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	

	public static void main(String[] args) throws NotBoundException, ClassNotFoundException, IOException {
				
		AppClient app = new AppClient();
		
		app.newUser("wimansha", "password", "tester");
		
		System.out.println(app.login("wimansha", "password"));

	}
	
}