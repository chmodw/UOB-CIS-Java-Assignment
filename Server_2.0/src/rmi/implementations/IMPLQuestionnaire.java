package rmi.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import models.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import rmi.classes.Question;
import rmi.interfaces.IQuestionnaire;

/**
 * class for Questionnaire all the questions are stored in a array List
 * @author chamo
 *
 */

public class IMPLQuestionnaire extends UnicastRemoteObject implements IQuestionnaire{
	
	public IMPLQuestionnaire() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	ArrayList<Question> questionList = new ArrayList<>();

	@Override
	public ArrayList<Question> getQuestions() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<Question> qList = new ArrayList<>();
		
		String sql = "SELECT * FROM questions";
		
		ResultSet res = new Model("survey").SELECT(sql);
		
		try {
			while(res.next()) {
				
				qList.add(new Question(res.getInt("id"),res.getString("question")));
				
			}
			
			return qList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean submitAnswer(ArrayList<Question> submitedQList) throws RemoteException {
		
			for(int i=0; i < submitedQList.size(); i++) {
				
				String sql = "INSERT INTO answers (userEmail,question,answer,answerdOn) values ('" 
								+ submitedQList.get(i).getUserEmail() + "','"
								+ submitedQList.get(i).getQuestion() + "','"
								+  submitedQList.get(i).getAnswer() + "','"
								+ submitedQList.get(i).getAnswerdOn() + "')";
				
				//This will pause the loop while data saved in the database. otherwise it will occur an error
				if(!new Model("new_survey").INSERT(sql)) {
					System.out.println("Database Error!");
					return false;
				}
			}
		
		return true;
	}
	

	
}
