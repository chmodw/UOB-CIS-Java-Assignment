package com.gsix.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.gsix.rmiinterface.*;

public class Model {
	
	private static String userStorage = "storage\\users\\";
	private static String appStorage = "storage\\apps\\";
	
	public static boolean write(User theUser) {
		// save the user as a object

		String filePath = userStorage+theUser.getUsername()+".obj";
		
		try {

			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(theUser);
			objectOut.close();
			
			//return true if a user successfully saved
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean write(App theApp) {
		// save the App as a object

		String filePath = appStorage+theApp.getAppName()+".obj";
		
		try {

			FileOutputStream fileOut = new FileOutputStream(filePath.toLowerCase());
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(theApp);
			objectOut.close();
			
			//return true if a App successfully saved
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public static User select(String username) throws IOException, ClassNotFoundException{
		// get all the file names in the users folder
		File fh = new File(userStorage);
		File[] listOfFiles = fh.listFiles();
		
		String fileName = username + ".obj";
		// loop through all the file names one by one
		for (int i = 0; i < listOfFiles.length; i++) {
			
            if (listOfFiles[i].getName().toLowerCase().equals(fileName.toLowerCase())) {
            	//	return the user object if a match found         	
     			FileInputStream fileIn = new FileInputStream(new File(userStorage+username.toLowerCase()+".obj"));
    			ObjectInputStream objIn = new ObjectInputStream(fileIn);
    			
    			User aUser = (User) objIn.readObject();  			          	
    			
    			fileIn.close();
    			objIn.close();
    			
    			// return the found user object
    			return aUser;
            }
		}
		
		//return null if nothing found
		return null;
	}
	
	public static ArrayList<App> getAppList() throws IOException, ClassNotFoundException{
		
		// get all the file names in the users folder
				File fh = new File(appStorage);
				File[] listOfFiles = fh.listFiles();
		
				if(listOfFiles.length != 0) {
					ArrayList<App> appList = new ArrayList<>();
					// loop through all the file names one by one
					for (int i = 0; i < listOfFiles.length; i++) {
		     			FileInputStream fileIn = new FileInputStream(new File(appStorage+listOfFiles[i].getName()));
		    			ObjectInputStream objIn = new ObjectInputStream(fileIn);
		    			
		    			App aApp = (App) objIn.readObject();  			          	
		    			
		    			fileIn.close();
		    			objIn.close();
		    			
		    			// return the found user object
		    			appList.add(aApp);
					}
					return appList;
				}
				
		return null;
	}
	
	public static ArrayList<Question> loadQuestions(){
		
		try {
			BufferedReader qRead = new BufferedReader(new FileReader("storage\\questionlist.txt"));
			
			String line = qRead.readLine();
			int qnumber = 1;
			
			ArrayList<Question> qList = new ArrayList<>();
			
			//	answers for questions are add here
			String[] answers = {"Strongly Disagree", "Disagree", "Agree", "Strongly agree"};
			
			while (line != null) {
				
				qList.add(new Question(qnumber,line,answers));
				qnumber+=1;
				// read next line
				line = qRead.readLine();
			}
			qRead.close();
			
			return qList;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}












