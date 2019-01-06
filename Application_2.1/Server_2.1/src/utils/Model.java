package utils;

import java.sql.*;

public class Model {

	private Connection conn = null;
	private Statement stmt = null; 
	
	public Model(){
		
	}
	
	private void connectDB() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data.db");
			
			conn.setAutoCommit(false);
			
			Helpers.Status("Model Class : Database Connected");
			
		}catch(Exception e) {
			Helpers.Debug("Model Class : Model() Database Connection error = " +e.toString());
		}
	}
	
	public boolean INSERT(String sql) {
		
		try {
			
			connectDB();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
						
			stmt.close();
			conn.commit();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			Helpers.Debug("Model Class : INSERT = " +e.toString());
		}
		
		close();
		
		return false;
	}
	
	public ResultSet SELECT(String sql) {
			
		try {
			connectDB();
			
			stmt = conn.createStatement();
			stmt.close();
			
			return stmt.executeQuery(sql);
		
		} catch (SQLException e) {
			Helpers.Debug("Model Class : SELECT = " +e.toString());
		}
		
		close();

		return null;
	}
	
	public boolean UPDATE(String sql) {

		try {
			connectDB();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			 pstmt.executeUpdate();
			 conn.commit();
			 conn.close();
			 
			 return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return false;
	}
	
	private void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}











