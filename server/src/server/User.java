package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import serverInterfaces.IUser;

public class User extends UnicastRemoteObject implements IUser{
	

	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String username;
	private String password;
	private String accountType;
	private String deviceManufaturer;
	private String deviceOS;
	private String added_date;
	
	
	protected User(String username, String password, String deviceManufaturer, String deviceOS) throws RemoteException {
		super();
		this.user_id = null;
		this.username = username;
		this.password = password;
		this.deviceManufaturer = deviceManufaturer;
		this.deviceOS = deviceOS;
		// get the time and when creating the object
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		this.added_date = dateFormat.format(date);
		
		System.out.println("user object craeted");
		
	}


	@Override
	public boolean register() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean select(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}