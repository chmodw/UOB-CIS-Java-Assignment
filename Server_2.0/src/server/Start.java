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
		
//			LocateRegistry.createRegistry(1099);
//			Naming.rebind("//localhost/betaservay/Questionnaire", new IMPLQuestionnaire());
//			Naming.rebind("//localhost/betaservay/User", new IMPLUser());
//			Naming.rebind("//localhost/betaservay/Resluts", new IMPLResults());
			
			LocateRegistry.createRegistry(8080);
			Naming.rebind("//127.0.0.1:8080/betaservay/Questionnaire", new IMPLQuestionnaire());
			Naming.rebind("//127.0.0.1:8080/betaservay/User", new IMPLUser());
			Naming.rebind("//127.0.0.1:8080/betaservay/Resluts", new IMPLResults());
		
			System.out.println("Server is running");
			
		}catch(RemoteException e) {
			
			Logger.log("Server Error...."+e.toString());
		
		}

	}

}