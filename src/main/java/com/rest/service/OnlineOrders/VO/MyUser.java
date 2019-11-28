package com.rest.service.OnlineOrders.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MyUser {
	
@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
private String userID;

private String userName;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

private String role;

private String password;

public String getUserID() {
	return userID;
}

public void setUserID(String userID) {
	this.userID = userID;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getuserID() {
	return userID;
}

public void setuserID(String userID) {
	this.userID = userID;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}
