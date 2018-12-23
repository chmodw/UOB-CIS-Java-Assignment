package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class DeveloperHomeController implements Initializable{

	@FXML private VBox developerMain;
	@FXML private VBox mainSection;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("../guis/DeveloperHomeResults.fxml"));
            		
        	//Load the questions window in the main window
        	mainSection.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
