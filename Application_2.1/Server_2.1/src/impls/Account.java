package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.User;
import interfaces.IAccount;
import utils.Helpers;
import utils.Model;
import utils.Securepass;

public class Account extends UnicastRemoteObject implements IAccount{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;
	public Account() throws RemoteException {

		//instantiating the model class. which has database functions
		model = new Model("account");
		
	}

	@Override
	public boolean newParticipant(User user) throws RemoteException {
				
		String sql = "INSERT INTO participant_data (full_name, email, country, device_manufacturer, device_os, participated_on) VALUES("
				+ "'" + user.getFull_name() + "',"
				+ "'" + user.getEmail() + "',"
				+ "'" + user.getCountry() + "',"
				+ "'" + user.getDevice_manufacturer() + "',"
				+ "'" + user.getDevice_os() + "',"
				+ "'" + user.getParticipated_on() + "'"
				+ ")";

		return model.INSERT(sql);
			
	}

	@Override
	public boolean newDeveloper(User user) throws RemoteException {
		
		String sql = "INSERT INTO developers (username, password, created_on) VALUES("
				+ "'" + user.getEmail() + "',"
				+ "'" + user.getPassword() + "',"
				+ "'" + user.getParticipated_on() + "'"
				+ ")";
		
		return model.INSERT(sql);
		
//		System.out.println(user.toString());

	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		
		
		String sql = "SELECT * FROM developers WHERE username = '" + username +  "'";
		
		ResultSet res = model.SELECT(sql);
				
		try {
			
			return new Securepass(password).isSame(res.getString("password"));
			
		} catch (SQLException e) {
			Helpers.Debug("Error!! Can't check username or password. Server Error - " + e.toString());
		}
		
		return false;
	}

}
