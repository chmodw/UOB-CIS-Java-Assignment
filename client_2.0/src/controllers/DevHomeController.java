package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DevHomeController extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
//			 BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("../guis/DevHome.fxml"));
			primaryStage.setTitle("Beta Test Survey 1.0");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			// Link the stylesheet
			scene.getStylesheets().add(getClass().getResource("../guis/application.css").toExternalForm());
			
			primaryStage.setResizable(false);
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DevHomeController(){
		
		// Add columns to the table
    
		
	}
	
	public void load() {
		launch();
	}

}
