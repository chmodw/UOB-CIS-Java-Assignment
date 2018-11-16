package com.models;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class will deal with storage
 * @author chamo
 *
 */

public class MQuestion {
	
	private static String[] qList;

	/**
	 * Reads the questions file and get them into a ArrayList and return it
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<String> fetchQuestions() throws FileNotFoundException, IOException {
		
		String path = "storage\\questionlist.txt";
		
		BufferedReader file = new BufferedReader(new FileReader(path));
		
		ArrayList<String> qList = new ArrayList<String>();

		String line;
		
		while((line = file.readLine()) != null) {
			
		    qList.add(line);
		    
		}
		
		file.close();
		
		return qList;
	}
	
}
