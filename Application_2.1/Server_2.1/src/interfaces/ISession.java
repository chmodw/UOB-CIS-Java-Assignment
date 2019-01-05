package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author chamo
 *
 */
public interface ISession  extends Remote{
	
	/**
	 * Find objects in the Session Map and return the found
	 * @param txt
	 * @param autoDestroy
	 * @return
	 * @throws RemoteException
	 */
	public Object find(String txt,boolean autoDestroy) throws RemoteException;
	
	/**
	 * Add object to the Session Map
	 * @param obj
	 * @param txt
	 * @param autoDestroy
	 * @return
	 * @throws RemoteException
	 */
	public String add(Object obj, String txt,boolean autoDestroy) throws RemoteException;
	
	/**
	 * Remove object from the session map
	 * @param txt
	 * @return
	 * @throws RemoteException
	 */
	public boolean destroy(String txt) throws RemoteException;
	
}
