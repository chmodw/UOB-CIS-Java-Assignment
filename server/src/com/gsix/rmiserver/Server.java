package com.gsix.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.gsix.rmiinterface.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting server....");
		
		try {
			
			RMIQuestionnaire questions = new IMPLQuestionnaire();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("QuestionService1819",(Remote) questions);
			
			System.out.println("Service started. Welcome to the RMI Question Service!");
			
		}catch(RemoteException e) {
			System.out.println("Server Error...."+e.toString());
			e.printStackTrace();
		}

	}

}
