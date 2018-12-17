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
	private ArrayList<Question> answerList = new ArrayList<>();
	private Question currentAnswer;
	private int qIndex = 0;
	
	public SurveyController() {

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 * initialize the Account class in the server
		 */
		userAccount = new UserAccount();
		/**
		 * get the question list from the server
		 */
		questionList = new Questions().getqList();
		/**
		 * show question count in user interface
		 */
		this.showMetaData();
		/**
		 * Show the first question in the user interface
		 */
		showQuestion(qIndex);
		qIndex++;
		/**
		 * Executes when a user select one of radio buttons	
		 */
		answersRadio.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (answersRadio.getSelectedToggle() != null) {
	            	 /**
	            	  * create answer object using question class when user selecting a toggle button
	            	  */
	            	 RadioButton chk = (RadioButton) answersRadio.getSelectedToggle();
	            	 /**
	            	  * create a answer object when user selecting a radio button
	            	  */
	            	 currentAnswer = new Question(questionList.get(qIndex-1).getId(), chk.getText(), currentUser.getEmail());	
	             }
	         }
	    });
		/**
		 * Executes when click on the next button in the user interface
		 */
		nextQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {		
				/**
				 * Go through the question array one by one
				 */
				if(questionList.size() > qIndex) {
					/**
					 * Add previously answered question data to answer List
					 */
					answerList.add(currentAnswer);
					/**
					 * update the question number in the user interface
					 */
					showMetaData();
					/**
					 * display the question
					 */
					showQuestion(qIndex);
					qIndex++;	
				
				}else {
					/**
					 * Add the last answer
					 */
					answerList.add(currentAnswer);
					/**
					 * Hide the next button
					 */
					nextQuestionBtn.setVisible(false);
					
					
					for(int i=0; answerList.size() > i; i++) {
						System.out.println(answerList.get(i).getId() + " = " + answerList.get(i).getAnswer());
					}
				}
				
			}	
		});
				
	}
		
	public void setCurrentUser(String fullNameTxt, String emailTxt,String countryTxt,String TDMTxt,String TDOTxt) {
		this.currentUser = new User(fullNameTxt,emailTxt,countryTxt,TDMTxt,TDOTxt);	
	}
	
	private void showMetaData() {
		// show question count in user interface
		allQuestionCount.setText(Integer.toString(questionList.size()));
		//show current question index in user interface
		currentQuestionNumber.setText(Integer.toString(qIndex + 1));
	}
	
	private void showQuestion(int questionIndex) {
		questionTxt.setText(questionList.get(questionIndex).getQuestion());
	}
	
	private void showUserComment() {
		
	}
	


}
