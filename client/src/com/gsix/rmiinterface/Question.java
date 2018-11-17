package com.gsix.rmiinterface;

import java.io.Serializable;

public class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int qNumber;
	private String question = "";
	private String[] answers;
	
	
	public Question(int qNumber, String question, String[] answers) {
		super();
		this.qNumber = qNumber;
		this.question = question;
		this.answers = answers;
	}
	
	/**
	 * get the qNumber
	 * @return
	 */
	public int getqNumber() {
		return this.qNumber;
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
