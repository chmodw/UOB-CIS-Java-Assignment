package utils;

import java.util.ArrayList;

import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

public class SurveyToneAnalyzer {
	
	private String text;
	
	public SurveyToneAnalyzer(String text) {
		this.text = text;
	}
	
	public ToneAnalysis analyze() {
		
		try {
			IamOptions options = new IamOptions.Builder().apiKey("iyJGHXqpNoHfcP_k7lDcmU5Rik8adSgm8X2Lssry99Fd").build();

			ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2017-09-21", options);
			toneAnalyzer.setEndPoint("https://gateway.watsonplatform.net/tone-analyzer/api");
			
			ArrayList<String> tones = new ArrayList<>();
			
			tones.add("fear");
			tones.add("anger");
			tones.add("sadness");
			tones.add("joy");
			tones.add("disgust");
			tones.add("suprise");
			tones.add("trust");

			ToneOptions toneOptions = new ToneOptions.Builder().text(text).tones(tones).build();

			ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
			
			/**
			 * JSON
			 */
			return toneAnalysis;
			/**
			 * 
			 */
			
		} catch (NotFoundException e) {
		    // Handle Not Found (404) exception
			
			System.out.println("Not Found (404)");
			
		} catch (RequestTooLargeException e) {
		    // Handle Request Too Large (413) exception
			
			System.out.println("Too Large (413)");
			
		} catch (ServiceResponseException e) {
		    // Base class for all exceptions caused by error responses from the service
		    System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
		}
		return null;

	}

}
