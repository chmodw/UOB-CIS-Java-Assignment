package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Question;
import interfaces.IQuestionnaire;
import utils.Helpers;
import utils.Model;

public class Questionnaire extends UnicastRemoteObject implements IQuestionnaire{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;

	public Questionnaire() throws RemoteException {
		//instantiate the model class. which includes database functionalities
//		model = new Model();
		
	}

	@Override
	public ArrayList<Question> getQuestions() throws RemoteException {
		
		ArrayList<Question> qList = new ArrayList<>();
		
		String sql = "SELECT * FROM questions";
		
		ResultSet res = model.SELECT(sql);
		
		try {
			while(res.next()) {
								
				if(res.getString("is_active").equals("true")) {
					//get only active questions and add to the array list
					qList.add(new Question(res.getString("id"),res.getString("question")));
				}	
			}
			// return the questions array list
			return qList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Helpers.Debug("Can't get Questions from the database - " + e.toString());
		}
		
		return null;
	}

	@Override
	public boolean submitAnswer(ArrayList<Question> submitedQList) throws RemoteException {
		//loop through the questions
		for(int i=0; i < submitedQList.size(); i++) {
			
			String sql;
			
			//find the user comment
			if(submitedQList.get(i).getId().equals("usercomment")) {
				
				sql = "INSERT INTO sentiment_analysis_result (email, sa_result, created_on) VALUES ("
						+ "'" + submitedQList.get(i).getUser_email() + "'"
						+ "'" + submitedQList.get(i).getSAR() + "'"
						+ "'" + submitedQList.get(i).getAnswerd_on() + "'"
						+ ")";
				
			}else {
				
				sql = "INSERT INTO results (question_id,participent_email, answer, answerd_on) VALUES ("
						+ "'" + submitedQList.get(i).getId() + "'"
						+ "'" + submitedQList.get(i).getUser_email() + "'"
						+ "'" + submitedQList.get(i).getAnswer() + "'"
						+ "'" + submitedQList.get(i).getAnswerd_on() + "'"
						+ ")";
			}
					

			
			//This will pause the loop while data saved in the database. otherwise it will occur an error
			if(!model.INSERT(sql)) {
				return false;
			}
	
		}
		// return true if all went well
		return true;
	}
	
	
	@Override
	public boolean newQuestion(Question question) throws RemoteException {
		
		 String sql = "INSERT INTO questions (id, question, is_active, created_on) values("
					+ "'" + question.getId() + "'"
					+ "'" + question.getQuestion() + "'"
					+ "'" + question.getIs_active() + "'"
					+ "'" + question.getCreated_on() + "'"
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
