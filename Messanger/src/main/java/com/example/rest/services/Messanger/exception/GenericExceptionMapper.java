package com.example.rest.services.Messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.rest.services.Messanger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage em = new ErrorMessage(exception.getMessage(), 500, "google");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(em).build();
	}

}
