package utils;

import java.sql.*;

/**
 * Contains the Database operations
 * only this class have access to the database
 * other classes need instantiate this class in order to use 
 * the functions
 * @author Chamodya Wimansha
 *
 */
public class Model {

	private Connection conn = null;
	private Statement stmt = null; 
	
	/**
	 * Connect the database when instantiating
	 */
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
	
	/**
	 * execute sql queries like INSERT, Update
	 * @param sql
	 * @return
	 */
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
	/**
	 * Select data from the database
	 * @param sql
	 * @return
	 */
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
	/**
	 * Update 
	 * @param sql
	 * @return
	 */
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
}