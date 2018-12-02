package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import classes.ResultClient;
import classes.UserClient;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DevHomeController implements Initializable{
	
	private String currentUser;
	private ResultClient rc;
	
	@FXML
	private Label q1a1;	
	@FXML
	private Label q1a2;
	@FXML
	private Label q1a3;
	@FXML
	private Label q1a4;	
	
	@FXML
	private Label q2a1;
	@FXML
	private Label q2a2;
	@FXML
	private Label q2a3;	
	@FXML
	private Label q2a4;
	
	@FXML
	private Label q3a1;	
	@FXML
	private Label q3a2;
	@FXML
	private Label q3a3;
	@FXML
	private Label q3a4;	
	
	@FXML
	private Label q4a1;
	@FXML
	private Label q4a2;
	@FXML
	private Label q4a3;	
	@FXML
	private Label q4a4;
	
	@FXML
	private Label q5a1;	
	@FXML
	private Label q5a2;
	@FXML
	private Label q5a3;
	@FXML
	private Label q5a4;
	
	@FXML
	private Label q6a1;	
	@FXML
	private Label q6a2;
	@FXML
	private Label q6a3;
	@FXML
	private Label q6a4;	

	@FXML
	private Label q7a1;	
	@FXML
	private Label q7a2;
	@FXML
	private Label q7a3;
	@FXML
	private Label q7a4;	
	
	@FXML
	private Label q8a1;
	@FXML
	private Label q8a2;
	@FXML
	private Label q8a3;	
	@FXML
	private Label q8a4;
	
//	private TableView<S> resultTable;
	
	public void setCurrentUser(String username) {
		this.currentUser = username;
	}
	
	public DevHomeController() {
		rc = new ResultClient();
		
		try {
			rc.sentimentAnalysis();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int results[][] = rc.getResults();
		
		q1a1.setText(Integer.toString(results[0][0]));
		q1a2.setText(Integer.toString(results[0][1]));
		q1a3.setText(Integer.toString(results[0][2]));
		q1a4.setText(Integer.toString(results[0][3]));
		
		q2a1.setText(Integer.toString(results[1][0]));
		q2a2.setText(Integer.toString(results[1][1]));
		q2a3.setText(Integer.toString(results[1][2]));
		q2a4.setText(Integer.toString(results[1][3]));
		
		q3a1.setText(Integer.toString(results[2][0]));
		q3a2.setText(Integer.toString(results[2][1]));
		q3a3.setText(Integer.toString(results[2][2]));
		q3a4.setText(Integer.toString(results[2][3]));
		
		q3a1.setText(Integer.toString(results[3][0]));
		q3a2.setText(Integer.toString(results[3][1]));
		q3a3.setText(Integer.toString(results[3][2]));
		q3a4.setText(Integer.toString(results[3][3]));
		
		q4a1.setText(Integer.toString(results[4][0]));
		q4a2.setText(Integer.toString(results[4][1]));
		q4a3.setText(Integer.toString(results[4][2]));
		q4a4.setText(Integer.toString(results[4][3]));
	
		q5a1.setText(Integer.toString(results[5][0]));
		q5a2.setText(Integer.toString(results[5][1]));
		q5a3.setText(Integer.toString(results[5][2]));
		q5a4.setText(Integer.toString(results[5][3]));
		
		q6a1.setText(Integer.toString(results[6][0]));
		q6a2.setText(Integer.toString(results[6][1]));
		q6a3.setText(Integer.toString(results[6][2]));
		q6a4.setText(Integer.toString(results[6][3]));

		q7a1.setText(Integer.toString(results[7][0]));
		q7a2.setText(Integer.toString(results[7][1]));
		q7a3.setText(Integer.toString(results[7][2]));
		q7a4.setText(Integer.toString(results[7][3]));
		
		q8a1.setText(Integer.toString(results[8][0]));
		q8a2.setText(Integer.toString(results[8][1]));
		q8a3.setText(Integer.toString(results[8][2]));
		q8a4.setText(Integer.toString(results[8][3]));
	
		
	}
}
