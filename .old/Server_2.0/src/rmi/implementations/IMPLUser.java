package rmi.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import rmi.classes.User;
import rmi.interfaces.IUser;
import models.Model;

public class IMPLUser extends UnicastRemoteObject implements IUser{

	private static final long serialVersionUID = 1L;

	public IMPLUser() throws RemoteException {
		super();
		
	}

	@Override
	public boolean newParticipant(User user) throws RemoteException {
		
		String sql = "INSERT INTO testers (full_name,email,age,country,device_manufacturer,device_os)"+
					 "VALUES ('"
					 + user.getFullName()+"','"
					 + user.getEmail()+"', '"
					 + user.getAge() + "','"
					 + user.getCountry() + "','"
					 + user.getDeviceManufacturer() + "','"
					 + user.getDeviceOS() + "');";

		// save the new user in the database
		return new Model("user").INSERT(sql);

	}

	@Override
	public boolean newDeveloper(User user) throws RemoteException {

		
		return false;
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		
		
		String sql = "SELECT * FROM developers WHERE username = '" + username + "'";
		
		ResultSet rs = new Model("user").SELECT(sql);
		
		try {
			if(rs.getString("password").equals(password)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void test(String name) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Hello " + name);
		
	}
	
	

}
