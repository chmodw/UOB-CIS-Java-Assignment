package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Parent root = null;
		
		try {
			root = FXMLLoader.load(getClass().getResource("../guis/MainUserWindow.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Beta Test");
        stage.setResizable(false);
        stage.show();
        
	}
	
	public static void main(String[] args) {		
		//Load the main view.
		launch(args);
	}
}
