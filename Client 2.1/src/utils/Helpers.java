package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Helpers {

	public static String DateNow() {
		return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	public static void Debug(String text) {
		System.out.println(text);
	}
	
	public static void Status(String text) {
		System.out.println(text);
	}
	
	public static void ErrorLog(String text) {
		
	}
	
	public static void ErrorAlert(String message) {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Application Error");
		
		alert.setContentText(message);
		alert.showAndWait();
	}
	
}
