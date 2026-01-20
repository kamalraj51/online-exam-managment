package com.vastpro.onlineexam.dto;

public class Exam {
	
	private int examId;
    private String examName;
    private String description;
    private int duration;
    private int passMarks;

    public int getExamId() {
    	return examId;
    }
    public void setExamId(int examId) {
    	this.examId = examId; 
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

    public int getDuration() { 
    	return duration; 
    }
    public void setDuration(int duration) { 
    	this.duration = duration; 
    }

    public int getPassMarks() { 
    	return passMarks; 
    }
    public void setPassMarks(int passMarks) {
    	this.passMarks = passMarks;
    }

}
