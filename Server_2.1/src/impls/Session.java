package impls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.ISession;

public class Session extends UnicastRemoteObject implements ISession{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * contains main data
	 */
	private Map<String, Object> session= new HashMap<>();
	
	private ArrayList<String> destroyList = new ArrayList<>();

	public Session() throws RemoteException {
		super();
		destroyer();
	}

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
		
		if(autoDestroy) {
			destroyList.add(txt);
		}
		
		return null;
	}

	@Override 
	public boolean destroy(String txt) throws RemoteException {
		session.remove(txt);
		return false;
	}

	@Override
	public void ping() throws RemoteException {
		
	}
	
	/**
	 * runs in background and destroy items in the session
	 */
	private void destroyer() {
		
		Runnable runnable = new Runnable() {
						
			public void run(){	
				while(!(destroyList.size() <= 0)) {
					session.remove(destroyList.get(0));
					destroyList.remove(0);
				}				
		    };
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);
	}
 
}
