package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Question;
import application.SurveyClient;
import application.User;
import application.AccountClient;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class SurveyController implements Initializable {
	
	@FXML private Button nextQuestionBtn;
	@FXML private Label questionTxt;
	@FXML private ToggleGroup answersRadioGroup;
	
	@FXML private Label allQuestionCount;
	@FXML private Label currentQuestionNumber;
	@FXML private TextArea userCommentField;
	
	
	@FXML private VBox questionSection;
	@FXML private VBox radioVbox;
	
	private User currentUser;
	private AccountClient userAccount;
	private ArrayList<Question> questionList;
	private ArrayList<Question> answerList = new ArrayList<>();
	private Question currentAnswer;
	private SurveyClient clientQuestions;
	
	private int qIndex = 0;
	
	public SurveyController() {

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 * initialize the Account class and question class in the server
		 */
		userAccount = new AccountClient();
		clientQuestions = new SurveyClient();
		/**
		 * get the question list from the server
		 */
		questionList = new SurveyClient().getqList();
		/**
		 * Add user comment question to the question list
		 */
		questionList.add(new Question("usercomment", "Few words about the experiance with the app"));
		/**
		 * show question count in user interface
		 */
		this.updateMetaData();
		/**s
		 * Show the first question in the user interface
		 */
		showQuestion(qIndex);
		qIndex++;
		/**
		 * Executes when a user select one of radio buttons	
		 */		
		answersRadioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (answersRadioGroup.getSelectedToggle() != null) {	            	 
	            	 /**
	            	  * create answer object using question class when user selecting a toggle button
	            	  */
	            	 RadioButton chk = (RadioButton) answersRadioGroup.getSelectedToggle();
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
	           	 * remove toggle. 
	           	 */
				answersRadioGroup.selectToggle(null);
					
		    	/**
				 * stop going further without a question not answered
				 */
				if(currentAnswer != null) {
					/**
					 * Go through the question array one by one
					 */
					if(questionList.size() > qIndex) {
						/**
						 * Add previously answered question data to answer List
						 */
						answerList.add(currentAnswer);
						currentAnswer = null; // clear the current answer variable
						/**
						 * update the question number in the user interface
						 */
						updateMetaData();
						/**
						 * display the question
						 */
						showQuestion(qIndex);
						qIndex++;	
					
					}else {
						if(!userCommentField.getText().toString().equals(null)) {
							/**
							 * Add the last answer which is the user comment
							 */
							answerList.add(new Question(questionList.get(qIndex-1).getId(), userCommentField.getText().toString(), currentUser.getEmail()));

							/**
							 * hide the next button
							 */
							nextQuestionBtn.setVisible(false);
							
							/**
							 * Show loading text
							 */
							questionSection.getChildren().clear();
							
							Label loadText = new Label();
							
							loadText.setText("Please wait while your data is saving");
							
							questionSection.getChildren().add(loadText);
							/**
							 * end the survey
							 */
							if(surveyEnd()) {
								loadText.setText("Thank you for your support. we will inform you about our future updates");
							}else {
								loadText.setText("We couldn't save your data. Please try again later");
							}

						}					
						
					}
					
				}
	    		 
		    }			
			
		});
		
					
	}
		
	public void setCurrentUser(String fullNameTxt, String emailTxt,String countryTxt,String TDMTxt,String TDOTxt) {
		this.currentUser = new User(fullNameTxt,emailTxt,countryTxt,TDMTxt,TDOTxt);	
	}
	
	private void updateMetaData() {
		/**
		 * show question count in user interface
		 */
		allQuestionCount.setText(Integer.toString(questionList.size()));
		/**
		 * show current question index in user interface
		 */
		currentQuestionNumber.setText(Integer.toString(qIndex + 1));
		
	}
	
	private void showQuestion(int questionIndex) {
		
		if(questionList.get(questionIndex).getId().equals("usercomment")) {
			
			questionTxt.setText(questionList.get(questionIndex).getQuestion());
			/**
			 * hide radio buttons and show text area
			 */
			radioVbox.getChildren().clear();
			
			/**
			 * add a dummy question object to current answer. so the if statement can execute when pressing the next button
			 */
			currentAnswer = new Question("Temp", "Temp", "Temp");
			
			this.showUserComment();	
			
		}else {
			questionTxt.setText(questionList.get(questionIndex).getQuestion());
		}
	}
	
	private void showUserComment() {
		userCommentField.setMinHeight(150);
	}
	
	private boolean surveyEnd() {
//		
//		CompletableFuture.supplyAsync(() -> {
//			
//			return userAccount.newParticipant(currentUser.getFull_name(), currentUser.getEmail(), currentUser.getCountry(), currentUser.getDevice_manufacturer(), currentUser.getDevice_os());
//
//		}).thenApply(result ->{
//			
//			return clientQuestions.submitQuestions(answerList);
//		
//		});
		
		/**
		 * Save data
		 */
		
		if(clientQuestions.submitQuestions(answerList) && userAccount.newParticipant(currentUser.getFull_name(), currentUser.getEmail(), currentUser.getCountry(), currentUser.getDevice_manufacturer(), currentUser.getDevice_os())){
			
			return true;
			
		}		
		
		return false;

				
		/**
		 * show end interface
		 */
		
		
		
	}
	

	


}
