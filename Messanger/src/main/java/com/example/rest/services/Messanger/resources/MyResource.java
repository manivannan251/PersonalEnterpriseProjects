package com.example.rest.services.Messanger.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.annotation.processing.Messager;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

import com.example.rest.services.Messanger.bean.MessageFilterBean;
import com.example.rest.services.Messanger.model.Message;
import com.example.rest.services.Messanger.service.MessageService;

@Path("/messages")
public class MyResource {
	
	static MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Json method called");
		if(filterBean.getYear()>0)
			return msgService.getAllMessagesInYear(filterBean.getYear());
		if(filterBean.getStart() >=0 && filterBean.getSize() >0)
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		return msgService.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Xml method called ");
		if(filterBean.getYear()>0)
			return msgService.getAllMessagesInYear(filterBean.getYear());
		if(filterBean.getStart() >=0 && filterBean.getSize() >0)
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		return msgService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message,@Context UriInfo uriInfo) {
		Message newMessage = msgService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri).entity(newMessage).build();
		
	}
	
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);		
		return msgService.updateMessage(message);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id,@Context UriInfo uriInfo) {
		Message message =  msgService.getMessage(id);		
		message.addLink(getMessageUrlInfo(uriInfo, message), "self");
		message.addLink(getProfileUrlInfo(uriInfo, message), "profile");
		message.addLink(getCommentUrlInfo(uriInfo, message), "comment");
		return message;
	}
	
	private String getProfileUrlInfo(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build()
				.toString();
	}
	
	private String getCommentUrlInfo(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(MyResource.class)
				.path(MyResource.class,"getComments")
				.path(CommentResource.class).resolveTemplate("messageId",message.getId()).build().toString();
	}

	private String getMessageUrlInfo(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(MyResource.class)
					 .path(Long.toString(message.getId())).build().toString();
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		msgService.removeMessage(id);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getComments() {
		return new CommentResource();
	}
}
