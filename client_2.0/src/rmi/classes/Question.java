package rmi.classes;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * Question Class
 * @author chamo
 *
 */
public class Question implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String question;
	private String answer;
	private String userEmail;
	private String answerdOn;
	
	public Question(int id, String question) {
		this.ID = id;
		this.question = question;
	}
	
	/**
	 * Answered question
	 * @param question
	 * @param answer
	 * @param userEmail
	 */
	public Question(String question,String answer, String userEmail, String answerdOn){
		this.question = question;
		this.answer = answer;
		this.userEmail = userEmail;
		this.answerdOn = answerdOn;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAnswer() {
		return answer;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getAnswerdOn() {
		return answerdOn;
	}

	/**
	 * return the question as String
	 * @return
	 */
	public String getQuestion() {
		return this.question;
	}

	@Override
	public String toString() {
		return "Question [ID=" + ID + ", question=" + question + ", answer=" + answer + ", userEmail=" + userEmail
				+ ", answerdOn=" + answerdOn + "]";
	}
		
}