package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import interfaces.IResults;
import utils.ClientConfig;
import utils.Helpers;

public class ResultsConnector {
	
	public IResults resultsConn;
	
	public ResultsConnector() {
		
		try {
			/**
			 * look for the server
			 */
			resultsConn = (IResults) Naming.lookup("rmi://"+ClientConfig.getIp()+"/survey/results");
			
//			Helpers.Debug("Server Found");
			
			resultsConn.readyResults();
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
//				serverConnection = false;
		}					
		
	}
	
	public int count() {
		try {
			return resultsConn.getResultCount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<Result> getResults(){
		try {
			return resultsConn.getResluts();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Map<String, Integer> getSentimentResults() {
		
		try {
			
			return resultsConn.getSARResults();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	


}
