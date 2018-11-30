package models;

import java.sql.*;

import utils.Logger;

public class Model{

	private Connection conn = null;
	private Statement stmt = null;
	
	public Model(String dbName) {
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+dbName+"_data.db");
			conn.setAutoCommit(false);
			Logger.log("Database Connected");
			
		}catch(Exception e) {
			Logger.log(e.toString());
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
//			Logger.log(e);
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
		return false;
	}
	
	public ResultSet SELECT(String sql) {
		
		try {
			stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.log(e);
		}

		return null;
	}
	

	
	public void close() throws SQLException {
        conn.close();
	}
	
}
