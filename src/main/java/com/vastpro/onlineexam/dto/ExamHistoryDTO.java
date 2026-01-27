package com.vastpro.onlineexam.dto;

import java.sql.Timestamp;

/**
 * Class Name: ExamHistoryDTO
 *
 * Description:
 * This DTO class represents the exam history of a user.
 * It stores details such as exam information, user results,
 * marks, duration taken, and question statistics (correct/incorrect/unanswered).
 */
public class ExamHistoryDTO {
	//=========
	private String examName;
	private Timestamp dateTime;
	private int yourMarks;
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
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
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
	@Override
	public String toString() {
		return "ExamHistoryDTO [examName=" + examName + ", dateTime=" + dateTime + ", yourMarks=" + yourMarks
				+ ", correct=" + correct + ", incorrect=" + incorrect + ", unanswered=" + unanswered + ", result="
				+ result + "]";
	}
	public ExamHistoryDTO(String examName, Timestamp dateTime, int yourMarks, String correct, String incorrect,
			String unanswered, String result) {
		super();
		this.examName = examName;
		this.dateTime = dateTime;
		this.yourMarks = yourMarks;
		this.correct = correct;
		this.incorrect = incorrect;
		this.unanswered = unanswered;
		this.result = result;
	}
    public ExamHistoryDTO(){}
}