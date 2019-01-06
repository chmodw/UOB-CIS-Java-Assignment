package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import impls.Account;
import impls.Questionnaire;
import impls.Results;
import impls.Session;
import utils.Model;
import utils.ServerConfig;


public class Main {

	private static String ip = ServerConfig.getIp();
	
	private static Model model = new Model();
	
	public static void main(String[] args) {
			
        
			try {
				Naming.rebind("rmi://" + ip + "/survey/questionnaire", new Questionnaire());
				Naming.rebind("rmi://" + ip + "/survey/account", new Account());   
				Naming.rebind("rmi://" + ip + "/survey/results", new Results()); 
				Naming.rebind("rmi://" + ip + "/survey/session", new Session()); 
				System.out.println("Server running");
			} catch (RemoteException | MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}
	
	public static Model getMainModel() {
		return model;
	}
}
