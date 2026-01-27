package com.vastpro.onlineexam.dto;

import java.sql.Timestamp;

public class ExamBasedHistoryDTO {

	private String userName;
    private Timestamp dateTime;
    private int score;
    private boolean result;
    public ExamBasedHistoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public ExamBasedHistoryDTO(String userName, Timestamp dateTime, int score, boolean result) {
		super();
		this.userName = userName;
		this.dateTime = dateTime;
		this.score = score;
		this.result = result;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ExamBasedHistoryDTO [userName=" + userName + ", dateTime=" + dateTime + ", score=" + score + ", result=" + result + "]";
	}
    
    
}
