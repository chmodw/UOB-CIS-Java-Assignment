package rmi.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import models.Model;
import rmi.interfaces.IResults;
import utils.SurveyToneAnalyzer;

public class IMPLResults extends UnicastRemoteObject  implements IResults{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IMPLResults() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[][] processResults() throws RemoteException {
		
		
		
		int[][] questionResults = new int[9][4];

		int sdaCount;
		int daCount;
		int aCount;
		int saCount;
		int qcount = 0;
		
		try {
			
			
			String sql = "SELECT * FROM questions";
			ResultSet rs = new Model("survey").SELECT(sql);
			

			
			while(rs.next()) {
				
				sdaCount = 0;
				daCount = 0;
				aCount = 0;
				saCount = 0;
				
				String sql2 = "SELECT * FROM answers WHERE question='"+rs.getString("question")+"'";
				
				
				ResultSet rs2 = new Model("new_survey").SELECT(sql2);
				
				while(rs2.next()) {
					
					if(rs2.getString("answer").equals("Strongly Disagree")) {
						sdaCount+=1;
					}else if(rs2.getString("answer").equals("Disagree")){
						daCount+=1;
					}else if(rs2.getString("answer").equals("agree")){
						aCount+=1;
					}else if(rs2.getString("answer").equals("Strongly agree")){
						saCount+=1;
					}	
				}
				
				questionResults[qcount][0] = sdaCount;
				questionResults[qcount][1] = daCount;
				questionResults[qcount][2] = aCount;
				questionResults[qcount][3] = saCount;
				
				qcount +=1;
				
//				System.out.println(rs.getString("question")+ " --- | SDA " + sdaCount + " | DA " + daCount + " | A " + aCount + " | SA " + saCount);
				
			}
			
			return questionResults;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void sentimentAnalysis() throws RemoteException {
		// TODO Auto-generated method stub
		
		
		String sql = "SELECT * FROM answers WHERE question='User Comment'";
		
		ResultSet rs = new Model("new_survey").SELECT(sql);
		
		try {
			while(rs.next()) {
				
				try {
//					new SurveyToneAnalyzer(rs.getString("answer")).analyze();
					System.out.println(rs.getString("answer"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
