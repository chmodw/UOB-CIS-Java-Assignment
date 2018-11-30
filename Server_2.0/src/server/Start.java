package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.implementations.*;
import utils.Logger;

public class Start {

	public static void main(String[] args) throws MalformedURLException {
		try {
		
			LocateRegistry.createRegistry(8080);
			Naming.rebind("//127.8.8.1:8080/betaservay/Questionnaire", new IMPLQuestionnaire());
			Naming.rebind("//127.8.8.1:8080/betaservay/User", new IMPLUser());
		
			System.out.println("Server is running");
			
		}catch(RemoteException e) {
			
			Logger.log("Server Error...."+e.toString());
		
		}

	}

}
