package com.vastpro.onlineexam.dto;

import java.util.List;

public class Question {
    private int questionId;
    private String questionText;
    private List<Answer> answers;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", answers=" + answers + "]";
	}
	public Question(int questionId, String questionText, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.answers = answers;
	}
	public Question(){}
}
