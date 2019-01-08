package serverConnections;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import application.User;
import interfaces.IAccount;
import utils.ClientConfig;
import utils.Helpers;

public class AccountClient {
	
	private IAccount look_up_account;
	public boolean serverConnection;

	public AccountClient() {
				
		try {
			look_up_account = (IAccount) Naming.lookup("rmi://"+ClientConfig.getIp()+"/survey/account");
			serverConnection = true;
						
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			Helpers.Debug("RMI connection failed --SERVER ERROR" + e.toString());
			Helpers.ErrorAlert("Server Connection Error. Try restrating the application");
		}
	}
	
	public boolean newParticipant(String fullName, String email, String country, String TDM, String TDO) {
		
		try {
			
			return look_up_account.newParticipant(new User(fullName,email,country,TDM,TDO));
			
		} catch (RemoteException e) {
			Helpers.Debug("Client UserAccount : Can't pass the new user to server --SERVER ERROR" + e.toString());
			Helpers.ErrorAlert("Can't cerate a new participent. SERVER ERROR!");
		}
		
		return false;
	}
	
	public boolean login(String username, String password) {
		try {
			return look_up_account.login(username, password);
		} catch (RemoteException e) {
			Helpers.Debug("Error!! Can't check username or password. Server Error - " + e.toString());
			Helpers.ErrorAlert("can't authenticate username and password");
		}
		
		return false;
	}
	
	public boolean newDev(User developer) {
		
		try {
			return look_up_account.newDeveloper(developer);
		} catch (RemoteException e) {
			Helpers.Debug("Error!! Could Not save the Developer Account - " + e.toString());
			Helpers.ErrorAlert("can't save the new developer. Server connection error");
		}
		
		return false;
	}
	
	public boolean updatePass(String username, String newPass) {
		
		try {
			return look_up_account.updateDeveloperPassword(username, newPass);
		} catch (RemoteException e) {
			Helpers.Debug("Error!! Could Not save the Developer Account - " + e.toString());
			Helpers.ErrorAlert("Password update Error. try restarting the application");
		}
		
		return false;
	}
	
}
