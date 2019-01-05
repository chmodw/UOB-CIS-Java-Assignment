package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class DeveloperHomeController implements Initializable{

	@FXML private VBox developerMain;
	@FXML private VBox mainSection;
	
	@FXML private Button showQuestion;
	@FXML private Button showResults;
	@FXML private Button showDeveloper;

	private String currentUsername;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		
		/**
		 * open results section when open the developer window
		 */
		openWindow("DeveloperHomeResults");
		
        /**
         * show the questions section when click on the questions button
         */
		showResults.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				/**
				 * open the results window
				 */
				openWindow("DeveloperHomeResults");
			
			}
        	
        });
        
        /**
         * show the questions section when click on the questions button
         */
        showQuestion.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				/**
				 * open the questions window
				 */
				openWindow("EditQuestions");		
			}     	
        });
        
        /**
         * show the developer section when click on the questions button
         */
        showDeveloper.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				/**
				 * open the questions window
				 */
				openWindow("DeveloperManager");		
			}     	
        });
		
	}
	
	/**
	 * a method to open developer windows when user clicks on buttons
	 */
	private void openWindow(String windowName) {
		/**
		 * remove the current window
		 */
		mainSection.getChildren().clear();
		
		/**
		 * open the window
		 */
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("../guis/"+windowName+".fxml"));
            		
        	//Load the questions window in the main window
        	mainSection.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setCurrentUsername(String name){
		this.currentUsername = name;
	}
}
