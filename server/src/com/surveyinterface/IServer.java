package com.surveyinterface;

public interface IServer {
	/**
	 * get question and answer from the storage
	 * @return Question
	 */
	public String[] fetchQAndA();
	/**
	 * Starts the questions server
	 */
	public void startServer();
	/**
	 * Restart the server
	 */
	public void restartServer();
	/**
	 * Stop the server
	 */
	public void stopServer();
	/**
	 * delete answers and question from the storage and rest the server settings
	 */
	public void resetServer();
	/**
	 * Test the webserver by sending a Jason request
	 */
	public void testAPI();
	
}
