package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import impls.Account;
import impls.Questionnaire;
import impls.Results;

public class Main {

	public static void main(String[] args) {
		
		try {
			
//			start rmiregistry -J-Djava.rmi.server.hostname=192.168.1.1:1099
			
			Naming.rebind("rmi://192.168.1.1:1099/survey/questionnaire", new Questionnaire());
			Naming.rebind("rmi://192.168.1.1:1099/survey/account", new Account());   
			Naming.rebind("rmi://192.168.1.1:1099/survey/results", new Results());   
//			LocateRegistry.createRegistry(1099);
//			Naming.rebind("rmi://192.168.1.1:1099/survey/questionnaire", new Questionnaire());
//			Naming.rebind("//localhost/survey/account", new Account());   
//			Naming.rebind("rmi://192.168.1.1:1099/survey/results", new Results());  
			
            System.err.println("Server ready");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
//          e.printStackTrace();
        }

	}

}
