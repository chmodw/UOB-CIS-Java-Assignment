package com.gsix.client;

import java.rmi.Naming;

//import com.gsix.rmiinterface.App;
import com.gsix.rmiinterface.RMIAccount;
import com.gsix.rmiinterface.User;

public class AppClient {
	
	public AppClient(){
		
		try {
			RMIAccount account = (RMIAccount) Naming.lookup("//localhost/betaservay/Account");
			
//			craete a new user TEST
			account.newUser(new User("chamodya","1234","developer"));
			
//			System.out.println(questionnaire.getQuestions());
		}catch (Exception e) {
			System.out.println("A problem occured: "+e.toString());
			e.printStackTrace();
			System.out.println("Is your server running?");
		}


		
	}

}
