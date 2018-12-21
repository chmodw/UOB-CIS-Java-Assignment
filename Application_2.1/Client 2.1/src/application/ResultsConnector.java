package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

import interfaces.IResults;

public class ResultsConnector {
	
	public IResults resultsConn;
	
	public ResultsConnector() {
		
		try {
			/**
			 * look for the server
			 */
			resultsConn = (IResults) Naming.lookup("rmi://192.168.8.102/survey/results");
			
			System.out.println("Server Found");
//				serverConnection = true;
			
			resultsConn.readyResults();
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
//				serverConnection = false;
		}					
		
	}
	
	public int count() {
		try {
			return resultsConn.getResultCount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Map<String, Integer[]> getResults(){
		try {
			return resultsConn.getResluts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	


}
