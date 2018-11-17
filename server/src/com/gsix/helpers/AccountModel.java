package com.gsix.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
		
		String filePath = userStorage+user.getUsername()+".obj";
		
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
	
	public static User selectUser(User user) throws IOException, ClassNotFoundException {
		
		// get all the file names in the users folder
		File fh = new File(userStorage);
		File[] listOfFiles = fh.listFiles();
		
		// loop through all the file names one by one
		for (int i = 0; i < listOfFiles.length; i++) {
          
            if (listOfFiles[i].getName() == user.getUsername()+".obj") {
            	//	return the user object if a match found
            	
    			FileInputStream fileIn = new FileInputStream(new File(user.getUsername()+".obj"));
    			ObjectInputStream objIn = new ObjectInputStream(fileIn);
    			
    			user = (User) objIn.readObject();  			          	
    			
    			fileIn.close();
    			objIn.close();
    			
    			// return the found user object
    			return user;
            }
          
		}
		
		//return null is a match not found
		return null;
	}

}












