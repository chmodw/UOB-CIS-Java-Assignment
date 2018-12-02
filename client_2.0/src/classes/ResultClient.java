package classes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.interfaces.IResults;

public class ResultClient {
	
	private IResults rmoteResults;

	public ResultClient() {
		try {
			rmoteResults = (IResults) Naming.lookup("//127.0.0.1:8080/betaservay/Resluts");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  int[][]  getResults() {
		
		try {
			return rmoteResults.processResults();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void sentimentAnalysis() {
		
	}

}
