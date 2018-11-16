package com.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.obj.*;

public interface IQuestionnaire extends Remote{

	/**
	 * Get all the questions
	 * @return
	 * @throws RemoteException
	 */
	void fetchQuestion() throws RemoteException;
	
	ArrayList<Question> getQuestionnaire() throws RemoteException;
	
}
