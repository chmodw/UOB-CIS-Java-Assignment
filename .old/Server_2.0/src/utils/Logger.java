package utils;

import java.sql.SQLException;

/**
 * This class use for log errors and other important messages;
 * @author chamo
 *
 */

public class Logger {
	
	private static String log;
	
	public Logger(String log) {
	
	}
	
	public static void log(String newLog) {
		log = newLog;
	}
	
	public static void print() {
		System.out.print(log);
	}

	public static void log(StackTraceElement[] stackTrace) {
		// TODO Auto-generated method stub
		
	}

	public static void log(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
}
