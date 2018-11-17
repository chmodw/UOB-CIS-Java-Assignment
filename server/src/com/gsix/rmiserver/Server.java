package com.gsix.rmiserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Server {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		System.out.println("Starting server....");
		
		try {
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost/betaservay/Questionnaire", new IMPLQuestionnaire());
			Naming.rebind("//localhost/betaservay/Account", new IMPLAccount());
			
			System.out.println("Server started");
			
		}catch(RemoteException e) {
			System.out.println("Server Error...."+e.toString());
			e.printStackTrace();
		}

	}

}
