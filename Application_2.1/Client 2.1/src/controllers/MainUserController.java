package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUserController implements Initializable {
	
	@FXML private StackPane userMainWindow;
	
	@FXML private VBox surveyForm;
	
	@FXML private TextField fullNameTxt;
	@FXML private TextField emailTxt;
	@FXML private TextField countryTxt;
	@FXML private TextField TDMTxt;
	@FXML private TextField TDOTxt;
	
	@FXML private Label fullNameError;
	@FXML private Label emailError;
	@FXML private Label countryError;
	@FXML private Label TDMError;
	@FXML private Label TDOError;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	
	@FXML
	public void startSuervey() throws IOException {
		
		if(!isTextFieldEmpty(fullNameTxt, "Please enter your name", fullNameError) && 
						!isTextFieldEmpty(emailTxt, "Please enter your Email address", emailError) &&
						!isTextFieldEmpty(countryTxt, "Please your Country of Residence", countryError) &&
						!isTextFieldEmpty(TDMTxt, "Please enter your device manufacturer", TDMError) &&
						!isTextFieldEmpty(TDOTxt, "Please enter your device OS", TDOError)) {
			
			
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("../guis/SurveyQuestions.fxml").openStream());
			SurveyController surveyController = (SurveyController)loader.getController();
			//pass the user information the questions window
			surveyController.setCurrentUser(fullNameTxt.getText().toString(),emailTxt.getText().toString(),countryTxt.getText().toString(), TDMTxt.getText().toString(), TDOTxt.getText().toString());
			
			// remove the form from the main window
			userMainWindow.getChildren().remove(surveyForm);
		
        	//Load the questions window in the main window
			userMainWindow.getChildren().add(root);
			
		}
	
	}
	
	@FXML
	public void developerLogin() {

        try {
        	Parent root = FXMLLoader.load(getClass().getResource("../guis/DeveloperLogin.fxml"));
            
			// remove the form from the main window
			userMainWindow.getChildren().remove(surveyForm);
		
        	//Load the questions window in the main window
			userMainWindow.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
