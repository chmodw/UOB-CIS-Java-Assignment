package application;

import java.io.Serializable;

public class Result  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String question;
	private String questionId;
	private int answerCount;
	private int stronglyDissagreeCount;
	private int dissagreeCount;
	private int agreeCount;
	private int stronglyAgreeCount;
	
	
	public Result(String question, String questionId, int answerCount, int stronglyDissagreeCount, int dissagreeCount,
					int agreeCount, int stronglyAgreeCount) {
		super();
		this.question = question;
		this.questionId = questionId;
		this.answerCount = answerCount;
		this.stronglyDissagreeCount = stronglyDissagreeCount;
		this.dissagreeCount = dissagreeCount;
		this.agreeCount = agreeCount;
		this.stronglyAgreeCount = stronglyAgreeCount;
	}
	
	public Result(String question2) {
		this.question = question2;
	}

	public String getQuestion() {
		return question;
	}
	public String getQuestionId() {
		return questionId;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public int getStronglyDissagreeCount() {
		return stronglyDissagreeCount;
	}
	public int getDissagreeCount() {
		return dissagreeCount;
	}
	public int getAgreeCount() {
		return agreeCount;
	}
	public int getStronglyAgreeCount() {
		return stronglyAgreeCount;
	}

	@Override
	public String toString() {
		return "Question=" + question + ", Question Id=" + questionId + ", answerCount=" + answerCount
						+ ", stronglyDissagreeCount=" + stronglyDissagreeCount + ", dissagreeCount=" + dissagreeCount
						+ ", agreeCount=" + agreeCount + ", stronglyAgreeCount=" + stronglyAgreeCount;
	}
	
	

}
