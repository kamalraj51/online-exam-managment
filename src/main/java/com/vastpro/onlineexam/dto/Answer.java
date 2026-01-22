package com.vastpro.onlineexam.dto;

public class Answer {
    private int answerId;
    private String optionText;
   private boolean isCorrect;
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", optionText=" + optionText + "]";
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public Answer(int answerId, String optionText) {
		super();
		this.answerId = answerId;
		this.optionText = optionText;
	}
	public boolean isCorrect() {

		return isCorrect;
	}
	public Answer() {}
    
}

