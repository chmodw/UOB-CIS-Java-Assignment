package com.client;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.interfaces.*;
import com.obj.*;

public class Client {
	
	private static IQuestionnaire look_up;
	
    public static void main(String[] args) throws
    MalformedURLException, RemoteException, NotBoundException {

    	look_up = (IQuestionnaire) Naming.lookup("//localhost/BetaTest");
    	
    	ArrayList<Question> qList = look_up.getQuestionnaire();
    	
    	Question nq = qList.get(0);
    	
    	System.out.println(nq.getQuestion());
    }

}
