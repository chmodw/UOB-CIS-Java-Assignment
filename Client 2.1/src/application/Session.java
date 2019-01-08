package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.ISession;
import utils.ClientConfig;
import utils.Helpers;

public class Session {

	public static ISession session;
	private static User currentUser;
	
	public static void load() {
		try {
			session = (ISession) Naming.lookup("rmi://"+ClientConfig.getIp()+"/survey/session");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {

		}
	}
	
	public static void setSession(ISession session) {
		Session.session = session;
	}
	public static User getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(User currentUser) {
		Session.currentUser = currentUser;
	} 
	
	public static Object find(String name) {
		try {
			return session.find(name);
		} catch (RemoteException e) {
			Helpers.ErrorLog("Session Add Error : Client " + Helpers.DateNow() + e.toString());
		}
		return null;
	}
	
	public static void add(Object obj,String name, boolean autoDestroy) {
		try {
			session.add(obj, name, autoDestroy);
		} catch (RemoteException e) {
			Helpers.ErrorLog("Session Add Error : Client " + Helpers.DateNow() + e.toString());
		}
	}
	
	
	
}
