package com.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.interfaces.*;;

public class Client {
	
	private static IQuestionnaire look_up;
	
    public static void main(String[] args) throws
    MalformedURLException, RemoteException, NotBoundException {

    	look_up = (IQuestionnaire) Naming.lookup("//localhost/MyBookstore");
    	
    	System.out.println(look_up.getQuestionnaire());
    }

}
