package controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import application.AccountClient;
import application.Main;
import application.User;
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
					
					User userNow = new User(usernameTxt.getText(), passwordTxt.getText());
					/**
					 * add the user to the Global variable
					 */
					Main.setCurrentUser(userNow);
					
					/**
					 * check the user in the server session for other logins
					 */
					try {
						if(Main.session.find(Main.getCurrentUser().getEmail()) != null) {
							
							errorLbl.setText("This account is already signed in");
							return;
							
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					
					if(accountClient.login(usernameTxt.getText(),passwordTxt.getText())) {	
						
						/**
						 * Add the user to the Session
						 */
						try {	
							Main.session.add(userNow, Main.getCurrentUser().getEmail(),true);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
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
