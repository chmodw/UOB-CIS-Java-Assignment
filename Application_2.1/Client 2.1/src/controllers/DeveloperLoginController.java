package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AccountClient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DeveloperLoginController  implements Initializable {
	
	@FXML private StackPane userMainWindow;
	@FXML private TextField usernameTxt;
	@FXML private PasswordField passwordTxt;
	@FXML private Button loginBtn;
	@FXML private Label errorLbl;
	
	AccountClient accountClient;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		accountClient = new AccountClient();
			
		loginBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {		
				
				if(usernameTxt.getText().toString() != null && passwordTxt.getText() != null) {
					
					if(accountClient.login(usernameTxt.getText().toString(),passwordTxt.getText())) {
						
						/**
						 * open the developer home
						 */
						showHome();
						/**
						 * Close the login window
						 */
			            ((Node) event.getSource()).getScene().getWindow().hide();
						
					}else {
						
						errorLbl.setText("Username or password is incorrect");
						
					}
				}		
				
			}
		});	
		
		usernameTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			errorLbl.setText("");
		});
		
		passwordTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			errorLbl.setText("");
		});
		
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * SESSION CLASS 
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
	
	private void showHome() {
		/**
		 * open the developer home window and close the login window
		 */
        try {
        	
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("../guis/DeveloperHome.fxml").openStream());
			DeveloperHomeController dhc = (DeveloperHomeController)loader.getController();
			// pass the username to the developer home controller class
			dhc.setCurrentUsername(usernameTxt.getText());
			
            Stage stage = new Stage();
            stage.setTitle("Developer Home");
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}

}
