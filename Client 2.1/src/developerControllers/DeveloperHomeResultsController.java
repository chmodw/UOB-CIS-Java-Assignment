package developerControllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import application.Question;
import application.Result;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import serverConnections.QuestionClient;
import serverConnections.ResultsConnector;


public class DeveloperHomeResultsController  implements Initializable{

	@FXML private PieChart q1PieChart;
	@FXML private Button loadbtn;
	@FXML private Label totalParticipantCount;
	
	@FXML private TableView<Result> questionsTable; 
	@FXML private TableColumn<Result, String> questionIdCol;
	@FXML private TableColumn<Result, String> questionCol;
	
	@FXML private ComboBox<String> filterByCombo;
	@FXML private ComboBox<String> paramCombo;
	@FXML private Button resultRefreshBtn;
	
	@FXML private StackedBarChart<String, Number> mainResBarChart;
	
	@FXML private VBox resultViewWindow;
	
	private CategoryAxis xAxis = new CategoryAxis(); 
	private NumberAxis yAxis = new NumberAxis(); 

	
	XYChart.Series<String, Number> stronglyDissagree = new XYChart.Series<>();
	XYChart.Series<String, Number> dissagree = new XYChart.Series<>();
	XYChart.Series<String, Number> agree = new XYChart.Series<>();
	XYChart.Series<String, Number> stronglyAgree = new XYChart.Series<>();

	private Map<String, Integer> SARes;
	private ResultsConnector rc;
	private ArrayList<Result> res;
	private ArrayList<Question> qList;
	private String[] params = new String[2];

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	

		rc = new ResultsConnector();
		/**
		 * get the question list from the server
		 */
		qList = new QuestionClient().getqList();

		/**
		 * Set filters for results
		 */
		
		/**
		 * Add data to the param combo
		 */
		filterByCombo.getItems().addAll(
					"Country",
					"OS",
					"Manufacturer"
				);
		
		
		filterByCombo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				params[0] = filterByCombo.getValue();
				
				//Load the values to the params combo from the database
				populateParamCombo(params[0]);
				
			}
		});
		
		paramCombo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				params[1] = filterByCombo.getValue();
			}
		});
		


		resultRefreshBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				onLoad();
			}
		});
		
		onLoad();
		

	}
	
	@SuppressWarnings("unchecked")
	private void onLoad() {
		
		/**
		 * get the main results from the server
		 */
		res = rc.getResults(params);
		
		/**
		 * show the total participant count
		 */
		if(qList != null) {
			totalParticipantCount.setText(Integer.toString(res.get(0).getAnswerCount()));
		}
		
		/**
		 * Get Sentiment analysis results from the server
		 */
		SARes = rc.getSentimentResults();

		/**
		 * Defining the bar chart axis Question IDs
		 */
		xAxis.setCategories(FXCollections.<String>observableArrayList(getQuestionIds())); 
		xAxis.setLabel("Questions");  
		
		yAxis.setLabel("Response Count");
		
		stronglyDissagree.setName("Strongly Dissagree");
		dissagree.setName("Dissagree");
		agree.setName("Agree");		
		stronglyAgree.setName("Strongly Agree");

		
		for(int i=0; res.size() > i; i++) {
			/**
			 * Add data to the bar chart columns
			 */
			addSeriesData(stronglyDissagree,res.get(i).getQuestionId(),res.get(i).getStronglyDissagreeCount());
			
			addSeriesData(dissagree,res.get(i).getQuestionId(),res.get(i).getDissagreeCount());
			
			addSeriesData(agree,res.get(i).getQuestionId(),res.get(i).getAgreeCount());
			
			addSeriesData(stronglyAgree,res.get(i).getQuestionId(),res.get(i).getStronglyAgreeCount());
			
		}
		
		/**
		 * Add data to the stacked bar chart
		 */
		mainResBarChart.getData().addAll(stronglyDissagree, dissagree, agree,stronglyAgree); 
		
		/**
		 * Add questions to the table
		 */
		populateTableview(FXCollections.observableArrayList(res));

		/**
		 * add data to charts
		 */
		ObservableList<Data> list = FXCollections.observableArrayList(
						new PieChart.Data("Joy", SARes.get("joy")),
						new PieChart.Data("Sad", SARes.get("sadness")),
						new PieChart.Data("Angry", SARes.get("fear")),
						new PieChart.Data("Fear", SARes.get("anger")),
						new PieChart.Data("Mix", SARes.get("others"))
						);
		
		q1PieChart.setData(list);
		
	}
	
	private void populateParamCombo(String filters) {
				
		paramCombo.getItems().clear();
		paramCombo.getItems().addAll(rc.getFilterParams(filters));
	}

   private void populateTableview(ObservableList<Result> resultTableData) {
	   
	   	questionIdCol.setCellValueFactory(new PropertyValueFactory<>("QuestionId"));
		questionCol.setCellValueFactory(new PropertyValueFactory<>("Question"));
		
		questionsTable.setItems(resultTableData);
		
   }
   
   private ArrayList<String> getQuestionIds() {
	   	
	   ArrayList<String> ids = new ArrayList<>();
	   	
		for(int i=0;res.size() > i;i++) {
			ids.add(res.get(i).getQuestionId());
		}
		
		return ids;
	   
   }
   
   private void addSeriesData(XYChart.Series<String, Number> se, String name, int data) {
	   se.getData().add(new XYChart.Data<>(name, data));
   }
}