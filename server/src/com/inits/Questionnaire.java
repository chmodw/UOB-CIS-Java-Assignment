package com.inits;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.obj.Question;
import com.interfaces.IQuestionnaire;
import com.models.MQuestion;

public class Questionnaire extends UnicastRemoteObject implements IQuestionnaire{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Question> questionsList = new ArrayList<>();
	private int questionCount;

	public Questionnaire() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
//		System.out.println("Questionnaire instantiated");
		fetchQuestion();
	}

	/**
	 *	Fetch all questions from the storage 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public void fetchQuestion() throws FileNotFoundException, IOException{
		

		// call the file read function to get questions and copy the returning array
		ArrayList<String> qList = new ArrayList<String>(MQuestion.fetchQuestions());
		
		// create Question objects
		for (int i = 0; i < qList.size(); i++) {
			String qLine = qList.get(i);
			
			if(qLine != null && !qLine.isEmpty()){
				// create the question object
				questionsList.add(new Question(qLine));
			}
		}
		
	}

	@Override
	public ArrayList<Question> getQuestionnaire() throws RemoteException {
		// TODO Auto-generated method stub
		return questionsList;
	}

	@Override
	public int getQuestionCount() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
