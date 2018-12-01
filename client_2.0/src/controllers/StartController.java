package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import classes.UserClient;
import client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.classes.User;

public class StartController implements Initializable{
	
	private UserClient userClient = new UserClient();
		
	@FXML
	private TextField fullNameTxt;
	@FXML
	private TextField emailTxt;
	@FXML
	private TextField ageTxt;
	@FXML
	private TextField countryTxt;
	@FXML
	private TextField testDeviceManufacturerTxt;
	@FXML
	private TextField osTxt;
	@FXML
	private Label showError;
	
	@FXML
	public Button startSurveyBtn;
	
	public StartController() {

	}
	
	public void startSurvey(ActionEvent event) {
		
		String fullName = fullNameTxt.getText();
		String email = emailTxt.getText();
		String age = ageTxt.getText();
		String country = countryTxt.getText();
		String testDeviceManufacturer = testDeviceManufacturerTxt.getText();
		String os = osTxt.getText();
		
		if(!userClient.checkServer()) {
			showError.setText("Server is Offline. Try again later");
		}else {
			if(!fullName.isEmpty() && !email.isEmpty() && !age.isEmpty() && !country.isEmpty() && !testDeviceManufacturer.isEmpty() && !os.isEmpty()) {
				showError.setText("   ");
				try {
					
					if(userClient.saveParticipant(fullName,email,age,country,testDeviceManufacturer,os)) {
					
						try {
							Stage primaryStage = new Stage();
							FXMLLoader loader = new FXMLLoader();
							Pane root = loader.load(getClass().getResource("../guis/Survey.fxml").openStream());
							
							//Pass the user object to the survey Controller
							SurveyController surveyController = (SurveyController)loader.getController();
							surveyController.setUser(fullName,email);
							
							Scene scene = new Scene(root);
							scene.getStylesheets().add(getClass().getResource("../guis/application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}		
						
					}else {
						showError.setText("Something went wrong. try again later!");
					}
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				showError.setText("Please Fill all the fields");
			}
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}




















