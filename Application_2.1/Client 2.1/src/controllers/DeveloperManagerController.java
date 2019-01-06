package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.AccountClient;
import application.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utils.Securepass;

public class DeveloperManagerController implements Initializable{
	
	@FXML private TextField newUsername;
	@FXML private PasswordField newPassword;
	@FXML private Button newSaveBtn;
	@FXML private Label newUserMessage;
	@FXML private Label updatePassMessage;
	
	private AccountClient accountClient;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		accountClient = new AccountClient();
		System.out.println("Hello");
		/**
		 * Save user 
		 */
		newSaveBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				if(isEmpty(newUsername) && isEmpty(newPassword)){
					if(textSize(newPassword, 6)) {
						saveUser();
					}else {
						showMsg(newUserMessage, "Password need to be more than 6 charachters", "RED");
					}
					
				}else {
					showMsg(newUserMessage, "Please type required fields", "RED");
				}
				
			}
		});

	}
	
	private void saveUser() {
		if(accountClient.newDev(new User(newUsername.getText(),new Securepass(newPassword.getText()).getHash()))) {
			showMsg(newUserMessage, "Developer Account Added", "GREEN");
		}else {
			showMsg(newUserMessage, "Something went wrong. Could't save the developer Account", "RED");
		}
	}

	/**
	 * check TextField 
	 * @param fieldName
	 * @return
	 */
	private boolean isEmpty(TextField fieldName) {
		
		if(!fieldName.getText().trim().isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	private boolean textSize(PasswordField fieldName, int size) {
		
		if(fieldName.getText().toCharArray().length > size) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * check password fields
	 * @param fieldName
	 * @return
	 */
	private boolean isEmpty(PasswordField fieldName) {
		
		if(!fieldName.getText().trim().isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * show messages in labels
	 */
	private void showMsg(Label lblName, String txt,String color) {
		lblName.setText(txt);
		lblName.setTextFill(Color.valueOf(color));
	}
	
}









