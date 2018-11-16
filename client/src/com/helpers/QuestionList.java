package com.helpers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.remoteInterfaces.IQuestionnaire;
import com.remoteObj.Question;

public class QuestionList {
	

	public QuestionList() throws MalformedURLException, RemoteException, NotBoundException{

		IQuestionnaire look_up = (IQuestionnaire) Naming.lookup("//localhost/BetaTest");
//    	
//    	ArrayList<Question> qList = look_up.getQuestionnaire();
//    	
////    	Question nq = qList.get(0);
//    	
////    	System.out.println(nq.getQuestion());
    	
    }

}
