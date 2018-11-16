package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.inits.*;

public class Server extends UnicastRemoteObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args) {
        try {
        	//start the rmi registry
        	java.rmi.registry.LocateRegistry.createRegistry(1099);
        	
            Naming.rebind("//localhost/BetaTest", new Questionnaire());
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

}
