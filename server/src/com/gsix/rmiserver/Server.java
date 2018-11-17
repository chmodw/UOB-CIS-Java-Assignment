package com.gsix.rmiserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.remote.rmi.RMIConnectionImpl;

import com.gsix.rmiinterface.*;

public class Server {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		System.out.println("Starting server....");
		
		try {
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost/QuestionService1819", new IMPLQuestionnaire());
			
//			RMIQuestionnaire questions = new IMPLQuestionnaire();
//			Registry reg = LocateRegistry.createRegistry(1099);
//			reg.rebind("QuestionService1819",(Remote) questions);
			
			System.out.println("Server started");
			
		}catch(RemoteException e) {
			System.out.println("Server Error...."+e.toString());
			e.printStackTrace();
		}

	}

}
