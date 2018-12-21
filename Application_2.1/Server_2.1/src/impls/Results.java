package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import application.Question;
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
	private int resultCount = 0; //how many people participated
	private String sql; 
	private String[] params; // params for filter results
	private ArrayList<Question> qList; // question list
	private Map<String, Integer[]> results = new HashMap<String, Integer[]>(); // <question id, [sdc,dc,ac,sac]>
	
	private Map<String, Integer> SARResult = new HashMap<String, Integer>();
	
	private int anger;
	private int sadness;
	private int joy;
	private int fear;
	private int others;
	
	public Results() throws RemoteException {
		model = new Model();
	}
	
	@Override
	public void readyResults() {
		
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
		return resultCount;
	}
	
	private void setResultCount() {
		
		//reset the result count
		resultCount = 0;
		
		sql = "SELECT * FROM participant_data";
		ResultSet rs = model.SELECT(sql);
		
		try {
			while(rs.next()) {
				this.resultCount++;
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
				
			results.put(qList.get(i).getId(),new Integer[]{sdc,dc,ac,sac});
				
		}

		
	}

	@Override
	public Map<String, Integer[]> getResluts() throws RemoteException {
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
		
		SARResult.put("joy", 100 / resultCount * joy); //get percentage
		SARResult.put("sadness", 100 / resultCount * sadness);
		SARResult.put("anger", 100 / resultCount * anger);
		SARResult.put("fear", 100 / resultCount * fear);
		SARResult.put("others", 100 / resultCount * others);
		
		
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
				
			}
			
		} catch (SQLException e) {
		
			Helpers.Debug("Can't Get Participents for SAR Results - " + e.toString());
		
		}
		
	}
			
}