package userControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainUserController implements Initializable {
	
	@FXML private StackPane userMainWindow;
	
	@FXML private VBox surveyForm;
	
	@FXML private TextField fullNameTxt;
	@FXML private TextField emailTxt;
	@FXML private ComboBox<String> countryTxt;
	@FXML private TextField TDMTxt;
	@FXML private ComboBox<String> TDOTxt;
	
	@FXML private Label fullNameError;
	@FXML private Label emailError;
	@FXML private Label countryError;
	@FXML private Label TDMError;
	@FXML private Label TDOError;
	
	List<String> os = new ArrayList<String>();
	List<String> deviceMan = new ArrayList<String>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/**
		 * Add countries to the combo box
		 */
		ObservableList<String> countries = Stream.of(Locale.getISOCountries())
		        .map(locales -> new Locale("", locales))
		        .map(Locale::getDisplayCountry)
		        .collect(Collectors.toCollection(FXCollections::observableArrayList));

		countryTxt.getItems().addAll(countries);
		
		/**
		 * ADd OSs to the combo
		 */
		os.add("Andorid");
		os.add("ios");
		
		TDOTxt.getItems().addAll(os);
				
		/**
		 * Full name text box text change
		 */
		fullNameTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			fullNameError.setText("");
		});
		
		/**
		 * email text box text change
		 */
		emailTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			emailError.setText("");
		});
				
		 
	}
	
	@FXML
	public void startSuervey() throws IOException {
		
		if(!isTextFieldEmpty(fullNameTxt, "Please enter your name", fullNameError) && 
		   !isTextFieldEmpty(emailTxt, "Please enter your Email address", emailError) &&
		   !iscomboSelected(countryTxt, "Please enter your Country of Residence", countryError) &&
		   !isTextFieldEmpty(TDMTxt, "Please enter your device manufacturer", TDMError) &&
		   !iscomboSelected(TDOTxt, "Please enter your device OS", TDOError)) {
			
			
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("../userGuis/SurveyQuestions.fxml").openStream());
			SurveyController surveyController = (SurveyController)loader.getController();
			//pass the user information the questions window
			surveyController.setCurrentUser(fullNameTxt.getText().toString(),emailTxt.getText().toString(),countryTxt.getValue(), TDMTxt.getText(), TDOTxt.getValue());
			
			// remove the form from the main window
			userMainWindow.getChildren().remove(surveyForm);
		
        	//Load the questions window in the main window
			userMainWindow.getChildren().add(root);
			
		}
	
	}
	
	@FXML
	public void developerLogin() {

        try {
        	Parent root = FXMLLoader.load(getClass().getResource("../developerGuis/DeveloperLogin.fxml"));
            
			// remove the form from the main window
			userMainWindow.getChildren().remove(surveyForm);
		
        	//Load the questions window in the main window
			userMainWindow.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * return true if a text field empty
	 * @param fieldName
	 * @param errorMsg
	 * @param errorField
	 */
	private boolean isTextFieldEmpty(TextField fieldName, String errorMsg, Label errorField) {
		
        if(fieldName.getText().isEmpty()) {
            errorField.setText(errorMsg);
            return true;
         }
        
        return false;
        
	}
	
	private boolean iscomboSelected(ComboBox<String> fieldName, String errorMsg, Label errorField) {
		
        if(fieldName.getSelectionModel().isEmpty()) {
            errorField.setText(errorMsg);
            return true;
         }
		
		return false;
	}
}
