package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import interfaces.IQuestionnaire;
import utils.ClientConfig;
import utils.Helpers;

/**
 * @author Chamodya Wimansha
 *
 */

public class QuestionClient {
	
	private IQuestionnaire look_up_questions;
	
	public boolean serverConnection;
	
	private ArrayList<Question> qList;

	public QuestionClient() {
		
		try {
			/**
			 * look for the server
			 */
			look_up_questions = (IQuestionnaire) Naming.lookup("rmi://"+ClientConfig.getIp()+"/survey/questionnaire");
			serverConnection = true;
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			serverConnection = false;
		}
		
		/**
		 * get questions from the server
		 */
		try {
			qList = look_up_questions.getQuestions();
		} catch (RemoteException e) {
			Helpers.Debug("Client Questions : Can't fetch questions form the server");
			
		}
		
	}
	
	public boolean newQuestion(Question question) {
		try {
			return look_up_questions.newQuestion(question);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Question> getqList() {
		return qList;
	}
	
	public boolean submitQuestions(ArrayList<Question> answerList) {
		
		try {
			return look_up_questions.submitAnswer(answerList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Question> getAllQuestions(){
		try {
			return look_up_questions.getAllQuestions();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Update Question
	 */
	
}
