package client;
	
import classes.UserClient;
import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.classes.*;
import rmi.interfaces.*;


public class Main extends Application{
	
//	private UserClient userClient = new UserClient();

	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../guis/Start.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../guis/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
