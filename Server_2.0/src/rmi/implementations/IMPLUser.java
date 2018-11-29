package rmi.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import classes.User;
import rmi.interfaces.IUser;
import models.Model;

public class IMPLUser extends UnicastRemoteObject implements IUser{

	private static final long serialVersionUID = 1L;

	protected IMPLUser() throws RemoteException {
		super();
		
	}

	@Override
	public boolean newParticipant(User user) throws RemoteException {
		
		return false;
	}

	@Override
	public boolean newDeveloper(User user) throws RemoteException {
		
		return false;
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		
		return false;
	}

}
