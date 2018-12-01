package classes;

import java.rmi.Naming;
import java.rmi.RemoteException;

import rmi.interfaces.IUser;
import rmi.classes.User;

public class UserClient {
	
	private IUser remoteUserClass;
	private boolean isServerReady = false;
	
	public UserClient() {
			
		try {
			
			remoteUserClass = (IUser) Naming.lookup("//localhost:8080/betaservay/User");
			
			isServerReady = true;
		
		}catch (Exception e) {
			//Logger Class
		}
		
	}
	
	/**
	 * Save the user form when a user signup to the system
	 * @param fullName
	 * @param email
	 * @param age
	 * @param country
	 * @param deviceManufacturer
	 * @param deviceOS
	 * @return
	 * @throws RemoteException
	 */
	public boolean saveParticipant(String fullName, String email, String age, String country, String deviceManufacturer,
			String deviceOS) throws RemoteException {
		
		return remoteUserClass.newParticipant(new User(fullName, email, age, country, deviceManufacturer, deviceOS));
		
//		remoteUserClass.test("client");
		
	}
	
	public boolean checkServer() {
		return isServerReady;
	}
	
	public void test() {
		System.out.println("this is a test");
	}
	
}
