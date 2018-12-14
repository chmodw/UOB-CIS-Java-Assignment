package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserController implements Initializable{
	
	@FXML
	private VBox surveyContent;
	@FXML
	private VBox welcomeContent;
	
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
	private Button startBtn;
	
	private int formValidationErrors = 0;
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 * Validate the input fields
		 */
		startBtn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
		        if(fullNameTxt.getText().isEmpty()) {
		            fullNameError.setText("Please enter your name");
		            formValidationErrors+=1;
		        }
		        
		        if(emailTxt.getText().isEmpty()) {
		            emailError.setText("Please enter your Email address");
		            formValidationErrors+=1;
		        }else {
		        	/**
		        	 * 
		        	 * VAlidate Email. saved it for later
		        	 * 
		        	 */
		        }
		        
		        if(countryTxt.getText().isEmpty()) {
		            countryError.setText("Please your Country of Residence");
		            formValidationErrors+=1;
		        }
		        
		        if(TDMTxt.getText().isEmpty()) {
		        	TDMError.setText("Please enter your device manufacturer");
		        	formValidationErrors+=1;
		        }
		        
		        if(TDOTxt.getText().isEmpty()) {
		        	TDOError.setText("Please enter your device OS");
		        	formValidationErrors+=1;
		        }
				
		        /**
		         * check for any form validation errors if not start the next step
		         */
				if(formValidationErrors == 0) {
					// Do the next steps
					// validation is done
					System.out.println("done");
				}else {
					System.out.println("not");
				}
				
			}
						
		});
		
		/**
		 * Full name text box text change
		 */
		fullNameTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			fullNameError.setText("");
			formValidationErrors-=1;
		});
		
		/**
		 * email text box text change
		 */
		emailTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			emailError.setText("");
			formValidationErrors-=1;
		});
		
		/**
		 * countryTxt text change
		 */
		countryTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			countryError.setText("");
			formValidationErrors-=1;
		});
		
		/**
		 * TDMTxt text change
		 */
		TDMTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			TDMError.setText("");
			formValidationErrors-=1;
		});
		
		/**
		 * TDO text change
		 */
		TDOTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			TDOError.setText("");
			formValidationErrors-=1;
		});
		
		
		
	}
	


	



}


