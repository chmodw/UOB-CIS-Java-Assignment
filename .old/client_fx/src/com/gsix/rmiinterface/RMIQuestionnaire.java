package com.gsix.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIQuestionnaire extends Remote{
	
	/**
	 * Add new question. if all went well will return a true, else false
	 * @param Question
	 * @return
	 * @throws RemoteException
	 */
	public boolean newQuestion(Question question) throws RemoteException;
	
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
	public void submitAnswer(int appId, int qID, String answer) throws RemoteException;

}
