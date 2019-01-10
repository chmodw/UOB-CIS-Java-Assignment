package application;

import java.io.Serializable;

/**
 * Creates a result object
 * @author Chamodya Wimansha
 *
 */
public class Result  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String question;
	private String questionId;
	private int answerCount;
	private int stronglyDissagreeCount;
	private int dissagreeCount;
	private int agreeCount;
	private int stronglyAgreeCount;
	
	/**
	 * Constructor function
	 * @param question
	 * @param questionId
	 * @param answerCount
	 * @param stronglyDissagreeCount
	 * @param dissagreeCount
	 * @param agreeCount
	 * @param stronglyAgreeCount
	 */
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
	/**
	 * 
	 * @param question2
	 */
	public Result(String question2) {
		this.question = question2;
	}
	/**
	 * returns the question
	 * @return
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * returns the question id
	 * @return
	 */
	public String getQuestionId() {
		return questionId;
	}
	/**
	 * returns the answer count
	 * @return
	 */
	public int getAnswerCount() {
		return answerCount;
	}
	/**
	 * returns the Strongly Disagree Count
	 * @return
	 */
	public int getStronglyDissagreeCount() {
		return stronglyDissagreeCount;
	}
	/**
	 * 
	 * @return
	 */
	public int getDissagreeCount() {
		return dissagreeCount;
	}
	/**
	 * 
	 * @return
	 */
	public int getAgreeCount() {
		return agreeCount;
	}
	/**
	 * 
	 * @return
	 */
	public int getStronglyAgreeCount() {
		return stronglyAgreeCount;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Question=" + question + ", Question Id=" + questionId + ", answerCount=" + answerCount
						+ ", stronglyDissagreeCount=" + stronglyDissagreeCount + ", dissagreeCount=" + dissagreeCount
						+ ", agreeCount=" + agreeCount + ", stronglyAgreeCount=" + stronglyAgreeCount;
	}
	
	

}
