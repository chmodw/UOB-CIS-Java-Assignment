package com.gsix.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.gsix.rmiinterface.*;

public class Client {
	

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
				
		try {
			RMIQuestionnaire questionnaire = (RMIQuestionnaire) Naming.lookup("//localhost/QuestionService1819");
			System.out.println(questionnaire.getQuestions());
		}catch (Exception e) {
			System.out.println("A problem occured: "+e.toString());
			e.printStackTrace();
			System.out.println("Is your server running?");
		}

		}
	
}