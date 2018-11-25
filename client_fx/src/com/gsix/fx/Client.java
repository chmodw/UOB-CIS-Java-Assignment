package com.gsix.fx;

import java.io.IOException;
import java.rmi.NotBoundException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
//			Parent root = FXMLLoader.load(getClass().getResource("../com/gsix/fx/Register.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Test");
			primaryStage.setScene(scene);
			
			primaryStage.show();
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NotBoundException, ClassNotFoundException, IOException {
		launch(args);
	}
	
}