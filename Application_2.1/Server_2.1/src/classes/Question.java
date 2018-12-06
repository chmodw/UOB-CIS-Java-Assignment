package classes;

public class Question {
	
	private String questionId;//remove spaces and chars
	private String question;
	private String answer;
	private String answerdOn;
	
	public Question(String question) {
		
		super();
		setQuestionId(question);		
		this.question = question;
	}

	public Question(String questionId, String question, String answer, String answerdOn) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
		this.answerdOn = answerdOn;
	}
	
	public void setQuestionId(String question) {
		this.questionId = question.replaceAll("[^a-zA-Z]+", "");
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getAnswerdOn() {
		return answerdOn;
	}

}
