package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.classes.Question;

public interface IQuestionnaire extends Remote{

	/**
	 * Get available questions from the database
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Question> getQuestions() throws RemoteException;
	
	/**
	 * submit the answer. submitted answers will save on the database.
	 * @param qID
	 * @param answer
	 * @throws RemoteException
	 */
	public void submitAnswer(Question question) throws RemoteException;

	
}
