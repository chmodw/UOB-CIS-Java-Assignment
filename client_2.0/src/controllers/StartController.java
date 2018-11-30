package controllers;

import java.rmi.RemoteException;

import classes.UserClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartController{
	
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
	
	private boolean bool;
	
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
					bool = userClient.saveParticipant(fullName,email,age,country,testDeviceManufacturer,os);
					
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

}




















