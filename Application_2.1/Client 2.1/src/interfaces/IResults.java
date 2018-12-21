package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

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
	public Map<String, Integer[]> getResluts() throws RemoteException;
	
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
	 * process results and ready them to send back to the client
	 * @throws RemoteException
	 */
	public void readyResults() throws RemoteException;
}
