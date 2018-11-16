package com.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class will deal with storage
 * @author chamo
 *
 */

public class MQuestion {

	private final static String path = "storage/questionlist.txt";
	
		
	public MQuestion() {
		/**
		 * Reads the questions
		 */
		
	}
	
	public static String fread() throws FileNotFoundException, IOException {
		System.out.println("FRead called");
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	return line;
		    }
		}
		
		return null;
	}
	
//	public MQuestions(String question) {
//		
//	}
	
}
