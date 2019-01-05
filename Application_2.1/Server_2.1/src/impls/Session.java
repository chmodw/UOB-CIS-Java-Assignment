package impls;

import java.util.HashMap;
import java.util.Map;
import java.rmi.RemoteException;

import interfaces.ISession;

public class Session implements ISession{
	
	/**
	 * contains main data
	 */
	private Map<String, Object> session= new HashMap<>();
	
	/**
	 * contains data to auto destroy. like login information
	 */
	

	@Override
	public Object find(String txt,boolean autoDestroy) throws RemoteException {
		
		return null;
	}

	@Override
	public String add(Object obj, String txt, boolean autoDestroy) throws RemoteException {
		
		return null;
	}

	@Override 
	public boolean destroy(String txt) throws RemoteException {

		return false;
	}

}
