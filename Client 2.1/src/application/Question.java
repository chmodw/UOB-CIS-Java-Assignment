package application;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import utils.Helpers;
//import utils.SentimentAnalysis;

/**
 * Question Class
 * this class will create new question objects and answer object
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
	
	// sentimental analysis results
	private String SAR = null;
	
	/**
	 * New question
	 * 
	 * @param question
	 */
	public Question(String id,String question) {
		this.id = id;
		this.question = question;
	
		Helpers.Status("Question Object Created");
	}
	
	public Question(String question, boolean active) {
		this.id = qid(question);
		this.question = question;
		this.is_active = String.valueOf(active); //convert boolean to string
		this.created_on = Helpers.DateNow();
		
		Helpers.Status("Question Object Created");
	}
	
	/**
	 * Answered question
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
		
		if(questionID.equals("usercomment")) {
//			try {
////				this.SAR = generateSAR(URLEncoder.encode(answer, "UTF-8"));
//			} catch (UnsupportedEncodingException e) {
//				// e.printStackTrace();
//				Helpers.Debug("Error! Question URL encoding");
//			}
		}
		
		Helpers.Status("Answered question Object Created");
		
	}
	
	private String qid(String question) {
		// generate question id by removing all characters other than letters
		return question.replaceAll("[^A-Za-z]+", "");
	}
	
//	private String generateSAR(String answer) {		
//		//get the sentimental result from the user comment
//		
//		
////		return new SentimentAnalysis(answer).getTone();
//		
//		
//		
//	}

	public String getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public String getIs_active() {
		return is_active;
	}

	public String getCreated_on() {
		return created_on;
	}

	public String getAnswer() {
		return answer;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getAnswerd_on() {
		return answerd_on;
	}

	public String getSAR() {
		return SAR;
	}
	
	

}
