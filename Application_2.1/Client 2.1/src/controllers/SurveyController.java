package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import application.Question;
import application.Questions;
import application.User;
import application.UserAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SurveyController implements Initializable {
	
	@FXML private Button nextQuestionBtn;
	
	private User currentUser;
	
	private UserAccount userAccount;
	private ArrayList<Question> questionList;
	
	public SurveyController() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//initialize the Account class in the server
		userAccount = new UserAccount();
		//get the question list from the server
		questionList = new Questions().getqList();
		
		nextQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println(currentUser.getFull_name());
			}
			
		});
		
		
	}
	
	
	public void setCurrentUser(String fullNameTxt, String emailTxt,String countryTxt,String TDMTxt,String TDOTxt) {
		this.currentUser = new User(fullNameTxt,emailTxt,countryTxt,TDMTxt,TDOTxt);	
	}

}
