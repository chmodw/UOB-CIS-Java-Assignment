package com.gsix.client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.gsix.rmiinterface.RMIQuestionnaire;

public class Questionnaire {
	
	private RMIQuestionnaire questionnaire;
	
	public  Questionnaire() {
		try {
			questionnaire = (RMIQuestionnaire) Naming.lookup("//localhost/betaservay/Questionnaire");
		}catch (Exception e) {
			System.out.println("A problem occured: "+e.toString());
			e.printStackTrace();
			System.out.println("Is your server running?");
		}		
	}
	
	public void startQuestionnaire() throws RemoteException {
		
		for(int i=0; questionnaire.getQuestions().size() > i;i++) {
			System.out.println(questionnaire.getQuestions().get(i).getQuestion());
			System.out.println(questionnaire.getQuestions().get(i).getAnswers()[1]);
		}
		
		
	}
	
}
