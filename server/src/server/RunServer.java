package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {

	
	public static void main(String[] args) {
		
		System.out.println("Attempting to start the Question Server..."); 
		
		try {
			
			User obj = new User();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("QuestionService1819",obj);

			System.out.println("Service started. Welcome to the RMI Question Service!");

		} catch (RemoteException e) {
			
			System.out.println("An error occured: "+e.toString()); 
			e.printStackTrace();
			
		} 

	}


}
