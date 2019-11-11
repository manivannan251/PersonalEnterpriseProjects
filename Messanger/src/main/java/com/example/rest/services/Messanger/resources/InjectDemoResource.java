package com.example.rest.services.Messanger.resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
		
	
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("name") String param,
			@HeaderParam("headervalue") String header,@CookieParam("JSESSIONID") String cookie) {
		return "Welcome "+param +" Header "+header+" Cookie"+cookie;
	}
	
	
	@GET
	@Path("context")
	public String getContextUsingParams(@Context UriInfo uriInfo,@Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		Map<String,Cookie> cookie = headers.getCookies();
		return "Path :"+path+"cookie :"+cookie.toString();
	}
}
