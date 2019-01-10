package application;

/**
 * creates a DocumentTone Object
 * use to convert the JSON file returning from the IBM tone analyser
 * to a Object
 * 
 * @author Chamodya Wimansha
 *
 */
public class DocumentTone {
	
	private Double score;
	private String tone_id;
	private String tone_name;
		
	public void setScore(Double score) {
		this.score = score;
	}

	public void setTone_id(String tone_id) {
		this.tone_id = tone_id;
	}

	public void setTone_name(String tone_name) {
		this.tone_name = tone_name;
	}
	public Double getScore() {
		return score;
	}
	public String getTone_id() {
		return tone_id;
	}
	public String getTone_name() {
		return tone_name;
	}
	
}
