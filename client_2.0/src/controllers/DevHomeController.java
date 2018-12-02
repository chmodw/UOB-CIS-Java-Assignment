package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import classes.ResultClient;
import classes.UserClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DevHomeController implements Initializable{
	
	private String currentUser;
	private ResultClient rc;
	
//	private TableView<S> resultTable;
	
	public void setCurrentUser(String username) {
		this.currentUser = username;
	}
	
	public DevHomeController() {
		rc = new ResultClient();

		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		/**
		 * show results in the table
		 */
		int results[][] = rc.getResults();
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		
		
	}
}
