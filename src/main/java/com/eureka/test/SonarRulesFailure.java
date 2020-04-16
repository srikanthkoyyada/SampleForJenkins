package com.eureka.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SonarRulesFailure {

	StringBuffer buffer = new StringBuffer("Srikanth");
	//String password="srikanth";
	
	public void getConnection() {
	
	Connection conn = null;
	try {
	  conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
	        "user=steve&password=blue"); 
	  
	  String uname = getEncryptedUser();
	  String password = getEncryptedPassword();
	  conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
	        "user=" + uname + "&password=" + password); 

	  java.net.PasswordAuthentication pa = new java.net.PasswordAuthentication("userName", "1234".toCharArray());  
	  
	}
	catch(SQLException exception) {
		System.out.println(exception.getMessage());
	}
	}
	
	private String getEncryptedUser() {
		return "user";
	}
	
	private String getEncryptedPassword() {
		return "password";
	}

}
