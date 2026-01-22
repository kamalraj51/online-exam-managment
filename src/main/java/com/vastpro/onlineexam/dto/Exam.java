package com.vastpro.onlineexam.dto;

public class Exam {
	
	private int examId;
	private String examTopic;
	private String examName;
	private String description;
	 private String status; 
    private int duration;
    private int passMarks;
    private int totalMarks;
    private int createdBy;
    
    public String getExamTopic() {
		return examTopic;
	}
	public void setExamTopic(String examTopic) {
		this.examTopic = examTopic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
