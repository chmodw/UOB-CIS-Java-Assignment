package com.gsix.helpers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


import com.gsix.rmiinterface.*;

public class AccountModel {
	
	private static String userStorage = "storage\\users\\";
	/**
	 * save a user to the file
	 * @param user
	 * @return
	 */
	public static boolean newUser(User user) {
		
		String filePath = userStorage+user.getUsername();
		
		// save the user as a object
		try {

			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(user);
			objectOut.close();
			
			//return true if a user successfully saved
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public static User selectUser(String username) {
		
		return null;
	}

}












