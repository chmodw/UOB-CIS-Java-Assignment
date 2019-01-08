package developerControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.AccountClient;
import application.Session;
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
import main.Main;
import utils.Securepass;

public class DeveloperManagerController implements Initializable{
	
	@FXML private TextField newUsername;
	@FXML private PasswordField newPassword;
	@FXML private Button newSaveBtn;
	@FXML private Button changePasswordBtn;
	@FXML private PasswordField oldPasswordEditTxt;
	@FXML private PasswordField newPasswordEditTxt;
	@FXML private PasswordField newPasswordAgainEditTxt;
	@FXML private Label newUserMessage;
	@FXML private Label updatePassMessage;
	
	private AccountClient accountClient;
	
	//get the current user from the main class
	private String currentUser = Session.getCurrentUser().getEmail();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		accountClient = new AccountClient();

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

		/**
		 * change password
		 */
		changePasswordBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				if(isEmpty(oldPasswordEditTxt) && isEmpty(newPasswordEditTxt) && isEmpty(newPasswordAgainEditTxt)){
					if(textSize(newPasswordEditTxt, 6)) {
						if(newPasswordEditTxt.getText().equals(newPasswordAgainEditTxt.getText())) {
							if(accountClient.login(currentUser, oldPasswordEditTxt.getText())) {
								/**
								 * encrypt password before send it to the server
								 */
								if(accountClient.updatePass(currentUser,new Securepass(newPasswordEditTxt.getText()).getHash())){
									showMsg(updatePassMessage, "Password Updated", "GREEN");
								}

							}else {
								showMsg(updatePassMessage, "Old password doesn't match", "RED");
							}
						}else {
							showMsg(updatePassMessage, "New password doesn't match", "RED");
						}

					}else {
						showMsg(updatePassMessage, "Password need to be more than 6 charachters", "RED");
					}
					
				}else {
					showMsg(updatePassMessage, "Please type required fields", "RED");
				}
				
			}
		});
	}
	
	/**
	 * Save the new user
	 */
	private void saveUser() {
		//encrypt password before send it to the server
		if(accountClient.newDev(new User(newUsername.getText(),new Securepass(newPassword.getText()).getHash()))) {
			showMsg(newUserMessage, "Developer Account Added", "GREEN");
		}else {
			showMsg(newUserMessage, "Something went wrong. Could't save the developer Account. please try diffrent username", "RED");
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
	
	/**
	 * 
	 * @param fieldName
	 * @param size
	 * @return
	 */
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