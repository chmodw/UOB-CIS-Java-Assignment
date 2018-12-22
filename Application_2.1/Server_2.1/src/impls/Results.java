package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.Question;
import application.Result;
import impls.Questionnaire;
import interfaces.IResults;
import utils.Helpers;
import utils.Model;


/**
 * 
 * @author chamo
 *
 */
public class Results extends UnicastRemoteObject implements IResults{

	
	private static final long serialVersionUID = 1L;
	private Model model; // model class. which has database functions
	private int participantCount; //how many people participated
	private String sql; 
	private String[] params; // params for filter results 
	private ArrayList<Question> qList; // question list
	private ArrayList<Result> results;
	
	private Map<String, Integer> SARResult = new HashMap<String, Integer>();
	
	private int anger = 0;
	private int sadness  = 0;
	private int joy  = 0;
	private int fear  = 0;
	private int others  = 0;
	
	public Results() throws RemoteException {
		model = new Model();
	}
	
	@Override
	public void readyResults() {
		
		results = new ArrayList<>();
		
		// Get the response count
		this.setResultCount();
		
		// Get the questions
		try {
			qList = new Questionnaire().getQuestions();
		} catch (RemoteException e) {
			Helpers.Debug("can't get the questions --Results - " + e.toString());	
		}
		
		//process results
		this.processResults();
		
		//process SAR
		this.processSARResults();			
		
	}
	
	@Override
	public int getResultCount() throws RemoteException {
		return participantCount;
	}
	
	private void setResultCount() {
		
		//reset the result count
		participantCount = 0;
		
		sql = "SELECT * FROM participant_data";
		ResultSet rs = model.SELECT(sql);
		
		try {
			while(rs.next()) {
				participantCount++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private void processResults() {

		//loop through the question list and find the result for that question.
		for(int i = 0; qList.size() > i; i++) {	
			
			// Strongly Disagree Count
			int sdc = 0;
			// Disagree Count
			int dc = 0;
			// Agree Count
			int ac = 0;
			// Strongly agree Count
			int sac = 0;
			

			// Find answered questions from the results table where question id equivalent to 
			// the current question id in the loop
			sql = "SELECT * FROM results WHERE question_id = '" + qList.get(i).getId() + "'";
			
			ResultSet res = model.SELECT(sql);

			// Loop through the found answered questions
			try {
				
				while(res.next()) {
					if(res.getString("answer").equals("Strongly Disagree")) {
						sdc++;
						continue;
					}else if (res.getString("answer").equals("Disagree")) {
						dc++;
						continue;
					}else if (res.getString("answer").equals("Agree")) {
						ac++;
						continue;
					}else if (res.getString("answer").equals("Strongly Agree")) {
						sac++;
						continue;
					}
				} 
			} catch (SQLException e) {
					
				Helpers.Debug("something happent when looping through the results --answerd_results - " + e.toString());
			}
				
			results.add(new Result(qList.get(i).getQuestion(), qList.get(i).getId(), participantCount, sdc, dc, ac, sac));
		}

		
	}

	@Override
	public ArrayList<Result> getResluts() throws RemoteException {
		return results;
	}

	@Override
	public void setParams(String[] params) throws RemoteException {
		/**
		 * Save this for later
		 */
	}

	@Override
	public Map<String, Integer> getSARResults() throws RemoteException {
		/**
		 * return results as a percentage
		 */

		
		
		return SARResult;
	}
	
	private void processSARResults() {
		
		//Get participant email addresses from the database
		sql = "SELECT * FROM participant_data";
		ResultSet res = model.SELECT(sql);
		
		try {
			// loop through the results to find participant response from the sentiment_analysis_results Table
			while(res.next()) {
				//look for current email from the sentiment_analysis_result table
				ResultSet rs = model.SELECT("SELECT * FROM sentiment_analysis_results WHERE email='" + res.getString("email") + "'");
				while(rs.next()) {
					
					switch(rs.getString("sa_result")) {
						case("sadness"):
							sadness++;
							break;
						case("joy"):
							joy++;
							break;
						case("fear"):
							fear++;
							break;
						case("anger"):
							anger++;
							break;
						default:
							others++;
					}
				}
				
//				SARResult.put("joy", 100 / participantCount * joy);
//				SARResult.put("sadness", 100 / participantCount * sadness);
//				SARResult.put("anger", 100 / participantCount * anger);
//				SARResult.put("fear", 100 / participantCount * fear);
//				SARResult.put("others", 100 / participantCount * others);
				
				SARResult.put("joy", joy);
				SARResult.put("sadness", sadness);
				SARResult.put("anger", anger);
				SARResult.put("fear", fear);
				SARResult.put("others", others);
				
			}
			
		} catch (SQLException e) {
		
			Helpers.Debug("Can't Get Participents for SAR Results - " + e.toString());
		
		}
		
	}
			
}