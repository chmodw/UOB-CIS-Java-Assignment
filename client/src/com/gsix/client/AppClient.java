package com.gsix.client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import com.gsix.rmiinterface.App;
import com.gsix.rmiinterface.RMIAccount;
import com.gsix.rmiinterface.User;

public class AppClient {
	
	private RMIAccount account;
	
	public AppClient(){
		
		try {
			account = (RMIAccount) Naming.lookup("//localhost/betaservay/Account");
		}catch (Exception e) {
			System.out.println("A problem occured: "+e.toString());
			e.printStackTrace();
			System.out.println("Is your server running?");
		}
	}
	
	public boolean login(String username, String password) throws RemoteException, ClassNotFoundException, IOException {
		
		if(account.selectUser(username).getPassword().equals(securePassword(password))) {
			return true;
		}
		
		return false;
	}
	
	public boolean newUser(String username,String password, String accountType) throws RemoteException {
		
		if(account.newUser(new User(username,securePassword(password),accountType))) {
			return true;
		}
		
		return false;
	}
	
	//	this method will encrypt the password with MD5 algo.
	private String securePassword(String password) {

        String securePassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            securePassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        
        return securePassword;
	}
	
	

}
