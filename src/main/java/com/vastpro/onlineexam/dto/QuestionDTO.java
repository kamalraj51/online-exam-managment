package com.vastpro.onlineexam.dto;

import java.util.List;
/**
 * Class Name: QuestionDTO
 *
 * Description:
 * This DTO class represents a question in an exam
 * along with its possible answers.
 */
public class QuestionDTO {
    private int questionId;
    private String questionText;
    private List<AnswerDTO> answers;
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
	public List<AnswerDTO> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", answers=" + answers + "]";
	}
	public QuestionDTO(int questionId, String questionText, List<AnswerDTO> answers) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.answers = answers;
	}
	public QuestionDTO(){}
}
