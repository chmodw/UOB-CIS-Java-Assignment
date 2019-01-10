package application;

import java.io.Serializable;

import utils.Helpers;

/**
 * Question Class
 * this class will create new question objects and answer object depending on the 
 * input params
 * @author chamo
 *
 */

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String question;
	private String is_active;
	private String created_on;
	
	private String answer;
	private String user_email;
	private String answerd_on;
	/**
	 * This constructor creates a new Question object
	 * @param id
	 * @param question
	 * @param is_active
	 * @param created_on
	 */
	public Question(String id,String question, String is_active,String created_on) {
		this.id = id;
		this.question = question;
		this.is_active = is_active;
		this.created_on = created_on;
	
		Helpers.Status("Question Object Created");
	}
	/**
	 * 
	 * @param question
	 * @param active
	 */
	public Question(String question, boolean active) {
		this.id = qid(question);
		this.question = question;
		this.is_active = String.valueOf(active); //convert boolean to string
		this.created_on = Helpers.DateNow();
		
		Helpers.Status("Question Object Created");
	}
	/**
	 * This constructor creates a Answered question object
	 * 
	 * @param questionID
	 * @param answer
	 * @param userEmail
	 */
	public Question(String questionID, String answer, String userEmail) {
		this.id = questionID;
		this.answer = answer;
		this.user_email = userEmail;
		this.answerd_on = Helpers.DateNow();	
		Helpers.Status("Answered question Object Created");
		
	}
	/**
	 * create a question id by removing spaces in a question
	 * @param question
	 * @return
	 */
	private String qid(String question) {
		// generate question id by removing all characters other than letters
		return question.replaceAll("[^A-Za-z]+", "");
	}
	/**
	 * return the question id
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * returns the question
	 * @return
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * returns the question active or not status
	 * @return
	 */
	public String getIs_active() {
		return is_active;
	}
	/**
	 * returns the question create date
	 * @return
	 */
	public String getCreated_on() {
		return created_on;
	}
	/**
	 * return the answer in a answered question object
	 * @return
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * return the user email in a answered question object
	 * @return
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * return the user email in a answered question object
	 * @return
	 */
	public String getAnswerd_on() {
		return answerd_on;
	}	

}
