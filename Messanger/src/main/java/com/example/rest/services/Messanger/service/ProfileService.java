package com.example.rest.services.Messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.rest.services.Messanger.database.DatabaseClass;
import com.example.rest.services.Messanger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Bulma", new Profile(1L, "Bulma", "Bulma", "Vegeta"));
		profiles.put("Goku", new Profile(2L, "Goku", "Goku", "Bardock"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}
	
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile,String name) {
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;		
	}
	
	public void deleteProfile(String name) {
		profiles.remove(name);
	}
}
