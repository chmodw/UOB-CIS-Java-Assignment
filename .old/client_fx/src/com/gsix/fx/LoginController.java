package com.gsix.fx;

import java.io.IOException;
import java.rmi.RemoteException;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import com.gsix.models.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {
	
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;
    
    @FXML
    private Label wrong_info;
    
    private AccountModel acm;
    
	public LoginController() throws RemoteException, ClassNotFoundException, IOException {
		acm = new AccountModel();
//		
//		System.out.println(acm.login("ashik", "1234"));
		acm.testServer();
	}
	
	public void login(ActionEvent event) throws RemoteException, ClassNotFoundException, IOException {
		
		String username = this.username.getText();
		String password = this.password.getText();
	
		
		if(acm.login(username, password)) {
			
			System.out.println("Loged in");		
			
		}else {
			wrong_info.setText("Wrong Username or Password");
		}
	}
	

}
