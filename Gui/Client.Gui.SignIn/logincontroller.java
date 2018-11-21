package application;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.events.MouseEvent;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class logincontroller extends Application {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    void closeApp(MouseEvent event) {

    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
