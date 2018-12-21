package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import application.Question;

public interface IQuestionnaire extends Remote{
	
	/**
	 * Get available questions from the database
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Question> getQuestions() throws RemoteException;
	
	/**
	 * submit the answer. submitted answers will save on the database.
	 * @param submitedQList
	 * @return
	 * @throws RemoteException
	 */
	public boolean submitAnswer(ArrayList<Question> submitedQList) throws RemoteException;
	
	/**
	 * Add new question
	 * @param question
	 * @return
	 * @throws RemoteException
	 */
	public boolean newQuestion(Question question) throws RemoteException;
	
	/**
	 * show or hide a question
	 * @param questionId
	 * @param status
	 * @return
	 * @throws RemoteException
	 */
	public boolean changeStatusQuestion(String questionId, String status) throws RemoteException;

}
