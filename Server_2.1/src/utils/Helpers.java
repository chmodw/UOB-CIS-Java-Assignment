package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Contains small methods
 * @author Chamodya Wimansha
 *
 */
public class Helpers {

	public static String DateNow() {
		return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	public static void Debug(String text) {
		System.out.println(text + "["+ DateNow() +"]");
	}
	
	public static void Status(String text) {
		System.out.println(text + "["+ DateNow() +"]");
	}
	
	public static void ErrorLog(String text) {
		
	}
	
}
