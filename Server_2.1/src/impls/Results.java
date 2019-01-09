package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.txw2.Document;

import application.Question;
import application.Result;
import impls.Questionnaire;
import interfaces.IResults;
import main.Main;
import utils.Helpers;
import utils.Model;


/**
 * 
 * @author chamo
 *
 */
public class Results extends UnicastRemoteObject implements IResults{

	
	private static final long serialVersionUID = 1L;
	private int participantCount; //how many people participated
	private Model model;
	private String sql; 
	private String[] params = {"*",""}; // params for filter results 
	private ArrayList<Question> qList; // question list
	private ArrayList<Result> results;
	
	private Map<String, Integer> SARResult = new HashMap<String, Integer>();
	
	private int anger = 0;
	private int sadness  = 0;
	private int joy  = 0;
	private int fear  = 0;
	private int others  = 0;
	
	public Results() throws RemoteException {
		model = Main.getMainModel();
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
			
			/**
			 * Find answered questions from the results table where question id equivalent to the current question id in the loop
			 */
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
			
			
			/**
			 * all the results as a percentage
			 */
			results.add(new Result(qList.get(i).getQuestion(), qList.get(i).getId(), participantCount, 
							toPercentage(participantCount, sdc), 
							toPercentage(participantCount, dc),
							toPercentage(participantCount, ac),
							toPercentage(participantCount, sac)
							));		
		}

		
	}
	
	private int toPercentage(int total, int numPt) {
		
		if(numPt != 0) {
			return (int) Math.round(100 / total * numPt);
		}
		
		return 0;
	}

	@Override
	public ArrayList<Result> getResluts(String[] params) throws RemoteException {
		
		this.params = params;
		
		System.out.println(params[0]);
		
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
		
		return results;
	}

	@Override
	public void setParams(String[] params) throws RemoteException {
		this.params = params;
	}

	@Override
	public Map<String, Integer> getSARResults() throws RemoteException {
		/**
		 * return results as a percentage
		 */		
		return SARResult;
	}
	
	private void processSARResults(){
		
		int resultCount = 0;
		
		ResultSet rs = model.SELECT("SELECT * FROM sentiment_analysis_results");
		
		try {
			while(rs.next()) {
				resultCount++;
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

			SARResult.put("joy",toPercentage(resultCount, joy));
			SARResult.put("sadness", toPercentage(resultCount, sadness));
			SARResult.put("anger", toPercentage(resultCount, anger));
			SARResult.put("fear", toPercentage(resultCount, fear));
			SARResult.put("others", toPercentage(resultCount, others));
			
		} catch (SQLException e) {
			Helpers.ErrorLog("Can't caluculate SAR - " + e.toString());
		}
		
	}


	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ArrayList<String> getFilterParams(String filter) throws RemoteException {
		
		String fltr = "device_os";

		switch(filter) {
			case "Country": fltr = "country";
				break;
			case "OS": fltr = "device_os";
				break;
			case "Manufacturer": fltr = "device_manufacturer";
				break;
				
		}
		
		ArrayList<String> params = new ArrayList<>(); 
		
		String sql = "SELECT * FROM participant_data;";
		
		ResultSet res = model.SELECT(sql);

		try {
			while(res.next()) {

				params.add(res.getString(fltr));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// remove duplicates from the params
		
		for(int i=0;params.size()>i;i++) {
			for(int x=i+1; params.size()> x;x++) {
				if(params.get(i).equals(params.get(x))) {
					params.remove(x);
				}
			}
		}
		
		
		return params;
	}
	
	
	
	
	
	
	
	
	
	
	
			
}