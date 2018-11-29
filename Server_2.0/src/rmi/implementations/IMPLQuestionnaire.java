package rmi.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import classes.Question;
import rmi.interfaces.IQuestionnaire;

/**
 * class for Questionnaire all the questions are stored in a array List
 * @author chamo
 *
 */

public class IMPLQuestionnaire extends UnicastRemoteObject implements IQuestionnaire{
	
	protected IMPLQuestionnaire() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	ArrayList<Question> questionList = new ArrayList<>();

	@Override
	public ArrayList<Question> getQuestions() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitAnswer(Question question) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

	
}
