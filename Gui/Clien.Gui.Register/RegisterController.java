package application.register;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

public class RegisterController {

	@FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField passwordcheck;

    @FXML
    private JFXRadioButton bTester;

    @FXML
    private JFXRadioButton developer;
}
