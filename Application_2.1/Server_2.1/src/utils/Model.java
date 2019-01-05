package utils;

import java.sql.*;

public class Model {

	private Connection conn = null;
	private Statement stmt = null; 
	private PreparedStatement pstmt;
	
	public Model(String dbName) {
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+dbName+".data.db");
			
			conn.setAutoCommit(false);
			Helpers.Status("Model Class : Database Connected");
			
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
			stmt.close();	
			
			return stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Helpers.Debug("Model Class : SELECT = " +e.toString());
		}

		return null;
	}
	
	public boolean UPDATE(String sql) {
		
		try {
			pstmt = conn.prepareStatement(sql);
			
	          pstmt.setString(1, "Test");
//	          pstmt.setString(2, "false");
	          pstmt.setInt(2, 1);
			
			 System.out.println(pstmt.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}











