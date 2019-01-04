package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import application.Question;
import application.QuestionClient;
import utils.Helpers;

public class DeveloperQuestionsController implements Initializable{
	
	@FXML private TableView<Question> questionEditTable;
	@FXML private TableColumn<Question, String> id;
	@FXML private TableColumn<Question, String> question;
	@FXML private TableColumn<Question, String> created_on;
	@FXML private TableColumn<Question, String> active_status;
	
	@FXML private TextField updateId;
	@FXML private TextField updateQuestion;
	@FXML private CheckBox updateIsActiveCheck;
	@FXML private TextField newQuestionTxt;
	@FXML private CheckBox newQuestionCheck;
	
	
	@FXML private Button newQuestionBtn;
	
	private QuestionClient clientQuestions;
	
	private ArrayList<Question> qList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		clientQuestions = new QuestionClient();
		
		populateTableview(FXCollections.observableArrayList(clientQuestions.getqList()));
		
//		CompletableFuture.supplyAsync(this::updateQuestion);
		
        /**
         * Save the new question when use press the save button
         */
		newQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				
				if(!newQuestionTxt.getText().isEmpty()) {
					System.out.println(clientQuestions.newQuestion(new Question(
							newQuestionTxt.getText(),
							newQuestionCheck.isSelected()
							)));

				}
			}     	
        });
		
	}

   private void populateTableview(ObservableList<Question> resultTableData) {
	   
		id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		question.setCellValueFactory(new PropertyValueFactory<>("Question"));
		created_on.setCellValueFactory(new PropertyValueFactory<>("Created_on"));
		active_status.setCellValueFactory(new PropertyValueFactory<>("Is_active"));
				
		questionEditTable.setItems(resultTableData);
		
   }
   
   private boolean updateQuestion() {
	   
	   /**
	    * get data from the form and create new quesiton object
	    */
	   new Question(
			   updateId.getText(), 
			   updateQuestion.getText(), 
			   ((updateIsActiveCheck.isSelected()) ? "true":"false"), 
			   Helpers.DateNow()
			   );
	   /**
	    * send the question to server to update
	    */
	   
	   return false;
   }
   

//private boolean updateQuestion() {
//	
//    while(true){
//        System.out.println("printing...");
//    }
//}

}
