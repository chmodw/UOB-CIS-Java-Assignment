package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

public interface IResults extends Remote{
	
	/**
	 * Process the results saved in the database.
	 * @return
	 * @throws RemoteException
	 */
	public int[][] processResults() throws RemoteException;
	
	public void sentimentAnalysis() throws RemoteException;

}
