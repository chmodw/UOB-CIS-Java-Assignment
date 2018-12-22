package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import application.Question;
import application.Result;
import application.ResultsConnector;
import application.SurveyClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class DeveloperHomeResultsController  implements Initializable{

	@FXML private PieChart q1PieChart;
	@FXML private Button loadbtn;
	
	@FXML private TableView<Result> resultTable; 
	@FXML private TableColumn<Result, String> qIndexCol;
	@FXML private TableColumn<Result, Integer> aCol;
	@FXML private TableColumn<Result, Integer> dCol;
	@FXML private TableColumn<Result, Integer> saCol;
	@FXML private TableColumn<Result, Integer> sdCol;

	private Map<String, Integer> SARes;
	private ResultsConnector rc;
	private ArrayList<Result> res;
	private ArrayList<Question> qList;
	
	
	
	
	public DeveloperHomeResultsController() {
        
		

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	

		try {
			startup.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Load data without blocking
	 */
	CompletableFuture<Void> startup = CompletableFuture.runAsync(() -> {
		
		
		rc = new ResultsConnector();
		
		/**
		 * get the question list from the server
		 */
		qList = new SurveyClient().getqList();
		
		/**
		 * get the main results from the server
		 */
		res = rc.getResults();
		
		/**
		 * Get Sentiment analysis results from the server
		 */
		SARes = rc.getSentimentResults();
		
		/**
		 * Add data to the table
		 */
		populateTableview(FXCollections.observableArrayList(res));
		
		System.out.println();

		/**
		 * add data to charts
		 */
		
//		System.out.println(SARes.get("joy"));
//		System.out.println(SARes.get("sadness"));
//		System.out.println(SARes.get("fear"));
//		System.out.println(SARes.get("anger"));
//		System.out.println(SARes.get("others"));
		
	    
		ObservableList<Data> list = FXCollections.observableArrayList(
						
						new PieChart.Data("Joy", SARes.get("joy")),
						new PieChart.Data("Sad", SARes.get("sadness")),
						new PieChart.Data("Angry", SARes.get("fear")),
						new PieChart.Data("Fear", SARes.get("anger")),
						new PieChart.Data("Mix", SARes.get("others"))
						);
		q1PieChart.setData(list);
		
	});
	

	

	   private void populateTableview(ObservableList<Result> resultTableData) {
		   
			qIndexCol.setCellValueFactory(new PropertyValueFactory<>("Question"));
			sdCol.setCellValueFactory(new PropertyValueFactory<>("StronglyDissagreeCount"));
			dCol.setCellValueFactory(new PropertyValueFactory<>("DissagreeCount"));
			aCol.setCellValueFactory(new PropertyValueFactory<>("AgreeCount"));
			saCol.setCellValueFactory(new PropertyValueFactory<>("StronglyAgreeCount"));
			
			resultTable.setItems(resultTableData);
			
	   }
}
