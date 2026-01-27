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
	private int examId;
	private String examTopic;
	private String examName;
	private String description;
	private String status; 
	private int duration;
    private int passMarks;
    private int totalMarks;
    private int createdBy;
    //below code for history// exam name, date/time, score, correct/incorrect/unanswered, pass/fail.
    private String result;
    private double durationTaken;
    private int yourMarks;
    private int userId;
    private Timestamp dateTime;
    private String correct; 
    private String incorrect;
    private String unanswered;
    
	public ExamHistoryDTO(int examId, String examTopic, String examName, String description, String status,
			int duration, int passMarks, int totalMarks, int createdBy, String result, double durationTaken,
			int yourMarks, int userId, Timestamp dateTime, String correct, String incorrect, String unanswered) {
		super();
		this.examId = examId;
		this.examTopic = examTopic;
		this.examName = examName;
		this.description = description;
		this.status = status;
		this.duration = duration;
		this.passMarks = passMarks;
		this.totalMarks = totalMarks;
		this.createdBy = createdBy;
		this.result = result;
		this.durationTaken = durationTaken;
		this.yourMarks = yourMarks;
		this.userId = userId;
		this.dateTime = dateTime;
		this.correct = correct;
		this.incorrect = incorrect;
		this.unanswered = unanswered;
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



	public ExamHistoryDTO(int examId, String examTopic, String examName, String description, String status,
			int duration, int passMarks, int totalMarks, int createdBy, String result, double durationTaken,
			int yourMarks, int userId) {
		super();
		this.userId = userId;
		this.examId = examId;
		this.examTopic = examTopic;
		this.examName = examName;
		this.description = description;
		this.status = status;
		this.duration = duration;
		this.passMarks = passMarks;
		this.totalMarks = totalMarks;
		this.createdBy = createdBy;
		this.result = result;
		this.durationTaken = durationTaken;
		this.yourMarks = yourMarks;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getResult() {
		return result;
	}







	@Override
	public String toString() {
		return "ExamHistoryDTO [examId=" + examId + ", examTopic=" + examTopic + ", examName=" + examName
				+ ", description=" + description + ", status=" + status + ", duration=" + duration + ", passMarks="
				+ passMarks + ", totalMarks=" + totalMarks + ", createdBy=" + createdBy + ", result=" + result
				+ ", durationTaken=" + durationTaken + ", yourMarks=" + yourMarks + ", userId=" + userId + ", dateTime="
				+ dateTime + ", correct=" + correct + ", incorrect=" + incorrect + ", unanswered=" + unanswered + "]";
	}



	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamTopic() {
		return examTopic;
	}

	public void setExamTopic(String examTopic) {
		this.examTopic = examTopic;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int d) {
		this.duration = d;
	}

	public int getPassMarks() {
		return passMarks;
	}

	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String isResult() {
		return result;
	}

	public void setResult(String string) {
		this.result = string;
	}

	public double getDurationTaken() {
		return durationTaken;
	}

	public void setDurationTaken(double durationTaken) {
		this.durationTaken = durationTaken;
	}

	public int getYourMarks() {
		return yourMarks;
	}

	public void setYourMarks(int yourMarks) {
		this.yourMarks = yourMarks;
	}
    
	
	public ExamHistoryDTO(){}
    
}
