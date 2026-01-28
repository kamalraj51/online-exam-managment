package com.vastpro.onlineexam.dto;

public class ExamBasedHistoryDTO {

	private String userName;
    private String date;
    private String time;
    private int score;
    private boolean result;
    public ExamBasedHistoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
    
}
