package com.example.rest.services.Messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.example.rest.services.Messanger.model.Message;
import com.example.rest.services.Messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
}
