package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import classes.UserClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.classes.User;

public class DevLoginController implements Initializable{
	
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button loginBtn;
	
	private UserClient userClient;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		userClient = new UserClient();
	
	}

	
	public void login() {
		try {
			if(userClient.developerLogin(new User(username.getText(), password.getText()))) {
				try {
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass().getResource("../guis/DevHome.fxml").openStream());
					
					//Pass the username
					DevHomeController devHomeController = (DevHomeController)loader.getController();
					devHomeController.setCurrentUser(username.getText());
				
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("../guis/application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				}catch(Exception e) {
					e.printStackTrace();
				}		
			}else {
				System.out.println("Wrong username or password");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}














