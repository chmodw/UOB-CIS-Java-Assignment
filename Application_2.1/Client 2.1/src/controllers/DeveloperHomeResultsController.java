package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

import application.Question;
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

public class DeveloperHomeResultsController  implements Initializable{

	@FXML private PieChart q1PieChart;
	@FXML private Button loadbtn;
	
	@FXML private TableView<String> resultTable; 
	@FXML private TableColumn<String, Integer> aCol;
	@FXML private TableColumn<String, Integer> dCol;
	@FXML private TableColumn<String, Integer> saCol;
	@FXML private TableColumn<String, Integer> sdCol;
	
	private ResultsConnector rc = new ResultsConnector();
	private Map<String, Integer[]> res;
	private ArrayList<Question> qList;
	
	
	
	public DeveloperHomeResultsController() {
        
		

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 * Load data without blocking
		 */
		CompletableFuture.runAsync(() -> {
			
			/**
			 * get the question list from the server
			 */
			qList = new SurveyClient().getqList();
			
			/**
			 * get the main results from the server
			 */
			res = rc.getResults();
						
			for ( Entry<String, Integer[]> entry : res.entrySet()) {
			    String key = entry.getKey();
			    Integer[] tab = entry.getValue();
			    
			    System.out.println(key + " == " + tab[0].toString() + " : " + tab[1].toString() + " : " + tab[2].toString() + " : " + tab[3].toString());
			    
			    // do something with key and/or tab
			}


		    
//			ObservableList<Data> list = FXCollections.observableArrayList(
//							
//							new PieChart.Data("Java", 50),
//							new PieChart.Data("JavaScript", 25),
//							new PieChart.Data("PHP", 10),
//							new PieChart.Data("Node", 15)
//							);
//			q1PieChart.setData(list);
			
		});

		
	}
	


	
	
}
