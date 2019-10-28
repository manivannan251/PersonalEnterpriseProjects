package com.example.rest.services.Messanger.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.rest.services.Messanger.model.Profile;
import com.example.rest.services.Messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private static ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllResources() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String name) {
		return profileService.getProfile(name);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String name, Profile profile) {
		return profileService.updateProfile(profile,name);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void deleteProfile(@PathParam("profileName") String name) {
		profileService.deleteProfile(name);
	}
}
