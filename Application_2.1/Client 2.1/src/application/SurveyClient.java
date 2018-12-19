package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaces.IQuestionnaire;
import utils.Helpers;

/**
 * @author Chamodya Wimansha
 *
 */

public class SurveyClient {
	
	private IQuestionnaire look_up_questions;
	
	public boolean serverConnection;
	
	private ArrayList<Question> qList;

	public SurveyClient() {
		
		try {
			/**
			 * look for the server
			 */
			look_up_questions = (IQuestionnaire) Naming.lookup("rmi://192.168.8.102/survey/questionnaire");
			serverConnection = true;
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			serverConnection = false;
		}
		/**
		 * get questions from the server
		 */
		fetchQuestions();
		
	}
	
	private void fetchQuestions() {
		try {
			qList = look_up_questions.getQuestions();
		} catch (RemoteException e) {
			Helpers.Debug("Client Questions : Can't fetch questions form the server");
			
		}
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
	
}
