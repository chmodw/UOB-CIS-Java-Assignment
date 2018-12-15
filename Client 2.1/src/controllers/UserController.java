package controllers;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Questions;
import application.User;
import application.UserAccount;
import application.Question;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.Helpers;

public class UserController implements Initializable{
	
	@FXML
	private VBox surveyContent;
	@FXML
	private VBox welcomeContent;
	@FXML
	private AnchorPane mainUserWindow;
	
	@FXML
	private TextField fullNameTxt;
	@FXML
	private TextField emailTxt;
	@FXML
	private TextField countryTxt;
	@FXML
	private TextField TDMTxt;
	@FXML
	private TextField TDOTxt;
	
	@FXML
	private Label fullNameError;
	@FXML
	private Label emailError;
	@FXML
	private Label countryError;
	@FXML
	private Label TDMError;
	@FXML
	private Label TDOError;
	
	@FXML
	private Label serverStatus;
	
	@FXML
	private Button startBtn;

	private UserAccount userAccount;
	private User currentUser;
	private ArrayList<Question> questionList;
	
	public UserController() {
		
		userAccount = new UserAccount();
		
		questionList = new Questions().getqList();
	
	}
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(userAccount.serverConnection) {
			serverStatus.setText("Online");
			serverStatus.setTextFill(Color.web("#008000"));
		} else {
			serverStatus.setText("Offline");
			serverStatus.setTextFill(Color.web("##FF0000"));
		}
		
		/**
		 * Validate the input fields
		 */
		startBtn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				/**
				 * Check for empty Text fields 
				 */
				if(!isTextFieldEmpty(fullNameTxt, "Please enter your name", fullNameError) && 
								!isTextFieldEmpty(emailTxt, "Please enter your Email address", emailError) &&
								!isTextFieldEmpty(countryTxt, "Please your Country of Residence", countryError) &&
								!isTextFieldEmpty(TDMTxt, "Please enter your device manufacturer", TDMError) &&
								!isTextFieldEmpty(TDOTxt, "Please enter your device OS", TDOError)) {
					//if all the text fields are not empty
					
		        	//create a new user object
		        	currentUser = new User(fullNameTxt.getText().toString(),emailTxt.getText().toString(),countryTxt.getText().toString(), TDMTxt.getText().toString(), TDOTxt.getText().toString());       	
		        	
		        	// Hide the form
		        	welcomeContent.setVisible(false);
		    		
		    		// show the questions
		        	surveyContent.setVisible(true);	
		        	
		        	new SurveyController();
				}    	
			}			
		});
		
		/**
		 * Full name text box text change
		 */
		fullNameTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			fullNameError.setText("");
		});
		
		/**
		 * email text box text change
		 */
		emailTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			emailError.setText("");
		});
		
		/**
		 * countryTxt text change
		 */
		countryTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			countryError.setText("");
		});
		
		/**
		 * TDMTxt text change
		 */
		TDMTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			TDMError.setText("");
		});
		
		/**
		 * TDO text change
		 */
		TDOTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			TDOError.setText("");
		});
		
	}
	
	/**
	 * return true if a text field empty
	 * @param fieldName
	 * @param errorMsg
	 * @param errorField
	 */
	private boolean isTextFieldEmpty(TextField fieldName, String errorMsg, Label errorField) {
		
        if(fieldName.getText().isEmpty()) {
            errorField.setText(errorMsg);
            return true;
         }
        
        return false;
        
	}
	
}


