package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Question;
import application.Questions;
import application.User;
import application.UserAccount;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;


public class SurveyController implements Initializable {
	
	@FXML private Button nextQuestionBtn;
	@FXML private Label questionTxt;
	@FXML private ToggleGroup answersRadio;
	
	@FXML private Label allQuestionCount;
	@FXML private Label currentQuestionNumber;
	
	@FXML private VBox questionSection;
//	@FXML private VBox commentSection;
	
	private User currentUser;
	
	private UserAccount userAccount;
	private ArrayList<Question> questionList;

	private int qIndex = 0;
	
	public SurveyController() {

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//initialize the Account class in the server
		userAccount = new UserAccount();
		//get the question list from the server
		questionList = new Questions().getqList();
		
		//show question count in user interface
		this.showMetaData();
		
		// Show the first question
		showQuestion(qIndex);
		qIndex++;
		
		nextQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {			
				if(questionList.size() > qIndex) {
					// refresh the data
					showMetaData();
					//show next question
					showQuestion(qIndex);
					qIndex++;
				}else {
					showUserComment();
					qIndex++;
				}
				
			}	
		});
		
		// TODO Auto-generated method stub		
		answersRadio.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (answersRadio.getSelectedToggle() != null) {
	            	 
	            	 RadioButton chk = (RadioButton) answersRadio.getSelectedToggle();
	                 
	            	 chk.getText();
	            	 
	            	 new Question(questionID, answer, userEmail);
	            	 
	            	 /*********************
	            	  * 
	            	  * 
	            	  * 
	            	  * comment section
	            	  * 
	            	  * Fix question id
	            	  * 
	            	  * 
	            	  * new questions
	            	  * view results
	            	  * 
	            	  * 
	            	  * 
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
	            	 
	            	 
	             }
	         }
	    });
				
	}
		
	public void setCurrentUser(String fullNameTxt, String emailTxt,String countryTxt,String TDMTxt,String TDOTxt) {
		this.currentUser = new User(fullNameTxt,emailTxt,countryTxt,TDMTxt,TDOTxt);	
	}
	
	private void showMetaData() {
		// show question count in user interface
		allQuestionCount.setText(Integer.toString(questionList.size()+1));
		//show current question index in user interface
		currentQuestionNumber.setText(Integer.toString(qIndex + 1));
	}
	
	private void showQuestion(int questionIndex) {
		questionTxt.setText(questionList.get(questionIndex).getQuestion());
	}
	
	private void showUserComment() {
		
	}
	


}
