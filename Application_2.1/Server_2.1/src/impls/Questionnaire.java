package impls;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.Document;

import application.Question;
import interfaces.IQuestionnaire;
import utils.Helpers;
import utils.Model;
import utils.SentimentAnalysis;

public class Questionnaire extends UnicastRemoteObject implements IQuestionnaire{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	private Model model;

	public Questionnaire() throws RemoteException {
		//instantiate the model class. which includes database functionalities
		model = new Model();
		
	}

	@Override
	public ArrayList<Question> getQuestions() throws RemoteException {
				
		ArrayList<Question> questionList = new ArrayList<>();
		
		String sql = "SELECT * FROM questions";
		
		ResultSet res = model.SELECT(sql);
		
		try {
			while(res.next()) {
								
				if(res.getString("is_active").equals("true")) {
					//get only active questions and add to the array list
					questionList.add(new Question(res.getString("id"),res.getString("question")));
				}	
			}
			// return the questions array list
			Helpers.Status("A Client requeted Question List");
			return questionList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Helpers.Debug("Can't get Questions from the database - " + e.toString());
		}
		
		return null;
	}

	@Override
	public boolean submitAnswer(ArrayList<Question> submitedQList) throws RemoteException {
		//loop through the questions
		for(int i=0; submitedQList.size() > i ; i++) {
						
			String sql;
			String SAR;
			
			sql = "INSERT INTO results (question_id, participent_email, answer, answerd_on) VALUES ('"
					+ submitedQList.get(i).getId() + "','" + submitedQList.get(i).getUser_email() + "','"
					+ submitedQList.get(i).getAnswer() + "','" + submitedQList.get(i).getAnswerd_on() + "')";
			
			//This will pause the loop while data saved in the database. otherwise it will occur an error
			if(!model.INSERT(sql)) {
				return false;
			}
			
			//find the user comment
			if(submitedQList.get(i).getId().equals("usercomment")) {		
				/**
				 * Get the Sentiment analysis result 
				 */
				try {
					SAR = generateSAR(URLEncoder.encode(submitedQList.get(i).getAnswer(), "UTF-8"));
					
				} catch (UnsupportedEncodingException e) {
					// e.printStackTrace();
					Helpers.Debug("Error! Question URL encoding");
					return false; // return the method if some error occurs
				}
						
				sql = "INSERT INTO sentiment_analysis_results (email, sa_result, created_on) VALUES ("
						+ "'" + submitedQList.get(i).getUser_email() + "',"
						+ "'" + SAR + "',"
						+ "'" + submitedQList.get(i).getAnswerd_on() + "'"
						+ ")";
				
				if(!model.INSERT(sql)) {
					return false;
				}
				
			}
	
		}
		
		return true;
	}
	
	private String generateSAR(String answer) {		
		//get the sentimental result from the user comment
		return new SentimentAnalysis(answer).getTone();
	}
	
	
	@Override
	public boolean newQuestion(Question question) throws RemoteException {
		
		 String sql = "INSERT INTO questions (id, question, is_active, created_on) values("
					+ "'" + question.getId() + "',"
					+ "'" + question.getQuestion() + "',"
					+ "'" + question.getIs_active() + "',"
					+ "'" + question.getCreated_on() + "',"
					+ ")";
		
		if(model.INSERT(sql)) {
			return true;
		}
		 
		return false;
	}

	@Override
	public boolean changeStatusQuestion(String questionId, String status) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
