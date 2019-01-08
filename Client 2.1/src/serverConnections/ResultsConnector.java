package serverConnections;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import application.Result;
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
			
			/**
			 * ready the results to get from the server
			 */
			resultsConn.readyResults();
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			Helpers.ErrorAlert("Server Connection Error. Try restrating the application");
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
