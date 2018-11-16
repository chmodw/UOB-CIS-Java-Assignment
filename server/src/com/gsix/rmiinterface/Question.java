package com.gsix.rmiinterface;

import java.io.Serializable;

public class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String question = "";
	private String[] answers;
	
	
	public Question(String question, String[] answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	
	/**
	 * return the question
	 * @return
	 */
	public String getQuestion() {
		return this.question;
	}
	/**
	 * get the answers
	 * @return
	 */
	public String[] getAnswers() {
		return this.answers;
	}
	
}
