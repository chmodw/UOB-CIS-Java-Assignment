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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DeveloperHomeController implements Initializable{

	@FXML private VBox developerMain;
	@FXML private VBox mainSection;
	
	@FXML private Button showQuestion;
	@FXML private Label showResults;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		/**
		 * open results section when open the developer window
		 */
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("../guis/DeveloperHomeResults.fxml"));
            		
        	//Load the questions window in the main window
        	mainSection.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        /**
         * show the questions section when click on the questions button
         */
        showQuestion.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				
				/**
				 * remove the current window
				 */
				mainSection.getChildren().clear();;
				
				/**
				 * open the questions window
				 */
		        try {
		        	Parent root = FXMLLoader.load(getClass().getResource("../guis/EditQuestions.fxml"));
		            		
		        	//Load the questions window in the main window
		        	mainSection.getChildren().add(root);
		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        }
				
			}
        	
        });
		
	}
}
