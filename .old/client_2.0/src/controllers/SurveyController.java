package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import rmi.classes.Question;
import classes.QuestionnaireClient;


public class SurveyController implements Initializable{
	

	private String currentUserName;
	private String currentUserEmail;
	
	private ArrayList<Question> answerdQList = new ArrayList<>();
	private Question a1;
	private Question a2;
	private Question a3;
	private Question a4;
	private Question a5;
	private Question a6;
	private Question a7;
	private Question a8;
	private Question a9;
		
	@FXML
	private Label question1;
	@FXML
	private Label question2;
	@FXML
	private Label question3;
	@FXML
	private Label question4;
	@FXML
	private Label question5;
	@FXML
	private Label question6;
	@FXML
	private Label question7;
	@FXML
	private Label question8;
	
	@FXML
	private Button servaySubmit;
	
	@FXML
	private ToggleGroup question1A;
	@FXML
	private ToggleGroup question2A;
	@FXML
	private ToggleGroup question3A;
	@FXML
	private ToggleGroup question4A;
	@FXML
	private ToggleGroup question5A;
	@FXML
	private ToggleGroup question6A;
	@FXML
	private ToggleGroup question7A;
	@FXML
	private ToggleGroup question8A;
	
	@FXML
	private Button surveySubmit;
	
	
	@FXML
	private TextArea userCommentTextArea;
	
	
	
	private QuestionnaireClient questionnaireClient = new QuestionnaireClient();
	
	private ArrayList<Question> qList;

	public SurveyController() {
		
		//Get questions from the server
		qList = questionnaireClient.getQuestions();

			
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 * Show questions in labels
		 */
	    question1.setText(qList.get(0).getQuestion());
	    question2.setText(qList.get(1).getQuestion());
	    question3.setText(qList.get(2).getQuestion());
	    question4.setText(qList.get(3).getQuestion());
	    question5.setText(qList.get(4).getQuestion());
	    question6.setText(qList.get(5).getQuestion());
	    question7.setText(qList.get(6).getQuestion());
	    question8.setText(qList.get(7).getQuestion());
	    	    
	    

	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question1A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question1A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question1A.getSelectedToggle().toString());
	   
	                 a1 = new Question(qList.get(0).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question2A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question2A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question2A.getSelectedToggle().toString());

	                 a2 = new Question(qList.get(1).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question3A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question3A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question3A.getSelectedToggle().toString());
	                 
	                 a3 = new Question(qList.get(2).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question4A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question4A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question4A.getSelectedToggle().toString());
	                 
	                 a4 = new Question(qList.get(3).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question5A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question5A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question5A.getSelectedToggle().toString());
		                 
	                 a5 = new Question(qList.get(4).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question6A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question6A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question6A.getSelectedToggle().toString());
	                 
	                 a6 = new Question(qList.get(5).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question7A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question7A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question7A.getSelectedToggle().toString());
	                 
	                 a7 = new Question(qList.get(6).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    
	    /**
	     * Get answers radio buttons selected
	     */
	    question8A.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	
	        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

	             if (question8A.getSelectedToggle() != null) {

	                 String answer = selectedAnswer(question8A.getSelectedToggle().toString());
	                 
	                 a8 = new Question(qList.get(7).getQuestion(),answer, currentUserEmail, getNow());
	             }
	         }
	    });
	    	    
	}
	
	private Question getUserComment() {
		
		return new Question("User Comment",userCommentTextArea.getText(), currentUserEmail, getNow());
		
	}
	
    
    /**
     * Submit the answers
     * @throws RemoteException 
     */
	public void submit(ActionEvent event) throws RemoteException {
		
		answerdQList.add(a1);
    	answerdQList.add(a2);
    	answerdQList.add(a3);
    	answerdQList.add(a4);
    	answerdQList.add(a5);
    	answerdQList.add(a6);
    	answerdQList.add(a7);
    	answerdQList.add(a8);
    	answerdQList.add(a9 = getUserComment());

    	if(questionnaireClient.submitQuestions(answerdQList)) {
    		
    		surveySubmit.setText("Thank you");
    		
    	}else {
    		
    	}
    	
	}
	
	/**
	 * identify the answer according to the selected radio button
	 * @param str
	 * @return
	 */
	private String selectedAnswer(String str) {
		
		if(str.indexOf("A1") !=-1) {
			return "Strongly Disagree";
		
		}else if(str.indexOf("A2") !=-1){
		
			return "Disagree";
			
		}else if(str.indexOf("A3") !=-1){
			
			return "agree";
			
		}else if(str.indexOf("A4") !=-1){
			
			return "Strongly agree";
			
		}
		
		return null;
	}
	
	public void setUser(String fullName,String email) {
		 this.currentUserName = fullName;
		 this.currentUserEmail = email;
	}
	
	private String getNow() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}



















