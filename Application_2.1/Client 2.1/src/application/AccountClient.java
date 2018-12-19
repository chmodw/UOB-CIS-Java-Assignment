package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import application.User;
import interfaces.IAccount;
import utils.Helpers;

public class AccountClient {
	
	private IAccount look_up_account;
	public boolean serverConnection;

	public AccountClient() {
		try {
			look_up_account = (IAccount) Naming.lookup("rmi://192.168.8.102/survey/account");
			serverConnection = true;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			serverConnection = false;
		}
	}
	
	public boolean newParticipant(String fullName, String email, String country, String TDM, String TDO) {
		
		try {
			
			return look_up_account.newParticipant(new User(fullName,email,country,TDM,TDO));
			
		} catch (RemoteException e) {
			Helpers.Debug("Client UserAccount : Can't pass the new user to server --SERVER ERROR" + e.toString());
		}
		
		return false;
	}
	
}
