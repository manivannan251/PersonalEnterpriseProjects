package com.example.mani.service;

import java.util.HashMap;
import java.util.Map;

import com.example.mani.dto.UserDetails;

public class LoginService {
	
	Map<String,String> userDetails = new HashMap<>();
	
	public LoginService() {
		userDetails.put("pm", "manivannan");
		userDetails.put("in", "indhumathi");
		userDetails.put("pk", "karthi");
		userDetails.put("gp", "panneer");
	}
	
	
	public boolean authenticate(String uid,String pwd) {
		if(pwd==null || pwd.trim()=="")
			return false;
		return true;
	}
	
	public UserDetails getUserDetails(String userId) {
		UserDetails user = new UserDetails();
		user.setUserName(userDetails.get(userId));
		user.setUserId(userId);
		return user;
		
	}
}
