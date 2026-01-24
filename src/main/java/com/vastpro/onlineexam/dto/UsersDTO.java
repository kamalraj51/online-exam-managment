package com.vastpro.onlineexam.dto;

public class UsersDTO {
String username;
String userId;
@Override
public String toString() {
	return "UsersDTO [username=" + username + ", userId=" + userId + "]";
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public UsersDTO(String username, String userId) {
	super();
	this.username = username;
	this.userId = userId;
}
UsersDTO(){}
}
