package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import application.Result;

public interface IResults  extends Remote{
		
	/**
	 * Get how many people answered the questionnaire
	 * @return
	 * @throws RemoteException
	 */
	public int getResultCount() throws RemoteException;
	
	/**
	 * Get the results from the database
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Result> getResluts(String[] params) throws RemoteException;
	
	/**
	 * Parameters for filter the results
	 * @param params
	 * @throws RemoteException
	 */
	public void setParams(String[] params) throws RemoteException;
	
	/**
	 * get sentiment analysis results
	 * @return
	 * @throws RemoteException
	 */
	public Map<String, Integer> getSARResults() throws RemoteException;
	
	/**
	 * 
	 * @param filter
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getFilterParams(String filter) throws RemoteException;

}
