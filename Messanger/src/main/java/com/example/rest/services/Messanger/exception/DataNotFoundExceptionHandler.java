package com.example.rest.services.Messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.rest.services.Messanger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionHandler implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage em = new ErrorMessage(exception.getMessage(), 214, "google");
		return Response.status(Status.NOT_FOUND).entity(em).build();
	}

}
