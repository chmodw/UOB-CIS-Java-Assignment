package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Logger;
/**
 * Database Connection class
 * @author chamo
 *
 */

public class Connection {
	
	protected java.sql.Connection conn = null;
	private String dbUrl;
	
	
	public Connection(String dbName) {
		switch(dbName) {
		case "user":
			this.dbUrl = "../data/user_data.db";
			this.connect();
			break;
		case "survey":
			this.dbUrl = "../data/survey_data.db";
			this.connect();
			break;
		}
	}

	public void connect() {
		try {
			//create connection with the database
	        this.conn = DriverManager.getConnection(this.dbUrl);
			
		} catch(SQLException e) {
			Logger.log(e.getMessage());
		}		
	}

}
