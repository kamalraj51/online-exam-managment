package com.vastpro.onlineexam.dto;

public class ExamAttemptDTO {

	private int examId;
	private String examTopic;
	private String examName;

	private int userId;
	private String username;

	private String date;
	private String time;
	private int score;
	private String result;
	private int correct;
	private int incorrect;
	private int unanswered;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		this.score = i;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}

	public int getUnanswered() {
		return unanswered;
	}

	public void setUnanswered(int unanswered) {
		this.unanswered = unanswered;
	}

}