package utils;

import java.sql.*;

public class Model {

	private Connection conn = null;
	private Statement stmt = null; 
	
	public Model(){
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data.db");
			
			conn.setAutoCommit(false);
			
			Helpers.Status("Model Class : Database Connected");
			
		}catch(Exception e) {
			Helpers.Debug("Model Class : Model() Database Connection error = " +e.toString());
		}
	}

	public boolean EXECUTE(String sql) {
		
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
			stmt.close();
			
			return stmt.executeQuery(sql);
		
		} catch (SQLException e) {
			Helpers.Debug("Model Class : SELECT = " +e.toString());
		}
		
		return null;
	}
	
	public boolean UPDATE(String sql) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			 pstmt.executeUpdate();
			 conn.commit();
			 
			 return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

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












//package utils;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Model {
//	
//	Connection conn = null;
//	Statement stmt = null; 
//	
//	private String dbPath = "jdbc:hsqldb:file:../data/data";
//	private String dbuser = "SA";
//	private String dbpass = "";
//	
//	int res = 0;
//	
//
//	public Model(){
//
//		try {
//			
//			Class.forName("org.hsqldb.jdbc.JDBCDriver");
//			conn = DriverManager.getConnection(dbPath, dbuser, dbpass);
//			Helpers.Debug("Database Connected");
//			
//		}catch(Exception e) {
//			Helpers.Debug("Model Class : Model() Database Connection error = " +e.toString());
//		}
//		
//		
//		try {
//			
//			String sql = "INSERT INTO questions VALUES ('Overall look and feel of the app is innovative and updated','true','2018/12/15 09:02:01');";
//			
//			stmt = conn.createStatement(); 
//			
//			res = stmt.executeUpdate(sql);
//			
//			conn.commit();
//			
//			System.out.println(res+" rows effected"); 
//			
//		}catch(Exception e) {
//			Helpers.Debug("save error " +e.toString());
//		}
//		
//
//
//
//	}
//
//	
//	public boolean INSERT(String sql) {
//		
//		
//		
//		return false;
//	}
//	
//	public ResultSet SELECT(String sql) {
//			
//		
//
//		return null;
//	}
//	
//	public boolean UPDATE(String sql) {
//
//
//		return false;
//	}
//	
//}