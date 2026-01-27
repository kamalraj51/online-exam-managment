package com.vastpro.onlineexam.dto;

import java.sql.Timestamp;

/**
 * this class is DTO for user history
 */

public class UserBasedHistoryDTO {


	private String examName;
    private int yourMarks;
    private Timestamp dateTime;
    private String correct; 
    private String incorrect;
    private String unanswered;
    private String result;
	@Override
	public String toString() {
		return "UserBasedHistoryDTO [examName=" + examName + ", yourMarks=" + yourMarks + ", dateTime=" + dateTime
				+ ", correct=" + correct + ", incorrect=" + incorrect + ", unanswered=" + unanswered + ", result="
				+ result + "]";
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getYourMarks() {
		return yourMarks;
	}
	public void setYourMarks(int yourMarks) {
		this.yourMarks = yourMarks;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(String incorrect) {
		this.incorrect = incorrect;
	}
	public String getUnanswered() {
		return unanswered;
	}
	public void setUnanswered(String unanswered) {
		this.unanswered = unanswered;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public UserBasedHistoryDTO(String examName, int yourMarks, Timestamp dateTime, String correct, String incorrect,
			String unanswered, String result) {
		super();
		this.examName = examName;
		this.yourMarks = yourMarks;
		this.dateTime = dateTime;
		this.correct = correct;
		this.incorrect = incorrect;
		this.unanswered = unanswered;
		this.result = result;
	}
    public UserBasedHistoryDTO() {}
}