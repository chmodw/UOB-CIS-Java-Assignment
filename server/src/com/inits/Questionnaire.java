package com.inits;

//import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.obj.Question;
import com.interfaces.IQuestionnaire;
//import com.models.MQuestion;

public class Questionnaire extends UnicastRemoteObject implements IQuestionnaire{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Question> questionsList = new ArrayList<>();

	public Questionnaire() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Questionnaire instantiated");
	}

	@Override
	public void fetchQuestion() throws RemoteException{
		questionsList.add(new Question("This the first question"));
	}

	@Override
	public ArrayList<Question> getQuestionnaire() throws RemoteException {
		// TODO Auto-generated method stub
		return questionsList;
	}
	
	
	
	

}
