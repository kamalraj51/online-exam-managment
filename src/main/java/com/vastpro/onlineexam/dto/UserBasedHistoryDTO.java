package com.vastpro.onlineexam.dto;

/**
 * this class is DTO for user history
 */

public class UserBasedHistoryDTO {


	private String examName;
    private int yourMarks;
    private String date;
    private String timeStamp;
    private String correct; 
    private String incorrect;
    private String unanswered;
    private String result;
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
	
 
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String string) {
		this.timeStamp = string;
	}
	public UserBasedHistoryDTO() {}
}