package com.gsix.rmiserver;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.gsix.rmiinterface.App;
import com.gsix.rmiinterface.RMIAccount;
import com.gsix.rmiinterface.User;
import com.gsix.helpers.*;

public class IMPLAccount extends UnicastRemoteObject implements RMIAccount{

	private static final long serialVersionUID = 1L;

	protected IMPLAccount() throws RemoteException {
		super();
	}

	@Override
	public boolean newUser(User user) throws RemoteException {
		
		return Model.write(user);		
	
	}

	@Override
	public User selectUser(String username) throws ClassNotFoundException, IOException {
		
		return Model.select(username);
		
	}

	@Override
	public boolean newApp(App app, User user) throws RemoteException {
		
		return false;
	}

	@Override
	public App selectApp(String appName) throws RemoteException {
		
		return null;
	}

	@Override
	public ArrayList<App> getApps() throws RemoteException {
		
		return null;
	}

	@Override
	public String testServer() throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("A client Connected");
		return "greetings from the server";
	}

}
