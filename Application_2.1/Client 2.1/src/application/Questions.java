package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaces.IQuestionnaire;
import utils.Helpers;

public class Questions {
	
	private IQuestionnaire look_up_questions;
	
	public boolean serverConnection;
	
	private ArrayList<Question> qList;

	public Questions() {
		
		try {
			look_up_questions = (IQuestionnaire) Naming.lookup("rmi://192.168.1.2/survey/questionnaire");
			serverConnection = true;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			serverConnection = false;
		}
		
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
	
//	public boolean submitQuestions() {
//		
//	}
	
}
