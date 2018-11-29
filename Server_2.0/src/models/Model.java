package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import  utils.Connection;
import utils.Logger;

public class Model extends Connection{
	
	private Statement stmt;

	public Model(String dbName) {
		super(dbName);
		// TODO Auto-generated constructor stub
	}
	
	public boolean INSERT(String sql,) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			
		}catch (SQLException e) {
			Logger.log(e.getMessage());
		}
		
		return false;
	}
	
	public ResultSet SELECTALL(String sql){
		
		try{
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
		
			return rs;
		}catch (SQLException e) {
			Logger.log(e.getMessage());
		}
		
		return null;
	}
	
	public ResultSet FIND(String sql) throws SQLException {
		
//		PreparedStatement pstmt  = conn.prepareStatement(sql);
		
		return null;
	}
	
}
