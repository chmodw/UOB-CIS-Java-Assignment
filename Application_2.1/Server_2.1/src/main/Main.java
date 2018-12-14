package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import impls.Account;
import impls.Questionnaire;
import impls.Results;


public class Main {

	private static String ip = "192.168.1.1:1099";
	
	public static void main(String[] args) {
		
		try {
			 
//			start rmiregistry -J-Djava.rmi.server.hostname=192.168.1.1:1099
	
			Naming.rebind("rmi://" + ip + "/survey/questionnaire", new Questionnaire());
			Naming.rebind("rmi://" + ip + "/survey/account", new Account());   
			Naming.rebind("rmi://" + ip + "/survey/results", new Results());   

            System.err.println("Server ready");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
        }

	}

}
