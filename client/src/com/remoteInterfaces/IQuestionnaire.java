package com.remoteInterfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.remoteObj.*;

public interface IQuestionnaire extends Remote{

	/**
	 * Get all the questions from the storage
	 * @throws RemoteException
	 */
	void fetchQuestion() throws RemoteException, FileNotFoundException, IOException;
	/**
	 * @return entire question list
	 * @throws RemoteException
	 */
	ArrayList<Question> getQuestionnaire() throws RemoteException;
	/**
	 * @return number of questions fetch from the storage
	 * @throws RemoteException
	 */
	int getQuestionCount()throws RemoteException;
	
}

