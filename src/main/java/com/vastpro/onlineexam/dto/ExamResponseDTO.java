package com.vastpro.onlineexam.dto;
/**
 * Class Name: ExamResponseDTO
 *
 * Description:
 * This DTO represents a user's response to a question
 * along with correctness and option details.
 */
public class ExamResponseDTO {
    private Integer responseId;
    private Integer questionId;
    private Integer selectedOptionId;
    private Boolean isCorrect;
    private String questionText;
    private String selectedOptionText;
    private String correctOptionText;

 
    public Integer getResponseId() { return responseId; }
    public void setResponseId(Integer responseId) { this.responseId = responseId; }
    public Integer getQuestionId() { return questionId; }
    public void setQuestionId(Integer questionId) { this.questionId = questionId; }
    public Integer getSelectedOptionId() { return selectedOptionId; }
    public void setSelectedOptionId(Integer selectedOptionId) { this.selectedOptionId = selectedOptionId; }
    public Boolean isCorrect() { return isCorrect; }
    public void setCorrect(Boolean correct) { isCorrect = correct; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String getSelectedOptionText() { return selectedOptionText; }
    public void setSelectedOptionText(String selectedOptionText) { this.selectedOptionText = selectedOptionText; }
    public String getCorrectOptionText() { return correctOptionText; }
    public void setCorrectOptionText(String correctOptionText) { this.correctOptionText = correctOptionText; }
	@Override
	public String toString() {
		return "ExamResponseDTO [responseId=" + responseId + ", questionId=" + questionId + ", selectedOptionId="
				+ selectedOptionId + ", isCorrect=" + isCorrect + ", questionText=" + questionText
				+ ", selectedOptionText=" + selectedOptionText + ", correctOptionText=" + correctOptionText + "]";
	}
    
    
}
