package impls;

import java.util.HashMap;
import java.util.Map;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.ISession;

public class Session extends UnicastRemoteObject implements ISession{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Session() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * contains main data
	 */
	private Map<String, Object> session= new HashMap<>();

	@Override
	public Object find(String txt) throws RemoteException {
		
		if(session.containsKey(txt)) {
			return session.get(txt);
		}
		
		return null;
	}

	@Override
	public String add(Object obj, String txt, boolean autoDestroy) throws RemoteException {
		this.session.put(txt, obj);
		return null;
	}

	@Override 
	public boolean destroy(String txt) throws RemoteException {

		return false;
	}

	@Override
	public void ping() throws RemoteException {
		
	}
	
	

}
