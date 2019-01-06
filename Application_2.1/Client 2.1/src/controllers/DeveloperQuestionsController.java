package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import application.Question;
import application.QuestionClient;

public class DeveloperQuestionsController implements Initializable{
	
	@FXML private TableView<Question> questionEditTable;
	@FXML private TableColumn<Question, String> id;
	@FXML private TableColumn<Question, String> question;
	@FXML private TableColumn<Question, String> created_on;
	@FXML private TableColumn<Question, String> active_status;
	
	@FXML private TextField updateId;
	@FXML private TextField updateQuestionTxt;
	@FXML private CheckBox updateIsActiveCheck;
	@FXML private TextField newQuestionTxt;
	@FXML private CheckBox newQuestionCheck;
	@FXML private Label newQuestionMsg;
	@FXML private Label questionUpdateMsg;
	@FXML private ComboBox<Integer> questionIdCombo;
	@FXML private ComboBox<Integer> deleteQuestionIdCombo;
	
	@FXML private Button deleteBtn;
	@FXML private Label deleteMessage;
	
	
	@FXML private Button newQuestionBtn;
	@FXML private Button updateQuestionBtn;
	
	private QuestionClient clientQuestions;
	
	private ArrayList<Question> qList;
	
	public DeveloperQuestionsController() {
		clientQuestions = new QuestionClient();
		//get all the questions from the database
		qList = clientQuestions.getAllQuestions();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		
		populateTableview(FXCollections.observableArrayList(qList));
		
//		CompletableFuture.supplyAsync(this::updateQuestion);
		
		/**
		 * Add question indexes to the combo box.
		 * this use to modify questions
		 */
		populateCombos();
		
        /**
         * Save the new question when use press the save button
         */
		newQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				
				if(!newQuestionTxt.getText().isEmpty()) {
					
					if(clientQuestions.newQuestion(new Question(newQuestionTxt.getText(), newQuestionCheck.isSelected()))) {
						/**
						 * Show message in the user interface
						 */
						newQuestionMsg.setTextFill(Color.GREEN);
						newQuestionMsg.setText("Question Saved");
						refresh();
						
					}else {
						/**
						 * Show message in the user interface
						 */
						newQuestionMsg.setTextFill(Color.RED);
						newQuestionMsg.setText("Something went wrong, Could't Save the question");
					}
				}
			}     	
        });
		
		/**
		 * Update the question when user click on update button
		 */
		updateQuestionBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				
				if(updateQuestion()) {
					/**
					 * Show message in the user interface
					 */
					questionUpdateMsg.setTextFill(Color.GREEN);
					questionUpdateMsg.setText("Question Updated");
					refresh();
				}else {
					/**
					 * Show message in the user interface
					 */
					questionUpdateMsg.setTextFill(Color.RED);
					questionUpdateMsg.setText("Something went wrong, Could't Update the question");
				}
				
			}
		});
		
		/**
		 * Load a question when user select id number from the combo box
		 */
		questionIdCombo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				//find the relevant question from the qList
				   for(int i=0; qList.size() > i; i++) {
					   if(questionIdCombo.getValue() == Integer.parseInt(qList.get(i).getId())){
							updateQuestionTxt.setText(qList.get(i).getQuestion());
							//check or uncheck the is active 
							if(qList.get(i).getIs_active().equals("true")) {
								updateIsActiveCheck.setSelected(true);
							}else {
								updateIsActiveCheck.setSelected(false);
							}	
					   }
				   }
				
			}
		});
		
		deleteBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				if(clientQuestions.deleteQuestion(deleteQuestionIdCombo.getValue())) {
					/**
					 * Show message in the user interface
					 */
					deleteMessage.setTextFill(Color.GREEN);
					deleteMessage.setText("Deleted");
					refresh();
					
				}else {
					/**
					 * Show message in the user interface
					 */
					deleteMessage.setTextFill(Color.RED);
					deleteMessage.setText("Something went wrong, Could't delete the question");
				}
			}
		});
		
		/**
		 * Enable the Delete button after selecting a question id from the combobox
		 */
		deleteQuestionIdCombo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				deleteBtn.setDisable(false);
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
	   
	   if(clientQuestions.updateQuestion(questionIdCombo.getValue(), updateQuestionTxt.getText(), Boolean.toString(updateIsActiveCheck.isSelected()))){
		   return true;
	   }
	   return false;
   }
   
   private void populateCombos() {   
	   new Thread(() -> {
		   for(int i=0; qList.size() > i; i++) {
			   questionIdCombo.getItems().add(Integer.parseInt(qList.get(i).getId()));
			   deleteQuestionIdCombo.getItems().add(Integer.parseInt(qList.get(i).getId()));
		   }
		}).start();
   }
   
   /**
    * refresh the Table
    */
   private void refresh() {
	   new Thread(() -> {
		    System.out.println("Hi");
		}).start();
   }
 
}
