package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

import application.Question;
import application.SurveyClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DeveloperQuestionsController implements Initializable{
	
//	@FXML private TableView<Question> questionEditTable;
//	@FXML private TableColumn<Question, String> id;
//	@FXML private TableColumn<Question, String> question;
//	@FXML private TableColumn<Question, String> created_on;
//	@FXML private TableColumn<Question, String> active_status;
	
	private ArrayList<Question> qList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		CompletableFuture.runAsync(() -> {
//			
//			/**
//			 * get questions
//			 */
////			qList = new SurveyClient().getqList();
//			
//			
//		});
		
	}
	
	private void getQuestions() {
		
	}
	
	private void populateTableView() {
		
	}
	

}
