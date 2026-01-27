package com.vastpro.onlineexam.dto;

public class UserDTO {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String rollId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getRollId() {
		return rollId;
	}
	public void setRollId(String rollId) {
		this.rollId = rollId;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", rollId=" + rollId + "]";
	}
	public UserDTO(String username, String password, String email, String rollId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.rollId = rollId;
	}

	public UserDTO() {}

}

