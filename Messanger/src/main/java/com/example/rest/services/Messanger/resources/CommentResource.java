package com.example.rest.services.Messanger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.rest.services.Messanger.model.Comment;
import com.example.rest.services.Messanger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	static CommentService CommentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return CommentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId) {
		return CommentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(Comment comment, @PathParam("messageId") long messageId) {
		return CommentService.addComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId) {
		return CommentService.removeComment(messageId, commentId);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId,Comment comment) {
		comment.setId(commentId);
		return CommentService.updateComment(messageId, comment);
	}
}
