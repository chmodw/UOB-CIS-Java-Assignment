package utils;

import java.sql.*;

public class Model {

	private Connection conn = null;
	private Statement stmt = null; 
	
	public Model() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data.db");
			conn.setAutoCommit(false);
			Helpers.Status("Database Connected");
			
		}catch(Exception e) {
			Helpers.Debug("Model Class : Model() Database Connection error = " +e.toString());
		}
	}
	
	public boolean INSERT(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			Helpers.Debug("Model Class : INSERT = " +e.toString());
		}
		
		return false;
	}
	
	public ResultSet SELECT(String sql) {
		
		try {
			stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Helpers.Debug("Model Class : SELECT = " +e.toString());
		}

		return null;
	}
	

	
	public void close() throws SQLException {
        conn.close();
	}
	
}
