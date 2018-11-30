package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.classes.User;

public interface IUser extends Remote{

	/**
	 * Create new Participant
	 * returns true if created successfully
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public boolean newParticipant(User user) throws RemoteException;
	
	/**
	 * create a new developer account. this account can login to the system and view survey results
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public boolean newDeveloper(User user) throws RemoteException;
	
	/**
	 * Login to the system.
	 * returns true if the username and password correct
	 * @param username
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean login(String username, String password) throws RemoteException;
	
	public void test(String name) throws RemoteException;
	
	
}
