package serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote{
	
	/**
	*
	*	Register a user with the application
	*
	*/
	boolean register() throws RemoteException;
	
	/**
	*
	* Select a user from the database. check if a user register with the application
	*
	*/
	boolean select(String username, String password) throws RemoteException;
	
	
}