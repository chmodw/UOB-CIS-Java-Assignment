package com.remoteObj;

import java.io.Serializable;

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1190476516911661470L;
	
	private String question;
	
	public Question(String question) {
		this.question = question;
//		System.out.println("Question instantiated");
	}


	public String getQuestion() {
		return question;
	}


}
