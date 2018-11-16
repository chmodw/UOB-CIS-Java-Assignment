package com.gsix.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * this interface includes methods for users and App.
 * @author chamo
 *
 */

public interface RMIAccount {

	/*
	 * Create a new user
	 * @return boolean
	 * return true if a user registered successfully
	 */ 
	public boolean newUser(User User) throws RemoteException;
	
	/**
	 * find a user from the database. can use for login. return true if found
	 * @param User
	 * @return
	 */
	public User selectUser(User User) throws RemoteException;
	
	/**
	 * A logging status method will add here after base components finish.
	 * it will save login details to track who's logged into the system 
	 * and avoid login using same account at the same account
	 * @return
	 */
	
	/**
	 * Only a developer can add a App
	 * @param App
	 * @param User
	 * @return
	 * @throws RemoteException
	 */
	public boolean newApp(App App, User User) throws RemoteException;
	
	/**
	 * Select only a one app.
	 * @param appName
	 * @return
	 * @throws RemoteException
	 */
	public App selectApp(String appName) throws RemoteException;
	
	/**
	 * Get the list of apps from the database
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<App> getApps() throws RemoteException;
	
}










