package com.gsix.rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.gsix.rmiinterface.Question;
import com.gsix.rmiinterface.RMIQuestionnaire;
import com.gsix.helpers.*;

public class IMPLQuestionnaire extends UnicastRemoteObject implements RMIQuestionnaire{

	protected IMPLQuestionnaire() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean newQuestion(Question question) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Question> getQuestions() throws RemoteException {
		// TODO Auto-generated method stub
		return Model.loadQuestions();
	}

	@Override
	public void submitAnswer(int appId, int qID, String answer) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
