package com.rest.service.OnlineOrders.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "MY_USER")
public class MyUser {
	
@Id@GeneratedValue(strategy=GenerationType.AUTO)
private Long userID;

private String userName;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

private String role;

private String password;

public Long getUserID() {
	return userID;
}

public void setUserID(Long userID) {
	this.userID = userID;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}
